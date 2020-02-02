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
    public String showMenu(){
        return "productReportMenu";
    }

    @RequestMapping(value = "/showSaleThatDay", method = RequestMethod.POST)
    public String showSTD(@RequestParam(value = "date") String date, Model model) throws ParseException {
        model.addAttribute("list", this.productReportService.showWhatSoldThatDay(date));
        return "showSaleThatDay";
    }

    @RequestMapping(value = "/showSaleBetween", method = RequestMethod.POST)
    public String showSBD(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2, Model model) {
        model.addAttribute("list", this.productReportService.showWhatSoldBetween(date1,date2));
        return "showSaleBetween";
    }

    @RequestMapping(value = "/showIncome", method = RequestMethod.POST)
    public String showIncome(@RequestParam(value = "productName") String productName, Model model) {
        model.addAttribute("list", this.productReportService.showIncome(productName));
        return "showIncome";
    }

    @RequestMapping(value = "/showStats", method = RequestMethod.POST)
    public String showIncome(Model model) {
        model.addAttribute("list", this.productReportService.showStats());
        return "showStats";
    }
}

