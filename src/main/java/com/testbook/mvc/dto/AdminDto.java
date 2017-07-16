package com.testbook.mvc.dto;

import com.testbook.mvc.domain.Admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Alexey on 16.07.2017.
 */
public class AdminDto {

    @NotNull
    @Size(min = 1, message = "{admin.login.err}")
    private String login;
    @NotNull
    @Size(min = 1, message = "{admin.password.err}")
    private String password;

    public static class Builder {

        AdminDto adminDto = new AdminDto();

        public Builder setLogin(Admin admin) {
            adminDto.setLogin(admin.getLogin());
            return this;
        }

        public Builder setPassword(Admin admin) {
            adminDto.setPassword(admin.getPassword());
            return this;
        }

        public AdminDto build(){
            return adminDto;
        }

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
}
