package com.xyz.sql.query.api.common.handler.returnn;

public class JsonResult {

    private Object data;

    private int status;

    private String desc;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static JsonResult builder(int status, String desc) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.status = status;
        jsonResult.desc = desc;
        return jsonResult;
    }
}
