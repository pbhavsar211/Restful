package com.mycompany;

/**
 * Created by bhavsarer on 7/15/15.
 */
public class Order {

    private Integer id;
    private String orderDesc;
    private Double orderAmt;

    public Order() {
    }

    public Order(Integer id, String orderDesc, Double orderAmt) {
        this.id = id;
        this.orderDesc = orderDesc;
        this.orderAmt = orderAmt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(Double orderAmt) {
        this.orderAmt = orderAmt;
    }
}
