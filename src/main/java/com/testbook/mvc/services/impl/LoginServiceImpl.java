package com.testbook.mvc.services.impl;

import com.testbook.mvc.domain.Admin;
import com.testbook.mvc.dto.AdminDto;
import com.testbook.mvc.repository.AdminRepository;
import com.testbook.mvc.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Alexey on 16.07.2017.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private AdminRepository adminRepository;

    @Autowired
    public LoginServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean adminVerify(AdminDto adminDto) {
        Admin admin = adminRepository.findAdminByLoginAndPassword(adminDto.getLogin(),adminDto.getPassword());
        return Objects.nonNull(admin);
    }
}
