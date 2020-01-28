package pl.edu.wszib.rest.response;

import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.SalesDetails;

import java.util.List;

public class SalesServiceResponse {
    private List<Sales> sales;

    public List<Sales> getSales() {
        return sales;
    }
    public void setSalesList(List<Sales> sales) {
        this.sales = sales;
    }
    private List<SalesDetails> salesDetails;

    public List<SalesDetails> getSalesDetails() {
        return salesDetails;
    }
    public void setSalesDetails(List<SalesDetails> salesDetails) {
        this.salesDetails = salesDetails;
    }
}
