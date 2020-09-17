package com.cjean.zoo.net.http.domain;

import java.util.Objects;

public class LangChaoPostionEntity {
    private String id;
    //工作名称
    private String name;
    //工作描述
    private String job_desc;
    // 岗位描述
    private String work_province;
    private String work_city;
    private String work_address;
    //
    private String email;
    // 截止时间
    private String auto_offline_date;
    // 部门描述
    private String vague_str;
    // 最低工资
    private String low_salary;
    // 最高工资
    private String high_salary;
    // 级别
    private String work_exp;

    private LangChaoEmployee langChaoEmployee;

    @Override
    public String toString() {
        return "LangChaoPostionEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", job_desc='" + job_desc + '\'' +
                ", work_province='" + work_province + '\'' +
                ", work_city='" + work_city + '\'' +
                ", work_address='" + work_address + '\'' +
                ", email='" + email + '\'' +
                ", auto_offline_date='" + auto_offline_date + '\'' +
                ", vague_str='" + vague_str + '\'' +
                ", low_salary='" + low_salary + '\'' +
                ", high_salary='" + high_salary + '\'' +
                ", work_exp='" + work_exp + '\'' +
                ", langChaoEmployee=" + langChaoEmployee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LangChaoPostionEntity that = (LangChaoPostionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(job_desc, that.job_desc) &&
                Objects.equals(work_province, that.work_province) &&
                Objects.equals(work_city, that.work_city) &&
                Objects.equals(work_address, that.work_address) &&
                Objects.equals(email, that.email) &&
                Objects.equals(auto_offline_date, that.auto_offline_date) &&
                Objects.equals(vague_str, that.vague_str) &&
                Objects.equals(low_salary, that.low_salary) &&
                Objects.equals(high_salary, that.high_salary) &&
                Objects.equals(work_exp, that.work_exp) &&
                Objects.equals(langChaoEmployee, that.langChaoEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, job_desc, work_province, work_city, work_address, email, auto_offline_date, vague_str, low_salary, high_salary, work_exp, langChaoEmployee);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public String getWork_province() {
        return work_province;
    }

    public void setWork_province(String work_province) {
        this.work_province = work_province;
    }

    public String getWork_city() {
        return work_city;
    }

    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }

    public String getWork_address() {
        return work_address;
    }

    public void setWork_address(String work_address) {
        this.work_address = work_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuto_offline_date() {
        return auto_offline_date;
    }

    public void setAuto_offline_date(String auto_offline_date) {
        this.auto_offline_date = auto_offline_date;
    }

    public String getVague_str() {
        return vague_str;
    }

    public void setVague_str(String vague_str) {
        this.vague_str = vague_str;
    }

    public String getLow_salary() {
        return low_salary;
    }

    public void setLow_salary(String low_salary) {
        this.low_salary = low_salary;
    }

    public String getHigh_salary() {
        return high_salary;
    }

    public void setHigh_salary(String high_salary) {
        this.high_salary = high_salary;
    }

    public String getWork_exp() {
        return work_exp;
    }

    public void setWork_exp(String work_exp) {
        this.work_exp = work_exp;
    }

    public LangChaoEmployee getLangChaoEmployee() {
        return langChaoEmployee;
    }

    public void setLangChaoEmployee(LangChaoEmployee langChaoEmployee) {
        this.langChaoEmployee = langChaoEmployee;
    }
}
