package com.maxh.sloa.entity.store;

import java.util.List;

public class Prove {
    private String id;
    private String fileId;
    private String number; // 证明编号
    private String purpose; // 用途
    private String ustype; // 使用类型
    private String usman; // 领用人
    private String usriqi; // 领用or出库时间
    private int state; // 出库状态
    private int ustate; // 使用状态
    private String remark; // 备注
    private String uid; // 操作人
    private String department; // 所在部门编码
    private String departmentName; // 所在部门名称
    private String imgPath; // 证明照片
    private String recycleTime;// 回收时间
    private List<ProveRecord> proveRecords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getUstype() {
        return ustype;
    }

    public void setUstype(String ustype) {
        this.ustype = ustype;
    }

    public String getUsman() {
        return usman;
    }

    public void setUsman(String usman) {
        this.usman = usman;
    }

    public String getUsriqi() {
        return usriqi;
    }

    public void setUsriqi(String usriqi) {
        this.usriqi = usriqi;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUstate() {
        return ustate;
    }

    public void setUstate(int ustate) {
        this.ustate = ustate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getRecycleTime() {
        return recycleTime;
    }

    public void setRecycleTime(String recycleTime) {
        this.recycleTime = recycleTime;
    }

    public List<ProveRecord> getProveRecords() {
        return proveRecords;
    }

    public void setProveRecords(List<ProveRecord> proveRecords) {
        this.proveRecords = proveRecords;
    }

    @Override
    public String toString() {
        return "Prove{" +
                "id='" + id + '\'' +
                ", fileId='" + fileId + '\'' +
                ", number='" + number + '\'' +
                ", purpose='" + purpose + '\'' +
                ", ustype='" + ustype + '\'' +
                ", usman='" + usman + '\'' +
                '}';
    }
}
