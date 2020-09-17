package com.cjean.zoo.net.http.domain;

import java.util.Objects;

public class LangChaoEmployee {
    private String id;
    private String description;
    private String operate_time;
    private String operator_id;
    private String company_id;
    private String name;
    private String number;
    private String birthday;
    private String gender;
    private String native_place;
    private String married;
    private String nation;
    private String nationality;
    private String identity_card;
    private String mobile;
    private String mail;
    private String position_type;
    private String job_level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getJob_level() {
        return job_level;
    }

    public void setJob_level(String job_level) {
        this.job_level = job_level;
    }

    @Override
    public String toString() {
        return "LangChaoEmployee{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", operate_time='" + operate_time + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", company_id='" + company_id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", native_place='" + native_place + '\'' +
                ", married='" + married + '\'' +
                ", nation='" + nation + '\'' +
                ", nationality='" + nationality + '\'' +
                ", identity_card='" + identity_card + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", position_type='" + position_type + '\'' +
                ", job_level='" + job_level + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LangChaoEmployee that = (LangChaoEmployee) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(operate_time, that.operate_time) &&
                Objects.equals(operator_id, that.operator_id) &&
                Objects.equals(company_id, that.company_id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(number, that.number) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(native_place, that.native_place) &&
                Objects.equals(married, that.married) &&
                Objects.equals(nation, that.nation) &&
                Objects.equals(nationality, that.nationality) &&
                Objects.equals(identity_card, that.identity_card) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(position_type, that.position_type) &&
                Objects.equals(job_level, that.job_level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, operate_time, operator_id, company_id, name, number, birthday, gender, native_place, married, nation, nationality, identity_card, mobile, mail, position_type, job_level);
    }
}
