package com.bouchtaouimarouane.securityservice.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {
    @GetMapping("/dataTest")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> dataRest(Authentication authentication){
        return Map.of(
                "message","Data test",
                "username",authentication.getName(),
                "authorities",authentication.getAuthorities()
                );
    }
    @PostMapping ("/saveData")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String,String> saveData(String data){
        return Map.of("dataSaved",data);
    }
}