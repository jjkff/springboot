package cn.sierac.entity;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * Created by Jack on 2017/8/5.
 */
public class CodeDataUploadRecord {

	private String id ;
	private String directory;		// directory
	private String fileName;		// file_name
	private String productCode;		// 产品代码
	private String productName;		// product_name
	private Date beginTime;		// begin_time
	private Date endTime;		// end_time
	private String lineCode;		// line_code
	private String batchCode;		// batch_code
	private String uploadStatus;		// upload_status
	private Date createTime;		// create_time
	private Integer qty;		// qty
	private Integer ctns;		// ctns
	private Integer successqty;		// successqty
	private Integer successctn;		// successctn
	private Integer failqty;		// failqty
	private Integer failctn;		// failctn
	private Integer abnomalCode;		// abnomal_code

	protected Date createDate; // 创建日期
	
	private Date startBeginDate;//开始处理时间
	private Date startEndDate;
	private Date overBeginDate;//结束处理时间
	private Date overEndDate;
	private Date createBeginDate;//增加时间
	private Date createEndDate;
	private String statusInfo;

	private String remarks;

	
	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public Date getStartBeginDate() {
		return startBeginDate;
	}

	public void setStartBeginDate(Date startBeginDate) {
		this.startBeginDate = startBeginDate;
	}

	public Date getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(Date startEndDate) {
		this.startEndDate = startEndDate;
	}

	public Date getOverBeginDate() {
		return overBeginDate;
	}

	public void setOverBeginDate(Date overBeginDate) {
		this.overBeginDate = overBeginDate;
	}

	public Date getOverEndDate() {
		return overEndDate;
	}

	public void setOverEndDate(Date overEndDate) {
		this.overEndDate = overEndDate;
	}

	public Date getCreateBeginDate() {
		return createBeginDate;
	}

	public void setCreateBeginDate(Date createBeginDate) {
		this.createBeginDate = createBeginDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	public CodeDataUploadRecord() {
		super();
	}



	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	
	@Length(min=0, max=1, message="upload_status长度必须介于 0 和 1 之间")
	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	

	public Date getCreateTime() {
		return createTime;
	}

	public Integer getQty() {
		return qty;
	}

	public Integer getCtns() {
		return ctns;
	}

	public Integer getSuccessqty() {
		return successqty;
	}

	public Integer getSuccessctn() {
		return successctn;
	}

	public Integer getFailqty() {
		return failqty;
	}

	public Integer getFailctn() {
		return failctn;
	}

	public Integer getAbnomalCode() {
		return abnomalCode;
	}

	public void setAbnomalCode(Integer abnomalCode) {
		this.abnomalCode = abnomalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public void setCtns(Integer ctns) {
		this.ctns = ctns;
	}

	public void setSuccessqty(Integer successqty) {
		this.successqty = successqty;
	}

	public void setSuccessctn(Integer successctn) {
		this.successctn = successctn;
	}

	public void setFailqty(Integer failqty) {
		this.failqty = failqty;
	}

	public void setFailctn(Integer failctn) {
		this.failctn = failctn;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}