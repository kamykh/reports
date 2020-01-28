package pl.edu.wszib.rest.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import pl.edu.wszib.dao.ISalesDAO;
import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.SalesDetails;
import pl.edu.wszib.rest.ISaleRest;
import pl.edu.wszib.rest.response.SalesServiceResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class salesRest implements ISaleRest {


        ISalesDAO salesDAO;

        public salesRest(ISalesDAO salesDAO){
            this.salesDAO = salesDAO;
        }

        @Override
        public void callAndAddToDAOSales() {
            String url = "http://localhost:8080/sales";
            String url1 = "http://localhost:8080/salesDetails";
            RestTemplate restTemplate = new RestTemplate();
            RestTemplate restTemplate2 = new RestTemplate();
            SalesServiceResponse response = restTemplate.getForObject(url,
                    SalesServiceResponse.class);
            SalesServiceResponse response1 = restTemplate2.getForObject(url1,
                    SalesServiceResponse.class);
            for(Sales sales : response.getSales()) {
                salesDAO.addSales(sales);
                System.out.println("test2");
                System.out.println(response.getSales());
            }
            for(SalesDetails salesDetails : response1.getSalesDetails()) {
                salesDAO.addSalesDetails(salesDetails);
                System.out.println("test3");
                System.out.println(response1.getSalesDetails());
            }

            System.out.println("DB was updated");

        }
}

