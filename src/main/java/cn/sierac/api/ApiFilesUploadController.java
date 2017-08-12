package cn.sierac.api;

import cn.sierac.entity.*;
import cn.sierac.service.*;
import cn.sierac.utils.FileUtils;
import cn.sierac.utils.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 上传生存数据
 * Created by Jack on 2017/8/5.
 */
@RestController
@RequestMapping(value = "/api/codedata")
public class ApiFilesUploadController {

    @Autowired
    private CodeDataService codeDataService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CodeDataImportErrorService errorService;

    @Autowired
    private CodeDataBatchReportService batchReportService;

    @Autowired
    private CodeDataUploadRecordService uploadRecordService;

    @Autowired
    private ApiDataService apiDataService;

    private JsonMapper jsonMapper ;

    /**
     * 上传生产数据
     * @return
     */
       @PostMapping(value = "/files/upload")
       public Object list(HttpServletRequest request , HttpServletResponse response , InputStream input , CodeDataUploadRecord uploadRecord) throws IOException{
           InputStream inputStream=input;
           if(input==null){
               inputStream = request.getInputStream();
           }
           if(uploadRecord==null){
               uploadRecord =  new CodeDataUploadRecord();
           }

           ApiFilesUpload apiFilesUpload=new ApiFilesUpload();
           CodeDataBatchReport batchReport = new CodeDataBatchReport();
           uploadRecord.setCreateTime(new Date());
           uploadRecord.setUploadStatus("0");

           if(inputStream != null){
               String descFileName = request.getSession().getServletContext().getRealPath("/") + "uploadFiles" + "/";
               // String descFileName = "D:\\test\\";
               SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
               SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
               // 文件目录
               String recordFilePath = sdf1.format(new Date()) + "/" + sdf2.format(new Date()) + "/";
               uploadRecord.setDirectory(recordFilePath);
               descFileName = descFileName + "/" + recordFilePath;

               FileUtils fileutil = new FileUtils();
               fileutil.createDirectory(descFileName);
               /**
                * 指定文件名
                */
               SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 时间来命名
               String ymd = sdf.format(new Date());
               String uid = UUID.randomUUID().toString();// UUID来命名
               String fileName = uid + ".zip";
               uploadRecord.setFileName(fileName);
               String zipFileName = descFileName + fileName;
               descFileName = descFileName + ymd;
                /**
                 * 写文件
                 */
               File file = new File(zipFileName);
               FileOutputStream outputStream = new FileOutputStream(file);
               byte[] buffer = new byte[1024];
               int bytesRead;
               while ((bytesRead = inputStream.read(buffer)) > 0) {
                   outputStream.write(buffer, 0, bytesRead);
               }
               outputStream.flush();
               outputStream.close();
                /**
                 * 解压文件
                 */
               File jyFile = new File(descFileName);
               if (!jyFile.exists())
                   jyFile.mkdirs();
               fileutil.unZipFiles(zipFileName, descFileName);
                /**
                 * 获取文件夹下的文件
                 */
               File f = null;
               f = new File(descFileName);
               File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
               List<File> listFile = new ArrayList<File>();
               String errorMsg = "";
               int successQty = 0;
               if (files.length != 0) {
                   for (File fileDemo : files) {
                       ApiData apiData = new ApiData();
                       List<ApiData> data = new ArrayList<ApiData>();
                       listFile.add(fileDemo);
                       /**
                        * 写入数据库
                        */
                       String filePath = fileDemo.getAbsolutePath();
                       uploadRecord.setBeginTime(new Date());
                       readTxtFile(filePath, zipFileName, apiFilesUpload, uploadRecord, batchReport);
                       successQty++;
                       fileutil.delFile(descFileName);
                       apiData.setSuccessQty(successQty);
                       apiData.setUploadId(UUID.randomUUID().toString());
                       apiDataService.save(apiData);
                       data.add(apiData);
                       apiFilesUpload.setDataOne(apiData);
                   }
               } else {
                   apiFilesUpload.setCode("3");
                   errorMsg = "文件夹为空";
               }
               apiFilesUpload.setErrorMsg(errorMsg);
           }

           return null ;
       }


