package pl.edu.wszib.dao;

import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.SalesDetails;

import java.util.List;

public interface ISalesDAO {

    void addSales(Sales sales);

    void addSalesDetails(SalesDetails salesDetails);

    List<Double> AmountsOfSalesByUser(int userID);

    double sales(int userID);
    List<Sales> getSalesByUserID(int userID);

    Sales getSales(int userID);


}
