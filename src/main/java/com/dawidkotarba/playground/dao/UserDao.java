package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.aop.ExecutionTimeLogger;
import com.dawidkotarba.playground.exceptions.InternalErrorException;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.model.entities.User;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserDao extends AbstractDao {

    @ExecutionTimeLogger
    public List<UserOutDto> getAll() {
                List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
        return copyProperties(users, UserOutDto.class);
    }

    @ExecutionTimeLogger
    public List<UserOutDto> getByName(String username) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "Username cannot be blank");
        List<Country> result = entityManager.createQuery("SELECT u FROM User u  where u.username LIKE :username").setParameter("username", "%" + username + "%").getResultList();
        return copyProperties(result, UserOutDto.class);
    }

    @ExecutionTimeLogger
    public void add(UserInDto userInDto) {
        try {
            Preconditions.checkNotNull(userInDto, "userInDto cannot be null");
            
            User user = new User();
            BeanUtils.copyProperties(user, userInDto);
            entityManager.persist(user);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new InternalErrorException("Cannot add persist user: " , ex);
        }
    }

}
