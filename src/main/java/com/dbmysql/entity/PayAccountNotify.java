package com.dbmysql.entity;

public class PayAccountNotify {
    private String account;

    private String notify;

    private Integer showType;

    private String statisticNotify;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify == null ? null : notify.trim();
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getStatisticNotify() {
        return statisticNotify;
    }

    public void setStatisticNotify(String statisticNotify) {
        this.statisticNotify = statisticNotify == null ? null : statisticNotify.trim();
    }
}