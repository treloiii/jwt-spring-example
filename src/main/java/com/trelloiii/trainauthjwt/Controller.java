package com.trelloiii.trainauthjwt;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class Controller {
    @RequestMapping("/all")
    public String getAll(){
        return "All can see it";
    }
    @RequestMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getUser(){
        return "user can see it";
    }
    @RequestMapping("/moderator")
    @PreAuthorize("hasRole('MODERATOR')")
    public String getModer(){
        return "user can see it";
    }
    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdmin(){
        return "user can see it";
    }
}
