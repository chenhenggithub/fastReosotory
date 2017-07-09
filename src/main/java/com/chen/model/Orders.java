package com.chen.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders {
    private Integer orderid;
    private List<Cart> clist;

    public List<Cart> getClist() {
        return clist;
    }

    public void setClist(List<Cart> clist) {
        this.clist = clist;
    }

    private Date orderdate;

    private String userid;

    private String shipaddr;

    private String shipcity;

    private String shipname;

    private String cardno;

    private String cardtype;

    private BigDecimal totalprice;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getShipaddr() {
        return shipaddr;
    }

    public void setShipaddr(String shipaddr) {
        this.shipaddr = shipaddr == null ? null : shipaddr.trim();
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity == null ? null : shipcity.trim();
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}