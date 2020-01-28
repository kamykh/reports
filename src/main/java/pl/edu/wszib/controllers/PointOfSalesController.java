package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IRepositoryPointOfSalesService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class PointOfSalesController {

    @Autowired
    IRepositoryPointOfSalesService repositoryPointOfSalesService;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String registerForm(Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        model.addAttribute("userModel", new RepositoryPointOfSales());

        return "addProductToRepository";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String register(@ModelAttribute RepositoryPointOfSales repositoryPointOfSales, Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        repositoryPointOfSales.setDateOfSell(Calendar.getInstance().getTime());
        repositoryPointOfSales.setTotalPrice(repositoryPointOfSales.getAmountOfProduct() * repositoryPointOfSales.getPriceForOneProduct());
        this.repositoryPointOfSalesService.addProductAfterSale(repositoryPointOfSales);

        return "pointOfSalesPage";

    }

    @RequestMapping(value = "/pointOfSalesPage", method = RequestMethod.GET)
    public String pointOfSalesPage() {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "pointOfSalesPage";
    }

    @RequestMapping(value = "/reportOfProduct", method = RequestMethod.GET)
    public String reportOfProductPage() {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "reportOfProduct";
    }

    @RequestMapping(value = "/averageOfDayOrMonth", method = RequestMethod.GET)
    public String averageOfDayOrMonthPage() {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "averageOfDayOrMonth";
    }

    @RequestMapping(value = "/showSalesWithDateFromRepository", method = RequestMethod.POST)
    public String getAllSalesWithDateFromRepository(Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getSalesWithDateFromRepository());
        return "salesFromRepository";
    }

    @RequestMapping(value = "/showProductsFromRepository", method = RequestMethod.POST)
    public String getAllProductsFromRepository(Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getProductsFromRepository());
        return "salesGroupedByProductAndPoint";
    }

    @RequestMapping(value = "/showSalesWithDateFromRepositoryByPoint", method = RequestMethod.POST)
    public String getAllSalesWithDateFromRepositoryByPoint(@RequestParam("id") int idPointOfSales, Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getSalesWithDateFromRepositoryByPoint(idPointOfSales));
        return "salesWithDateFromRepositoryByPoint";
    }

    @RequestMapping(value = "/showProductsFromRepositoryByPoint", method = RequestMethod.POST)
    public String getAllProductsFromRepositoryByPoint(@RequestParam("id") int idPointOfSales, Model model) {
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getProductsFromRepositoryByPoint(idPointOfSales));
        return "productsFromRepositoryByPoint";
    }

//    @RequestMapping(value = "/showAverageOfDay", method = RequestMethod.POST)
//    public String getAverageOfDay(@RequestParam("id") int idPointOfSales,  @RequestParam("firstDay") String firstDay, @RequestParam("secondDay") String secondDay,  Model model) throws ParseException {
//        Date day1=new SimpleDateFormat("dd-MM-yyyy").parse(firstDay);
//        Date day2=new SimpleDateFormat("dd-MM-yyyy").parse(secondDay);
//        model.addAttribute("allProducts", this.repositoryPointOfSalesService.averageOfDay(idPointOfSales,day1,day2));
//        return "averageOfDay";
//    }
//
//    @RequestMapping(value = "/showAverageOfMonth", method = RequestMethod.POST)
//    public String getAverageOfMonth(@RequestParam("id") int idPointOfSales, @RequestParam("firstMonth") Date firstMonth, @RequestParam("secondMonth") Date secondMonth, Model model) {
//        model.addAttribute("allProducts", this.repositoryPointOfSalesService.averageOfMonth(idPointOfSales,firstMonth,secondMonth));
//        return "averageOfMonth";
//    }
}
