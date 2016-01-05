package com.dawidkotarba.playground.controllers;

import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.service.UserService;

import javax.validation.Valid;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
@Path("/users")
@RequestScoped
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserOutDto> getAll() {
        return userService.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserOutDto> getByName(@PathParam("name") String name) {
        return userService.getByName(name);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void add(@Valid UserInDto userInDto) {
        userService.add(userInDto);
    }
}