    public void readTxtFile(String filePath , String zipFilenName, ApiFilesUpload apiFilesUpload , CodeDataUploadRecord uploadRecord , CodeDataBatchReport batchReport){
        apiFilesUpload.setErrorMsg("写入数据库成功");
        apiFilesUpload.setCode("1");
        uploadRecord.setUploadStatus("1");
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        int qty = 0;// 总单品数
        int ctns = 0;// 总箱数
        int successQty = 0;// 成功单品数
        int successCtn = 0;// 成功箱数
        int failQty = 0;// 失败单品数
        int failCtn = 0;// 失败箱数
        int abnomalCode = 0;// 异常编码数量

        // 错误托码集合
        Set<String> errorRootCode = new HashSet<String>();
        // 错误箱码集合
        Set<String> errorCtnCode = new HashSet<String>();
        // 错误箱码明细数据
        List<CodeDataImportError> errorCodeList = new ArrayList<CodeDataImportError>();
        // 通过箱码分组将codeData存储到list集合
        Map<String, List<CodeData>> codeDataMap = new HashMap<String, List<CodeData>>();
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                List<Product> productList = productService.findAll(new Product());
                // 产品code和id的map
                Map<String, String> productMap = new HashMap<String, String>();
                // 产品code和产品每箱单品数pecCtnMap
                Map<String, Integer> pecCtnMap = new HashMap<String, Integer>();
                boolean productFlag=true;
                for (Product product : productList) {
                    productMap.put(product.getCode(), product.getId());
                    pecCtnMap.put(product.getCode(), product.getPcsQty());
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                // 循环读取每行数据
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String demo[] = lineTxt.split(",");
                    CodeData codeData = new CodeData();
                    try {
                        codeData.setCode(demo[0]);
                        codeData.setEptCode(demo[1]);
                        codeData.setParentCode(demo[2]);
                        codeData.setRootCode(demo[3]);
                        codeData.setPcode(demo[4]);
                        // codeData(demo[5]); sku
                        codeData.setBatchCode(demo[6]);
                        codeData.setPackLevel(Integer.valueOf(demo[7]));
                        // codeData.set versioncode
                        codeData.setPackDate(sdf.parse(demo[9]));
                        codeData.setValidPeriod(sdf.parse(demo[10]));
                        codeData.setPrintDate(sdf.parse(demo[11]));
                        codeData.setLineCode(demo[12]);
                        codeData.setTeamCode(demo[15]);
                        codeData.setWorkerCode(demo[16]);
                    } catch (Exception e1) {
                        abnomalCode++;
                        if (codeData.getPackLevel() == 3) {
                            errorRootCode.add(codeData.getCode());
                        } else if (codeData.getPackLevel() == 2) {
                            errorCtnCode.add(codeData.getCode());
                        } else if (codeData.getPackLevel() == 1) {
                            errorCtnCode.add(codeData.getParentCode());
                        }
                        CodeDataImportError error = new CodeDataImportError(codeData);
                        error.setErrorCode("102");
                        error.setErrorInfo("数据异常:" + e1.getMessage());
                        if (error.getId() != null)
                            error.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                        errorCodeList.add(error);
                        e1.printStackTrace();
                        continue;
                    }finally{
                        // 计算箱数
                        if (codeData.getPackLevel() == 2) {
                            ctns++;
                        } else if (codeData.getPackLevel() == 1) {
                            // 计算总单品数
                            qty++;
                        }
                    }

                    // 判定产品是否存在
                    if (productMap.get(codeData.getPcode()) == null) {
                        // 不存在
                        CodeDataImportError error = new CodeDataImportError(codeData);
                        error.setErrorCode("101");
                        error.setErrorInfo("产品不存在");
                        if (codeData.getPackLevel() == 3) {
                            errorRootCode.add(codeData.getCode());
                        } else if (codeData.getPackLevel() == 2) {
                            errorCtnCode.add(codeData.getCode());
                        } else if (codeData.getPackLevel() == 1) {
                            errorCtnCode.add(codeData.getParentCode());
                        }
                        if(productFlag){
                            uploadRecord.setBatchCode(codeData.getBatchCode());
                            uploadRecord.setCreateDate(codeData.getCreateDate());
                            uploadRecord.setProductCode(codeData.getPcode());
                            uploadRecord.setLineCode(codeData.getLineCode());
                            batchReport.setBatchCode(codeData.getBatchCode());
                            batchReport.setProductCode(codeData.getPcode());
                            productFlag=false;
                        }
                        if (error.getId() != null)
                            error.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                        errorCodeList.add(error);
                        abnomalCode++;
                        continue;
                    } else {
                        // 存在,设置产品Id
                        codeData.setProductId(productMap.get(codeData.getPcode()));
                    }
                    if (codeData.getId() != null)
                        codeData.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                    // 判定code是否为托码
                    if (codeData.getPackLevel() == 3) {
                        try {
                            codeDataService.save(codeData);
                        } catch (Exception e) {
                            abnomalCode++;
                            // 保存错误代码
                            errorRootCode.add(codeData.getCode());
                            CodeDataImportError error = new CodeDataImportError(codeData);
                            // 判定箱码重复
                            if (e instanceof DuplicateKeyException) {
                                error.setErrorCode("100");
                                error.setErrorInfo("编码重复");
                            } else {
                                error.setErrorCode("102");
                                error.setErrorInfo("数据异常:" + e.getMessage());
                            }
                            if (error.getId() != null)
                                error.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                            errorCodeList.add(error);// 保存到错误代码集合
                            e.printStackTrace();
                            continue;
                        }
                    } else if (codeData.getPackLevel() == 2) {
                        // 箱码的托码异常
                        if (errorRootCode.contains(codeData.getParentCode())) {
                            errorCtnCode.add(codeData.getCode());
                            continue;
                        }
                        try {
                            codeDataService.save(codeData);
                        } catch (Exception e) {
                            // 保存错误代码
                            abnomalCode++;
                            errorCtnCode.add(codeData.getCode());
                            CodeDataImportError error = new CodeDataImportError(codeData);
                            // 判定箱码重复
                            if (e instanceof DuplicateKeyException) {
                                error.setErrorCode("100");
                                error.setErrorInfo("编码重复");
                            } else {
                                error.setErrorCode("102");
                                error.setErrorInfo("数据异常:" + e.getMessage());
                            }
                            if (error.getId() != null)
                                error.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                            errorCodeList.add(error);// 保存到错误代码集合
                            e.printStackTrace();
                            continue;
                        }
                    } else {
                        // 单品码处理
                        // 判定单品托码箱码是否异常
                        if (errorCtnCode.contains(codeData.getParentCode())) {
                            continue;
                        }

                        // 通过箱码分组将codeData存储到list集合
                        if (codeDataMap.containsKey(codeData.getParentCode())) {
                            codeDataMap.get(codeData.getParentCode()).add(codeData);
                        } else {
                            List<CodeData> list = new ArrayList<CodeData>();
                            list.add(codeData);
                            codeDataMap.put(codeData.getParentCode(), list);
                        }

                    }
                }

                boolean flag = true;
                // 整箱保存操作
                for (Map.Entry<String, List<CodeData>> entry : codeDataMap.entrySet()) {
                    if (flag) {
                        CodeData codeDemo = entry.getValue().get(0);
                        uploadRecord.setBatchCode(codeDemo.getBatchCode());
                        uploadRecord.setCreateDate(codeDemo.getCreateDate());
                        uploadRecord.setProductCode(codeDemo.getPcode());
                        uploadRecord.setLineCode(codeDemo.getLineCode());
                        Product product = productService.findByCode(codeDemo.getPcode());
                        uploadRecord.setProductName(product.getName());
                        batchReport.setBatchCode(codeDemo.getBatchCode());
                        batchReport.setProductCode(codeDemo.getPcode());
                        batchReport.setProductName(product.getName());
                        flag = false;
                    }

                    try {
                        if (errorCtnCode.contains(entry.getKey())) {
                            continue;
                        }
                        codeDataService.saveBatch(entry.getValue());
						/*if(!saveFlag){
							saveFlag=true;
						}*/
                        successCtn++;
                        successQty += entry.getValue().size();
                    } catch (Exception e) {
                        abnomalCode+=entry.getValue().size();
                        entry.getValue().get(0);
                        CodeData ctnCode = codeDataService.findByCode(entry.getValue().get(0).getParentCode());
                        CodeDataImportError error = new CodeDataImportError(ctnCode);
                        if (e instanceof DuplicateKeyException) {
                            error.setErrorCode("103");
                            error.setErrorInfo("下级编码重复");
                        } else {
                            error.setErrorCode("104");
                            error.setErrorInfo("下级数据异常:" + e.getMessage());
                        }
                        if (error.getId() != null)
                            error.setIsNewRecord(true);// 设置id如果手动设置id，会进行修改操作
                        errorCodeList.add(error);
                        e.printStackTrace();
                    }
                }

                if (null!=errorCodeList&&errorCodeList.size() > 0) {
                    int limit = 1000;//限制条数
                    Integer size = errorCodeList.size();
                    if(limit<size){
                        int part=size/limit;
                        for(int i=0;i<part;i++){
                            List<CodeDataImportError> listPage = errorCodeList.subList(0, limit);
                            errorService.saveBatch(listPage);
                            errorCodeList.subList(0, limit).clear();
                        }
                        if(!errorCodeList.isEmpty()){
                            errorService.saveBatch(errorCodeList);
                        }
                    }else{
                        errorService.saveBatch(errorCodeList);
                    }
                    uploadRecord.setUploadStatus("4");
                    apiFilesUpload.setErrorMsg("部分处理成功");
                    apiFilesUpload.setCode("4");
                } else {
                    uploadRecord.setUploadStatus("2");
                    apiFilesUpload.setErrorMsg("处理成功");
                    apiFilesUpload.setCode("2");
                }
                failCtn = ctns - successCtn;
                failQty = qty - successQty;
                batchReport.setCtns(ctns);
                batchReport.setQty(qty);
                uploadRecord.setQty(qty);
                uploadRecord.setCtns(ctns);
                uploadRecord.setSuccessctn(successCtn);
                uploadRecord.setSuccessqty(successQty);
                uploadRecord.setFailctn(failCtn);
                uploadRecord.setFailqty(failQty);
                uploadRecord.setEndTime(new Date());
                uploadRecord.setAbnomalCode(abnomalCode);
                uploadRecordService.save(uploadRecord);
                batchReportService.save(batchReport);

            } else {
                apiFilesUpload.setCode("3");
                apiFilesUpload.setErrorMsg("处理失败:找不到指定的文件");
                uploadRecord.setUploadStatus("3");
                uploadRecordService.save(uploadRecord);
                batchReportService.save(batchReport);
            }
        } catch (Exception e) {
            apiFilesUpload.setCode("5");
            apiFilesUpload.setErrorMsg("处理异常");
            uploadRecord.setUploadStatus("5");
            uploadRecordService.save(uploadRecord);
            batchReportService.save(batchReport);
            e.printStackTrace();
        } finally {

            try {
                read.close();
                bufferedReader.close();
            } catch (IOException e) {
                apiFilesUpload.setCode("5");
                apiFilesUpload.setErrorMsg("处理异常");
                e.printStackTrace();
            }
        }

    }

    /**
     * 写文件方法
     */
    public static String readTxtFileIntoStringArrList(String filePath, String tempPath) {
        List<String> list = new ArrayList<String>();
        int count = 0;
        int num = 0;
        String truePath = null;
        String dicName = null;
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (count == 2) {
                        dicName = lineTxt.substring(52, 85);
                        truePath = tempPath + dicName + ".zip";
                    }
                    // if (count >= 5)
                    list.add(lineTxt);
                    count++;
                }
                bufferedReader.close();
                read.close();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dicName;
    }

}
