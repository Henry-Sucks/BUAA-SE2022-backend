package com.example.demo.pojo;

//数据获取正常的情况下result=true Data返回数据 errorInf = “OK”
public class DataReturn<T> {

    private boolean result;
    private T Data;
    private String errorInf = "OK";

    public void setErrorInf(String errorInf) {
        this.errorInf = errorInf;
    }

    public String getErrorInf() {
        return errorInf;
    }

    public boolean isResult() {
        return result;
    }

    public T getData() {
        return Data;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setData(T data) {
        Data = data;
    }
}
