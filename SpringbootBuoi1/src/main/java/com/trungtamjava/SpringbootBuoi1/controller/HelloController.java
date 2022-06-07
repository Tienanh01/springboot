package com.trungtamjava.SpringbootBuoi1.controller;

import com.trungtamjava.SpringbootBuoi1.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
    @GetMapping("/welcome")
    public String welcome(Model model){
    model.addAttribute("data","Spring boot");
        return "user/welcome";
    }
    @GetMapping(value = "/person")
    public String PersonController(Model model){
        Person ps = new Person(1,22,"Tiến Anh","Viet nam");
        model.addAttribute("person",ps);
        return "user/person";
    }

}
