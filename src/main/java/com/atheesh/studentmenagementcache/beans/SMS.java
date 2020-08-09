package com.atheesh.studentmenagementcache.beans;

public class SMS {
    private String accountSID;
    private String authToken;
    private String number;
    private String toNumber;
    private String message;

    public SMS() {
    }

    public String getAccountSID() {
        return accountSID;
    }

    public void setAccountSID(String accountSID) {
        this.accountSID = accountSID;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SMS{" +
                "accountSID='" + accountSID + '\'' +
                ", authToken='" + authToken + '\'' +
                ", number='" + number + '\'' +
                ", toNumber='" + toNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
