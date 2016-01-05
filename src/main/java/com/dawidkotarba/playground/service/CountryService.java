/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author Dawid Kotarba
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CountryService {

    @Inject
    private CountryDao countryDao;

    public List<CountryDto> getAll() {
        return countryDao.getAll();
    }

    public List<CountryDto> getByName(String name) {
        return countryDao.getByName(name);
    }

    public void add(CountryDto countryDto) {
        countryDao.add(countryDto);
    }
}
