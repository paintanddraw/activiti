package com.jizhang.activiti.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author aaron
 * @since 2019-09-09
 */
public class UserInfo implements Serializable {

private static final long serialVersionUID=1L;

    private Integer id;

    private String firstName;

    private String lastName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        "id=" + id +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        "}";
    }
}
