package com.examplethymeleaf.demo.controller;

import com.examplethymeleaf.demo.VO.City;
import com.examplethymeleaf.demo.VO.Pagination;
import com.examplethymeleaf.demo.VO.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(ModelMap model, HttpServletRequest request) {
        //model会放入上下文中
        //1.1.1
        model.put("message", "Hello Thymeleaf!");
        //1.1.2
        Person person = new Person();
        person.setName("Peter 张");
        person.setAge(19);
        model.put("user", person);
        //1.1.7
        Date now = new Date();
        model.put("now", now);
        //1.4
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        model.put("pagination", pagination);
        //2.2
        model.put("umessage", "<b>Hello Thymeleaf</b>");
        //4
        City sz = new City("深圳");
        City gz = new City("广州");
        City fs = new City("佛山");
        List<City> cities = new ArrayList<City>();
        cities.add(sz);
        cities.add(gz);
        cities.add(fs);
        model.put("cities", cities);
        return "index1";
    }
}
