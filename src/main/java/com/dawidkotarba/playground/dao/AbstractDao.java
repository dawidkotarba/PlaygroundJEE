package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Dawid Kotarba
 */
public class AbstractDao {

    @PersistenceContext(name = "playgroundPU")
    protected EntityManager entityManager;

    protected <A, B> List<B> copyProperties(List<A> source, Class<B> targetClass) {
        List<B> result = new ArrayList<>();

        source.forEach(entity -> {
            B dto = null;
            try {
                dto = targetClass.newInstance();
                BeanUtils.copyProperties(dto, entity);
                result.add(dto);
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException ex) {
                throw new InternalErrorException("Cannot copy entity to dto", ex);
            }
        }
        );

        return result;
    }

}
