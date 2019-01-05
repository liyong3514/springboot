package com.itheima.ssm.domain;
//会员

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {
    @Id
    private String id;
    private String name;
    private String nickname;
    @Column(name = "phoneNum")
    private String phoneNum;
    private String email;
    @OneToMany(mappedBy = "member")
    private Set<Orders> orders = new HashSet<>(0);

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }

        Member member = (Member) o;

        if (getId() != null ? !getId().equals(member.getId()) : member.getId() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(member.getName()) : member.getName() != null) {
            return false;
        }
        if (getNickname() != null ? !getNickname().equals(member.getNickname()) : member.getNickname() != null) {
            return false;
        }
        if (getPhoneNum() != null ? !getPhoneNum().equals(member.getPhoneNum()) : member.getPhoneNum() != null) {
            return false;
        }
        if (getEmail() != null ? !getEmail().equals(member.getEmail()) : member.getEmail() != null) {
            return false;
        }
        return orders != null ? orders.equals(member.orders) : member.orders == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
        result = 31 * result + (getPhoneNum() != null ? getPhoneNum().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
