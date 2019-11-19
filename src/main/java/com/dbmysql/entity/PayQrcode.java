package com.dbmysql.entity;

public class PayQrcode {
    private Integer id;

    private String account;

    private String money;

    private String qrcodeUrl;

    private Integer codeType;

    private String moneyKey;

    private Integer status;

    private Long oktime;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
    }

    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    public String getMoneyKey() {
        return moneyKey;
    }

    public void setMoneyKey(String moneyKey) {
        this.moneyKey = moneyKey == null ? null : moneyKey.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOktime() {
        return oktime;
    }

    public void setOktime(Long oktime) {
        this.oktime = oktime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}