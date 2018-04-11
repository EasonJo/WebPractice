package cn.eason.domain;

import java.util.Objects;

public class LinkMan {
    private Long lkm_id;
    private String lkm_name;
    private String lkm_gender;
    private String lkm_phone;
    private String lkm_mobile;
    private String lkm_email;
    private String lkm_qq;
    private String lkm_position;
    private String lkm_memo;
    private Customer customer;

    //不与数据库中的列对应,只为了接收表单参数
    private Long cust_id;

    public Long getLkm_id() {
        return lkm_id;
    }

    public void setLkm_id(Long lkm_id) {
        this.lkm_id = lkm_id;
    }

    public String getLkm_name() {
        return lkm_name;
    }

    public void setLkm_name(String lkm_name) {
        this.lkm_name = lkm_name;
    }

    public String getLkm_gender() {
        return lkm_gender;
    }

    public void setLkm_gender(String lkm_gender) {
        this.lkm_gender = lkm_gender;
    }

    public String getLkm_phone() {
        return lkm_phone;
    }

    public void setLkm_phone(String lkm_phone) {
        this.lkm_phone = lkm_phone;
    }

    public String getLkm_mobile() {
        return lkm_mobile;
    }

    public void setLkm_mobile(String lkm_mobile) {
        this.lkm_mobile = lkm_mobile;
    }

    public String getLkm_email() {
        return lkm_email;
    }

    public void setLkm_email(String lkm_email) {
        this.lkm_email = lkm_email;
    }

    public String getLkm_qq() {
        return lkm_qq;
    }

    public void setLkm_qq(String lkm_qq) {
        this.lkm_qq = lkm_qq;
    }

    public String getLkm_position() {
        return lkm_position;
    }

    public void setLkm_position(String lkm_position) {
        this.lkm_position = lkm_position;
    }

    public String getLkm_memo() {
        return lkm_memo;
    }

    public void setLkm_memo(String lkm_memo) {
        this.lkm_memo = lkm_memo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkMan)) return false;
        LinkMan linkMan = (LinkMan) o;
        return Objects.equals(getLkm_id(), linkMan.getLkm_id()) &&
            Objects.equals(getLkm_name(), linkMan.getLkm_name()) &&
            Objects.equals(getLkm_gender(), linkMan.getLkm_gender()) &&
            Objects.equals(getLkm_phone(), linkMan.getLkm_phone()) &&
            Objects.equals(getLkm_mobile(), linkMan.getLkm_mobile()) &&
            Objects.equals(getLkm_email(), linkMan.getLkm_email()) &&
            Objects.equals(getLkm_qq(), linkMan.getLkm_qq()) &&
            Objects.equals(getLkm_position(), linkMan.getLkm_position()) &&
            Objects.equals(getLkm_memo(), linkMan.getLkm_memo()) &&
            Objects.equals(getCustomer(), linkMan.getCustomer());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLkm_id(), getLkm_name(), getLkm_gender(), getLkm_phone(), getLkm_mobile(), getLkm_email(),
            getLkm_qq(), getLkm_position(), getLkm_memo(), getCustomer());
    }

    @Override
    public String toString() {
        return "LinkMan{" +
            "lkm_id=" + lkm_id +
            ", lkm_name='" + lkm_name + '\'' +
            ", lkm_gender='" + lkm_gender + '\'' +
            ", lkm_phone='" + lkm_phone + '\'' +
            ", lkm_mobile='" + lkm_mobile + '\'' +
            ", lkm_email='" + lkm_email + '\'' +
            ", lkm_qq='" + lkm_qq + '\'' +
            ", lkm_position='" + lkm_position + '\'' +
            ", lkm_memo='" + lkm_memo + '\'' +
            ", customer=" + customer +
            '}';
    }
}
