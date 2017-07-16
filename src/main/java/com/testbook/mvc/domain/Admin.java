package com.testbook.mvc.domain;

import com.testbook.mvc.dto.AdminDto;

import javax.persistence.*;

/**
 * Created by Alexey on 16.07.2017.
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;

    public static class Builder {

        Admin admin = new Admin();

        public Builder setLogin(AdminDto adminDto) {
            admin.setLogin(adminDto.getLogin());
            return this;
        }

        public Builder setPassword(AdminDto adminDto) {
            admin.setPassword(adminDto.getPassword());
            return this;
        }

        public Admin build(){
            return admin;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
