package cn.sierac.entity;

/**
 * Created by Jack on 2017/8/7.
 */
public class ApiData {

     private  String id ;

     private String uploadId;

     private Integer successQty;

     public String getId() {
            return id;
        }

     public void setId(String id) {
            this.id = id;
        }

     public String getUploadId() {
            return uploadId;
        }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public Integer getSuccessQty() {
        return successQty;
    }

    public void setSuccessQty(Integer successQty) {
        this.successQty = successQty;
    }
}
