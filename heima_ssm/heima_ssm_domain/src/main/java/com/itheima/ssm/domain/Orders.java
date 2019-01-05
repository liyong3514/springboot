package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 李永
 * @Description
 * @Date  2019\1\4 0004
 * @version 1.0
*/
@Entity
public class Orders {
    @Id
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    @Transient
    private String orderStatusStr;
    private int peopleCount;
    /*一对一关系映射：订单与产品*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
    /*多对多关系映射：旅客与订单*/
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "order_traveller",
            joinColumns = {@JoinColumn(name = "orderId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "travellerId", referencedColumnName = "id")})
    @OrderBy("id")
    private Set<Traveller> travellers = new HashSet<>(0);
    /*多对一关系映射：多个订单对应会员*/
    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "MEMBERID",referencedColumnName = "id")
    private Member member;
    private Integer payType;
    @Transient
    private String payTypeStr;
    private String orderDesc;

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if (orderStatus == 0) {
            orderStatusStr = "未支付";
        } else if (orderStatus == 1) {
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(Set<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        final int aliPayCode = 0;
        final int wxPay = 1;
        final int otherPay = 2;
        //支付方式(0 支付宝 1 微信 2其它)
        if (payType == aliPayCode) {
            payTypeStr = "支付宝";
        } else if (payType == wxPay) {
            payTypeStr = "微信";
        } else if (payType == otherPay) {
            payTypeStr = "其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Orders)) {
            return false;
        }

        Orders orders = (Orders) o;

        if (getOrderStatus() != orders.getOrderStatus()) {
            return false;
        }
        if (getPeopleCount() != orders.getPeopleCount()) {
            return false;
        }
        if (getId() != null ? !getId().equals(orders.getId()) : orders.getId() != null) {
            return false;
        }
        if (getOrderNum() != null ? !getOrderNum().equals(orders.getOrderNum()) : orders.getOrderNum() != null) {
            return false;
        }
        if (getOrderTime() != null ? !getOrderTime().equals(orders.getOrderTime()) : orders.getOrderTime() != null) {
            return false;
        }
        if (getOrderTimeStr() != null ? !getOrderTimeStr().equals(orders.getOrderTimeStr()) : orders.getOrderTimeStr() != null) {
            return false;
        }
        if (getOrderStatusStr() != null ? !getOrderStatusStr().equals(orders.getOrderStatusStr()) : orders.getOrderStatusStr() != null) {
            return false;
        }
        if (getProduct() != null ? !getProduct().equals(orders.getProduct()) : orders.getProduct() != null) {
            return false;
        }
        if (getTravellers() != null ? !getTravellers().equals(orders.getTravellers()) : orders.getTravellers() != null) {
            return false;
        }
        if (getMember() != null ? !getMember().equals(orders.getMember()) : orders.getMember() != null) {
            return false;
        }
        if (getPayType() != null ? !getPayType().equals(orders.getPayType()) : orders.getPayType() != null) {
            return false;
        }
        if (getPayTypeStr() != null ? !getPayTypeStr().equals(orders.getPayTypeStr()) : orders.getPayTypeStr() != null) {
            return false;
        }
        return getOrderDesc() != null ? getOrderDesc().equals(orders.getOrderDesc()) : orders.getOrderDesc() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrderNum() != null ? getOrderNum().hashCode() : 0);
        result = 31 * result + (getOrderTime() != null ? getOrderTime().hashCode() : 0);
        result = 31 * result + (getOrderTimeStr() != null ? getOrderTimeStr().hashCode() : 0);
        result = 31 * result + getOrderStatus();
        result = 31 * result + (getOrderStatusStr() != null ? getOrderStatusStr().hashCode() : 0);
        result = 31 * result + getPeopleCount();
        result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
        result = 31 * result + (getTravellers() != null ? getTravellers().hashCode() : 0);
        result = 31 * result + (getMember() != null ? getMember().hashCode() : 0);
        result = 31 * result + (getPayType() != null ? getPayType().hashCode() : 0);
        result = 31 * result + (getPayTypeStr() != null ? getPayTypeStr().hashCode() : 0);
        result = 31 * result + (getOrderDesc() != null ? getOrderDesc().hashCode() : 0);
        return result;
    }
}
