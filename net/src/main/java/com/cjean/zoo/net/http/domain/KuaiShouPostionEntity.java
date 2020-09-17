package com.cjean.zoo.net.http.domain;

import java.util.Objects;

public class KuaiShouPostionEntity {
    private int id;
    private String code;
    //工作名称
    private String name;
    //工作描述
    private String description;
    // 岗位描述
    private String positionDemand;
    // 工作年限 1：不限 4：1-3 5：3-5 6：5-10  7：10-
    private String workExperienceCode;
    // 工作地点代码
    private String workLocationCode;
    // 最低工资
    private String salaryMin;
    // 最高工资
    private String salaryMax;
    // 最低学历
    private String educationLimitCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPositionDemand() {
        return positionDemand;
    }

    public void setPositionDemand(String positionDemand) {
        this.positionDemand = positionDemand;
    }

    public String getWorkExperienceCode() {
        return workExperienceCode;
    }

    public void setWorkExperienceCode(String workExperienceCode) {
        this.workExperienceCode = workExperienceCode;
    }

    public String getWorkLocationCode() {
        return workLocationCode;
    }

    public void setWorkLocationCode(String workLocationCode) {
        this.workLocationCode = workLocationCode;
    }

    public String getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(String salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(String salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getEducationLimitCode() {
        return educationLimitCode;
    }

    public void setEducationLimitCode(String educationLimitCode) {
        this.educationLimitCode = educationLimitCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KuaiShouPostionEntity that = (KuaiShouPostionEntity) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(positionDemand, that.positionDemand) &&
                Objects.equals(workExperienceCode, that.workExperienceCode) &&
                Objects.equals(workLocationCode, that.workLocationCode) &&
                Objects.equals(salaryMin, that.salaryMin) &&
                Objects.equals(salaryMax, that.salaryMax) &&
                Objects.equals(educationLimitCode, that.educationLimitCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, positionDemand, workExperienceCode, workLocationCode, salaryMin, salaryMax, educationLimitCode);
    }

    @Override
    public String toString() {
        return "KuaiShouPostionEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", positionDemand='" + positionDemand + '\'' +
                ", workExperienceCode='" + workExperienceCode + '\'' +
                ", workLocationCode='" + workLocationCode + '\'' +
                ", salaryMin='" + salaryMin + '\'' +
                ", salaryMax='" + salaryMax + '\'' +
                ", educationLimitCode='" + educationLimitCode + '\'' +
                '}';
    }
}
