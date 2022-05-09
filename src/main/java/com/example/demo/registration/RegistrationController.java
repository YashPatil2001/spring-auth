package com.example.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class RegistrationController {

//    @Autowired
    RegistrationService registrationService;


    @PostMapping("/registration")
    private String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/hello")
    private String hello(){
        return "Hello Yash";
    }

    @GetMapping("/confirm/{token}")
    private String confirmedToken(@PathVariable("token") String token){
        return registrationService.confirmed(token);
    }
}
