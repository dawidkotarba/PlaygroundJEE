package com.dawidkotarba.playground.web;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Dawid Kotarba
 */

@ManagedBean
@SessionScoped
public class CountryBean {
    
    @Inject
    private CountryService countryService;
    
    public String test(){
        List<CountryDto> result = countryService.getAll();
        
        return result.get(0).getName();
    }

}
