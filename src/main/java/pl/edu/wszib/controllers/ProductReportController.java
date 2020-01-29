package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IProductReportService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductReportController {


    @Autowired
    IProductReportService productReportService;

    @RequestMapping(value = "/productReportMenu", method = RequestMethod.GET)
    public String showMenu(Model model){
        model.addAttribute("date", new Date());
        return "productReportMenu";
    }

    @RequestMapping(value = "/showSaleThatDay", method = RequestMethod.POST)
    public String showSTD(@RequestParam(value = "date") String date, Model model){
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("list", productReportService.showWhatSoldThatDay(date1));
        return "showSaleThatDay";
    }
}
