package com.mte2023.spring_mte.exceptions_generic;

public class BadRequestException extends RuntimeException {

    private int serverCode;
    private String path;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadRequestException(String message, int serverCode) {
        super(message);
        this.serverCode = serverCode;
    }


    public int getServerCode() { return serverCode; }

    public void setServerCode(int serverCode) { this.serverCode = serverCode; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }
}

