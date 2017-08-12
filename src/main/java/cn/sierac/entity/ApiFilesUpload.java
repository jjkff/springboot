package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Jack on 2017/8/7.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiFilesUpload {

    private String code ;

    private String errorMsg;

    private List<ApiData> data;

    private ApiData dataOne;

    public ApiFilesUpload(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ApiData> getData() {
        return data;
    }

    public void setData(List<ApiData> data) {
        this.data = data;
    }

    public ApiData getDataOne() {
        return dataOne;
    }

    public void setDataOne(ApiData dataOne) {
        this.dataOne = dataOne;
    }
}
