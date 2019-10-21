package com.blade.system.base.domain;

import com.blade.system.common.utils.GenIdUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import java.io.Serializable;
import javax.persistence.*;

@ApiModel(description = "用户实体")
@Table(name = "base_user")
public class User implements Serializable {

    @ApiModelProperty(name = "id", value = "主键", dataType = "String")
    @Id
    @KeySql(genId = GenIdUtil.class)
    private String id;

    @ApiModelProperty(name = "name", value = "用户真实姓名", dataType = "String")
    private String name;

    @ApiModelProperty(name = "username", value = "用户名", dataType = "String")
    private String username;

    @ApiModelProperty(name = "password", value = "密码", dataType = "String")
    private String password;

    private String sex;

    private String email;

    private String phone;

    private String address;

    private String remark;

    private String state;

    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                '}';
    }
}