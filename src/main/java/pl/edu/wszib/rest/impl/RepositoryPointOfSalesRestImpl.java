package pl.edu.wszib.rest.impl;

import org.springframework.web.client.RestTemplate;
import pl.edu.wszib.dao.IReportThatYouCanSeeDAO;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.rest.IRepositoryPointOfSalesRest;
import pl.edu.wszib.rest.response.ReportThatYouCanSeeServiceResponse;
import pl.edu.wszib.rest.response.RepositoryPointOfSalesResponse;

public class RepositoryPointOfSalesRestImpl implements IRepositoryPointOfSalesRest {

    IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO;

    public RepositoryPointOfSalesRestImpl(IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO){
        this.repositoryPointOfSalesDAO = repositoryPointOfSalesDAO;
    }

    
    @Override
    public void callAndAddToRepositoryPointOfSalesDAO() {
        String url = "http://localhost:8282/ReportPointOfSales";
        RestTemplate restTemplate = new RestTemplate();
        RepositoryPointOfSalesResponse repositoryPointOfSalesResponse = restTemplate.getForObject(url,
                RepositoryPointOfSalesResponse.class);
        for(RepositoryPointOfSales repositoryPointOfSales : repositoryPointOfSalesResponse.getReportThatYouCanSees()){
            repositoryPointOfSalesDAO.addProductAfterSale(repositoryPointOfSales);
            System.out.println("test");
            System.out.println(repositoryPointOfSalesResponse.getReportThatYouCanSees());

        }

        System.out.println("Db");
    }



}
