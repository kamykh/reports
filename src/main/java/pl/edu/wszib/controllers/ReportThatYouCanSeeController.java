package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.ReportThatYouCanSeeDAOImpl;
import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.model.User;
import pl.edu.wszib.rest.IReportThatYouCanSeeRest;

import javax.annotation.Resource;


@Controller
public class ReportThatYouCanSeeController {



    @Autowired
    IReportThatYouCanSeeRest reportThatYouCanSeeRest;

    @Autowired
    ReportThatYouCanSeeDAOImpl reportThatYouCanSeeDAO;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;



    @RequestMapping(value = "/reportThatYouCanSeePage",method = RequestMethod.GET)
    public String reportThatYouCanSeePage(Model model){

        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "reportThatYouCanSeePage";
    }



    @RequestMapping(value = "/addReportThatYouCanSee",method = RequestMethod.GET)
    public String addReportThatYouCanSee(){
        this.reportThatYouCanSeeRest.callAndAddToReportThatYouCanSeeDao();
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "redirect:allReportThatYouCanSee";
    }

   @RequestMapping(value = "/addReportThatYouCanSee",method = RequestMethod.POST)
    public String addReportThatYouCanSeeForm(@ModelAttribute ReportThatYouCanSee reportThatYouCanSee , Model model){
        this.reportThatYouCanSeeDAO.saveRaport(reportThatYouCanSee);
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "redirect:allReportThatYouCanSee";

    }

    @RequestMapping(value = "/allReportThatYouCanSee",method = RequestMethod.GET)
    public String raportPage(Model model, User user){
        model.addAttribute("allReportThatYouCanSee",this.reportThatYouCanSeeDAO.getAllRaports());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "allReportThatYouCanSee";

    }

}
