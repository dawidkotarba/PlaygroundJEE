package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.UserDao;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Stateless
public class UserService {

    @Inject
    private UserDao userDao;

    public List<UserOutDto> getAll() {
        return userDao.getAll();
    }

    public void add(UserInDto userInDto) {
        userDao.add(userInDto);
    }

    public List<UserOutDto> getByName(String name) {
        return userDao.getByName(name);
    }
}
