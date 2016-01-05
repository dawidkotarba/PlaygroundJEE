package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.enums.ExceptionType;
import com.dawidkotarba.playground.exceptions.AbstractApplicationRuntimeException;
import com.dawidkotarba.playground.integration.exceptions.ExceptionResponse;
import com.dawidkotarba.playground.integration.exceptions.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

@Stateless
public class ExceptionConverterService {

    public ExceptionResponse convert(AbstractApplicationRuntimeException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(e.getUuid());
        exceptionResponse.setExceptionType(e.getExceptionType());
        exceptionResponse.setDevMessage(e.getMessage());

        return exceptionResponse;
    }

    public ExceptionResponse convert(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(UUID.randomUUID());
        exceptionResponse.setExceptionType(ExceptionType.INTERNAL_ERROR);
        exceptionResponse.setDevMessage(e.getMessage());

        return exceptionResponse;
    }
}
