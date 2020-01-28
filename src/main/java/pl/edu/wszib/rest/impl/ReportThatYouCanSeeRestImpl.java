package pl.edu.wszib.rest.impl;

import org.springframework.web.client.RestTemplate;
import pl.edu.wszib.dao.IReportThatYouCanSeeDAO;
import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.rest.IReportThatYouCanSeeRest;
import pl.edu.wszib.rest.response.ReportThatYouCanSeeServiceResponse;

public class ReportThatYouCanSeeRestImpl implements IReportThatYouCanSeeRest {

    IReportThatYouCanSeeDAO reportThatYouCanSeeDAO;

    public ReportThatYouCanSeeRestImpl(IReportThatYouCanSeeDAO reportThatYouCanSeeDAO){
        this.reportThatYouCanSeeDAO = reportThatYouCanSeeDAO;
    }


        @Override
        public void callAndAddToReportThatYouCanSeeDao(){
        String url = "http://localhost:8282/ReportThatYouCanSee";
            RestTemplate restTemplate = new RestTemplate();
            ReportThatYouCanSeeServiceResponse reportThatYouCanSeeServiceResponse = restTemplate.getForObject(url,
                    ReportThatYouCanSeeServiceResponse.class);
            for(ReportThatYouCanSee reportThatYouCanSee : reportThatYouCanSeeServiceResponse.getReportThatYouCanSees()){
                reportThatYouCanSeeDAO.saveRaport(reportThatYouCanSee);
                System.out.println("test");
                System.out.println(reportThatYouCanSeeServiceResponse.getReportThatYouCanSees());

            }

            System.out.println("Db");
        }

}
