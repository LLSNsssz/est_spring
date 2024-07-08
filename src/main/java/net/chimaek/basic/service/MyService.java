package net.chimaek.basic.service;

import net.chimaek.basic.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private Helper helper;

    @Autowired
    public void setHelper(Helper helper) {
        this.helper = helper;
    }


    public String hello() {
        System.out.println(this.helper);
        return "Hello, Spring Boot!";
    }
}
