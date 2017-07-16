package com.testbook.mvc.services;

import com.testbook.mvc.dto.AdminDto;

/**
 * Created by Alexey on 16.07.2017.
 */
public interface LoginService {

    boolean adminVerify(AdminDto adminDto);

}
