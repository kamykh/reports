package pl.edu.wszib.rest.response;

import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.List;

public class RepositoryPointOfSalesResponse {
    private List<RepositoryPointOfSales> repositoryPointOfSales;

    public List<RepositoryPointOfSales> getReportThatYouCanSees(){
        return  repositoryPointOfSales;
    }

    public void setReportThatYouCanSees(List<RepositoryPointOfSales> repositoryPointOfSales) {
        this.repositoryPointOfSales = repositoryPointOfSales;
    }
}
