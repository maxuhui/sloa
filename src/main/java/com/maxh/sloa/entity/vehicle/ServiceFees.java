package com.maxh.sloa.entity.vehicle;

public class ServiceFees {
    private String id;
    private int purpose;// 用途
    private String carNumber;// 车牌号
    private String owner;// 业户名称
    private String number;// 证明编号
    private String startTime;// 服务开始时间
    private String endTime;// 服务结束时间
    private String colAmounts;// 代收金额
    private String riqi;// 收费时间
    private String agent;// 代收人
    private String depCode;// 代收人部门编码
    private String depName;// 代收人部门名称
    private int fees;// 收款状态
    private String amounts;// 实收金额
    private String sriqi;// 确认时间
    private String payee;// 收款人
    private String remark;// 备注
    private String inspector;// 填单人
    private String sf_time;// 收费操作时间
    private String qr_time;// 收款操作时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getColAmounts() {
        return colAmounts;
    }

    public void setColAmounts(String colAmounts) {
        this.colAmounts = colAmounts;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }

    public String getSriqi() {
        return sriqi;
    }

    public void setSriqi(String sriqi) {
        this.sriqi = sriqi;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getSf_time() {
        return sf_time;
    }

    public void setSf_time(String sf_time) {
        this.sf_time = sf_time;
    }

    public String getQr_time() {
        return qr_time;
    }

    public void setQr_time(String qr_time) {
        this.qr_time = qr_time;
    }
}
