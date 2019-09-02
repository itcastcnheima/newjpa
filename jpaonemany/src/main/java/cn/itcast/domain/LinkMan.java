package cn.itcast.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cus_linkman")
public class LinkMan {

  /*  FieldTypeComment
   lkm_id bigint(32) NOT NULL联系人编号(主键)
    lkm_name varchar(16) NULL联系人姓名
    lkm_gender char(1) NULL联系人性别
    lkm_phone varchar(16) NULL联系人办公电话
    lkm_mobile varchar(16) NULL联系人手机
    lkm_email varchar(64) NULL联系人邮箱
    lkm_position varchar(16) NULL联系人职位
    lkm_memo varchar(512) NULL联系人备注
    lkm_cust_id bigint(32) NOT NULL客户id(外键)*/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "lkm_id")
  private Long kinkId;
  @Column(name = "lkm_name")
  private String lkm_name;
    @Column(name = "lkm_gender")
  private String lkm_gender;
    @Column(name = "lkm_phone")
    private String lkm_phone;
    @Column(name = "lkm_mobile")
    private String lkm_mobile;
    @Column(name = "lkm_email")
    private String lkm_email;
    @Column(name = "lkm_position")
    private String lkm_position;
    @Column(name = "lkm_memo")
    private String lkm_memo;
   @ManyToOne(targetEntity = Customer.class)
   @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;
    public Long getKinkId() {
        return kinkId;
    }

    public void setKinkId(Long kinkId) {
        this.kinkId = kinkId;
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

    @Override
    public String toString() {
        return "LinkMan{" +
                "kinkId=" + kinkId +
                ", lkm_name='" + lkm_name + '\'' +
                ", lkm_gender='" + lkm_gender + '\'' +
                ", lkm_phone='" + lkm_phone + '\'' +
                ", lkm_mobile='" + lkm_mobile + '\'' +
                ", lkm_email='" + lkm_email + '\'' +
                ", lkm_position='" + lkm_position + '\'' +
                ", lkm_memo='" + lkm_memo + '\'' +
                ", customer=" + customer +
                '}';
    }
}
