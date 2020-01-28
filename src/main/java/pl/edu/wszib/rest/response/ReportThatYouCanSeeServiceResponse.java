package pl.edu.wszib.rest.response;

import pl.edu.wszib.model.ReportThatYouCanSee;

import java.util.List;

public class ReportThatYouCanSeeServiceResponse {

    private List<ReportThatYouCanSee> reportThatYouCanSees;

    public List<ReportThatYouCanSee> getReportThatYouCanSees(){
        return  reportThatYouCanSees;
    }

    public void setReportThatYouCanSees(List<ReportThatYouCanSee> reportThatYouCanSees) {
        this.reportThatYouCanSees = reportThatYouCanSees;
    }
}
