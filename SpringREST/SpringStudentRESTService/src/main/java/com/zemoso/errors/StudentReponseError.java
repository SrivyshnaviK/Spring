package com.zemoso.errors;

public class StudentReponseError {
    private int status;
    private String message;
    private long timeStamp;

    public StudentReponseError(){}
    public StudentReponseError(int status,String message,long timeStamp){
        this.status=status;
        this.message=message;
        this.timeStamp=timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
