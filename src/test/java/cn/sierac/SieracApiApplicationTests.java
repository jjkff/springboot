package cn.sierac;

import cn.sierac.common.result.Constant;
import cn.sierac.dao.*;
import cn.sierac.entity.*;
import cn.sierac.entity.ApiRdcOutData;
import cn.sierac.entity.ApiRdcOutHeader;
import org.apache.commons.collections.map.HashedMap;
import org.aspectj.apache.bcel.classfile.Code;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SieracApiApplicationTests {

	@Autowired
	private UserMapperDao userMapperDao;

	@Autowired
	private DealerMapperDao dealerMapperDao;

	@Autowired
	private DealerLoginDao dealerLoginDao;

	@Autowired
	private WarehouseLoginDao apiWarehouseLoginDao;

	@Autowired
	private RdcOutHeaderDao rdcOutHeaderDao;

	@Autowired
	private WarehouseOutScanCheckDao warehouseOutScanCheckDao;


	@Autowired
	private ApiRdcOutHeaderDao apiRdcOutHeaderDao;

	@Autowired
	private ApiRdcOutDetailDao apiRdcOutDetailDao;

	@Autowired
	private CodeDataDao codeDataDao;

	@Autowired
	private DealerDetailDao dealerDetailDao;

	@Autowired
	private DealerScanCheckDao dealerScanCheckDao;

	@Autowired
	private ApiDealerDao apiDealerDao;

	@Autowired
	private ApiDealerDetailDao apiDealerDetailDao;

	@Autowired
	private ApiDealerDataDao apiDealerDataDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ApiDataDao apiDataDao;

	@Autowired
	private CodeDataImportErrorDao codeDataImportErrorDao;

	@Autowired
	private  CodeDataBatchReportDao codeDataBatchReportDao;

	@Autowired
	private CodeDataUploadRecordDao codeDataUploadRecordDao;

	@Test
	public void insertUpload(){
	    CodeDataUploadRecord codeDataUploadRecord = new CodeDataUploadRecord();
	    codeDataUploadRecord.setId("1");
		codeDataUploadRecordDao.insert(codeDataUploadRecord);
	}

	@Test
	public void testInsertBatchReport(){
		CodeDataBatchReport codeDataBatchReport = new CodeDataBatchReport();
		codeDataBatchReport.setId("1");
		codeDataBatchReport.setDelFlag("0");
		codeDataBatchReportDao.insert(codeDataBatchReport);
	}

	@Test
	public void testinSertBatchError(){
		 CodeDataImportError codeDataImportError = new CodeDataImportError();
		 codeDataImportError.setId("123322");
		 codeDataImportError.setCode("008");
		 CodeDataImportError codeDataImportError1 = new CodeDataImportError();
		 codeDataImportError1.setId("232222");
		 codeDataImportError.setCode("09900");
		 List<CodeDataImportError> errors = new ArrayList<>();
		 errors.add(codeDataImportError);
		 errors.add(codeDataImportError1);
		 codeDataImportErrorDao.insertBatch(errors);
	}

	@Test
	public void getBatchError(){
		CodeDataImportError c = codeDataImportErrorDao.get("090099");
	}

	@Test
	public void insertApiData(){
		 ApiData apiData = new ApiData();
		 apiData.setId("009019290");
		 apiData.setUploadId("21212121");
		 apiData.setSuccessQty(100);
		 try
		 {
			 apiDataDao.insert(apiData);
		 }
		 catch (Exception e){
		 	e.printStackTrace();
		 }

	}

	@Test
	public void findAll(){
        List<Product> lists =  productDao.findAll(new Product());
	}

	@Test
	public void findByCode(){
		Product product =  productDao.findByCode("1234");
	}

	@Test
	public void getByName(){
	User user = userMapperDao.getUserByName("admin");
	}

	@Test
	public void findAllDealer(){

		Dealer dealer = new Dealer();
		dealer.setSendId("HRTED");
        dealer.setScanBy("abc");
        dealer.setBillStatus("1");
        List<Dealer> dealers =  dealerMapperDao.findAll(dealer);

	}

	@Test
	public void testfindWareHouseId(){
		WareHouseLogin apiWarehouseLogin = apiWarehouseLoginDao.findWareHouseId("admin");

	}

	@Test
	public void testfindDealerId(){
		DealerLogin dealerLogin =  dealerLoginDao.findDealerId("admin");
	}

	@Test
	public void testRdcWareHouseList(){
		RdcOutHeader rdcOutHeader = new RdcOutHeader();
		rdcOutHeader.setSendId("HRTED");
		rdcOutHeader.setScanBy("abc");
		rdcOutHeader.setBillStatus("0");
		List<RdcOutHeader> rdcOutHeaders = rdcOutHeaderDao.findAll(rdcOutHeader);

	}

	@Test
	public void testwarehouseOutScanCheckDao(){
		List<WarehouseOutScanCheck>  lists = warehouseOutScanCheckDao.findAll("80210320100000000313");
	}

	@Test
	public void testfindByCode(){
        RdcOutHeader rdcOutHeader =  rdcOutHeaderDao.findByCode("80210320100000000313");

	}


	@Test
	public void updateApiOutHeader(){
		ApiRdcOutHeader apiRdcOutHeader = new ApiRdcOutHeader();
		apiRdcOutHeader.setCode("201708120003");
		apiRdcOutHeader.setBillStatus("1");
	    apiRdcOutHeaderDao.update(apiRdcOutHeader);
	}

	@Test
	public void updateApiOutDetail(){
		ApiRdcOutDetail apiRdcOutDetail = new ApiRdcOutDetail();
		apiRdcOutDetail.setId("fe5358582e96466bb40516f91ced0c6d");
		apiRdcOutDetail.setActualPcsQty(111);
		apiRdcOutDetailDao.update(apiRdcOutDetail);
	}



	@Test
	public void testupdateCodeData(){
        CodeData codeData = new CodeData();
        codeData.setCode("80210320100000000313");
        codeData.setStatus("1");
        codeData.setUpdateDate(new Date());
        codeDataDao.updateAll(codeData);
	}

	@Test
	public void testfindByParentCode(){
		CodeData codeData = new CodeData();
		codeData.setCode("C0580210320724320170621001");
		List<CodeData> codeDatas = codeDataDao.findByParentCode(codeData);
	}

	@Test
	public void testinsertBatch(){
		ApiRdcOutData apiRdcOutData = new ApiRdcOutData(new CodeData());
	}

	@Test
	public void testfindDealerDetail(){
		DealerDetail dealerDetail = new DealerDetail();
		dealerDetail.setCode("201708120003");
        List<DealerDetail> dealerDetails = dealerDetailDao.findDealerDetail(dealerDetail);
	}

	@Test
	public void testDealerScanCheckfindAll(){
        DealerScanCheck dealerScanCheck = new DealerScanCheck();
		List<DealerScanCheck> lists = dealerScanCheckDao.findAll("80210320100000000313");
	}

	@Test
	public void testDealerfindByCode(){
		Dealer d = dealerMapperDao.findByCode("201708120004");
	}

	@Test
	public void testUpdateDealer(){
		ApiDealer apiDealer = new ApiDealer();
		apiDealer.setCode("201708120003");
		apiDealer.setBillStatus("0");
		apiDealerDao.update(apiDealer);
	}

	@Test
	public void updateApiDealerDetail(){
		ApiDealerDetail apiDealerDetail = new ApiDealerDetail();
		apiDealerDetail.setId("16d222c35487431184196b01c2870633");
		apiDealerDetail.setActualPcsQty(111);
		apiDealerDetailDao.update(apiDealerDetail);
	}

	@Test
	public void updateApiDealerData(){

		ApiDealerData apiDealerData = new ApiDealerData();
		apiDealerData.setId("1");
		apiDealerData.setCode("123");
		apiDealerData.setHeaderId("1");
		apiDealerData.setDetailId("1");
		apiDealerData.setParentCode("123");
		apiDealerData.setProductId("1");
		ApiDealerData apiDealerData1 = new ApiDealerData();
		apiDealerData.setId("2");
		apiDealerData.setCode("123");
		apiDealerData.setHeaderId("2");
		apiDealerData.setDetailId("2");
		apiDealerData.setParentCode("123");
		apiDealerData.setProductId("1");

		List<ApiDealerData> list = new ArrayList<>();
		list.add(apiDealerData) ;
		list.add(apiDealerData1);
		apiDealerDataDao.insertBatch(list);

	}

	@Test
	public void  insertCode(){
		CodeData codeData = new CodeData();
		codeData.setId("10999999");
		codeData.setCode("1099999");
		codeData.setStatus("1");
		codeData.setUpdateDate(new Date());
		codeData.setBatchCode("1098999");
		codeData.setCreateDate(new Date());
		codeData.setPrintDate(new Date());
		codeDataDao.insert(codeData);
	}

	@Test
	public void insertBatch(){
		CodeData codeData = new CodeData();
		codeData.setId("888888888888");
		codeData.setCode("209999");
		codeData.setStatus("1");
		codeData.setUpdateDate(new Date());
		codeData.setBatchCode("1098999");
		codeData.setCreateDate(new Date());
		codeData.setPrintDate(new Date());

		CodeData codeData2 = new CodeData();
		codeData2.setId("8888888888881");
		codeData2.setCode("309999");
		codeData2.setStatus("1");
		codeData2.setUpdateDate(new Date());
		codeData2.setBatchCode("1098999");
		codeData2.setCreateDate(new Date());
		codeData2.setPrintDate(new Date());

		List<CodeData> codeDatas = new ArrayList<>();
		codeDatas.add(codeData);
		codeDatas.add(codeData2);
		codeDataDao.insertBatch(codeDatas);
	}

	@Test
	public void testfindByCodeDataCode(){
		CodeData codeData =  codeDataDao.findByCode("00500117080300016822");
	}



	@Test
	public void testabc(){
		String s  =  "";
		String ss =  null;

		System.out.println(s);
		System.out.println(ss);

		//使用equals
		boolean b1 = s.equals("");
		boolean b2 = s.equals(null);

		boolean b = ("").equals(ss);
//		boolean b3 = ss.equals(""); //nullPointException
//		boolean b4 = ss.equals(null);//nullPointException

		System.out.println(s == null);
		System.out.println(ss == null);


	}

}
