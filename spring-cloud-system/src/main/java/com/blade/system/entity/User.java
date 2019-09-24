package com.blade.system.entity;

import com.blade.system.common.utils.GenIdUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}