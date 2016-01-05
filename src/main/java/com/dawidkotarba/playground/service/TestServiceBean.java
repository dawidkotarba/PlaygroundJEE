package com.dawidkotarba.playground.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by Dawid Kotarba on 04.12.2015.
 */

@Stateless
@LocalBean
public class TestServiceBean {

    public String test(){
        return "hello ;)";
    }
}
