package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.ReportThatYouCanSeeDAOImpl;
import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.rest.IReportThatYouCanSeeRest;
import pl.edu.wszib.rest.response.ReportThatYouCanSeeServiceResponse;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ReportThatYouCanSeeRestController {

    @Autowired
    IReportThatYouCanSeeRest reportThatYouCanSeeRest;

    @Autowired
    ReportThatYouCanSeeDAOImpl reportThatYouCanSeeDAO;


    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    List<ReportThatYouCanSee> reportThatYouCanSees = new ArrayList<>();
    @RequestMapping(value = "/getAllReportss",method = RequestMethod.GET)
    public ReportThatYouCanSeeServiceResponse getAllReportss() {
            ReportThatYouCanSee reportThatYouCanSee = new ReportThatYouCanSee();
            reportThatYouCanSee.setLogin("Piotr");
            reportThatYouCanSee.setPointOfSales("point");
            this.reportThatYouCanSees.add(reportThatYouCanSee);

        ReportThatYouCanSeeServiceResponse reportThatYouCanSeeServiceResponse =
                new ReportThatYouCanSeeServiceResponse();
        reportThatYouCanSeeServiceResponse.setReportThatYouCanSees(reportThatYouCanSees);
        return  reportThatYouCanSeeServiceResponse;
    }
}