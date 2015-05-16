package com.springapp.mvc;

/**
 * Created by Administrator on 2015/5/3.
 */
public class Address {
    public Address() {
    }

    private String province;
    private  String city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
