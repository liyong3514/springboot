package com.itheima.ssm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Author 李永
 * @Description
 * @Date  2019\1\3 0003
 * @version 1.0
*/
@Entity
@Table(name = "traveller")
public class Traveller {
    @Id
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    @Transient
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    @Transient
    private String travellerTypeStr;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //证件类型 0身份证 1护照 2军官证
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "护照";
            } else if (credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        ////旅客类型(人群) 0 成人 1 儿童
        if (travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr = "成人";
            } else if (travellerType == 1) {
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Traveller)) {
            return false;
        }

        Traveller traveller = (Traveller) o;

        if (getId() != null ? !getId().equals(traveller.getId()) : traveller.getId() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(traveller.getName()) : traveller.getName() != null) {
            return false;
        }
        if (getSex() != null ? !getSex().equals(traveller.getSex()) : traveller.getSex() != null) {
            return false;
        }
        if (getPhoneNum() != null ? !getPhoneNum().equals(traveller.getPhoneNum()) : traveller.getPhoneNum() != null) {
            return false;
        }
        if (getCredentialsType() != null ? !getCredentialsType().equals(traveller.getCredentialsType()) : traveller.getCredentialsType() != null) {
            return false;
        }
        if (getCredentialsTypeStr() != null ? !getCredentialsTypeStr().equals(traveller.getCredentialsTypeStr()) : traveller.getCredentialsTypeStr() != null) {
            return false;
        }
        if (getCredentialsNum() != null ? !getCredentialsNum().equals(traveller.getCredentialsNum()) : traveller.getCredentialsNum() != null) {
            return false;
        }
        if (getTravellerType() != null ? !getTravellerType().equals(traveller.getTravellerType()) : traveller.getTravellerType() != null) {
            return false;
        }
        return getTravellerTypeStr() != null ? getTravellerTypeStr().equals(traveller.getTravellerTypeStr()) : traveller.getTravellerTypeStr() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getPhoneNum() != null ? getPhoneNum().hashCode() : 0);
        result = 31 * result + (getCredentialsType() != null ? getCredentialsType().hashCode() : 0);
        result = 31 * result + (getCredentialsTypeStr() != null ? getCredentialsTypeStr().hashCode() : 0);
        result = 31 * result + (getCredentialsNum() != null ? getCredentialsNum().hashCode() : 0);
        result = 31 * result + (getTravellerType() != null ? getTravellerType().hashCode() : 0);
        result = 31 * result + (getTravellerTypeStr() != null ? getTravellerTypeStr().hashCode() : 0);
        return result;
    }
}
