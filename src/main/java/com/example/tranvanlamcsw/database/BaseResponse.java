package com.example.tranvanlamcsw.database;

public class  BaseResponse<T>{
    public int status = 1;
    public String message = "success";
    public T data;
}
