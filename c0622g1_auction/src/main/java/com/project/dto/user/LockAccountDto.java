package com.project.dto.user;

public class LockAccountDto {
    private String startDay;
    private String endDay;
    private String reason;
    private int accountId;

    public LockAccountDto() {
    }

    public LockAccountDto(String startDay, String endDay, String reason, int accountId) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
        this.accountId = accountId;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
