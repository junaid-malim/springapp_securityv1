package com.junaid.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//    @GetMapping("/signin")
//    public ResponseEntity<String> signin(){
//        return new ResponseEntity<String>("login.html",HttpStatus.OK);
//    }

    @GetMapping("/signin")
    public String signin(){
        return "login.html";
    }
}
