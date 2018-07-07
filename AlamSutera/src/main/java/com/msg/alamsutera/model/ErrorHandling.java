package com.msg.alamsutera.model;

/**
 * Created by yoga.wiguna on 5/2/2018.
 */
public class ErrorHandling {

    private String code;
    private String message;

    public ErrorHandling(
            String code,
            String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
