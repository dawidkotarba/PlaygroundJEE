package com.dawidkotarba.playground.controllers;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;

import javax.validation.Valid;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Path("/countries")
@RequestScoped
public class CountryController {

    @Inject
    private CountryService countryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> all() {
        return countryService.getAll();
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getByName(@PathParam("name")String name) {
        return countryService.getByName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void add(@Valid CountryDto countryDto) {
        countryService.add(countryDto);
    }
}
