package fr.takoyadev.car.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VidangeController {

    @RequestMapping("/")
    public String test() {
        return "OK";
    }
}
