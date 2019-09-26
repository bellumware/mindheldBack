package com.mindheld.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest")
public class UserController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/prueba")
    public String prueba(){
        return "La que te pario";
    }



}
