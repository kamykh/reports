package pl.edu.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductReportController {


    @RequestMapping(value = "/productReportMenu", method = RequestMethod.GET)
    public String showMenu(){
        return "productReportMenu";
    }

}
