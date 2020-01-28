package pl.edu.wszib.services;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface IRepositoryPointOfSalesService {
    void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales); //adding product after sale


    List<RepositoryPointOfSales> getProductsFromRepository(); // return  list of products grouped by idPointOfSales and productName and sum amount and totalPrice

    List<RepositoryPointOfSales> getSalesWithDateFromRepository(); // return all sales without group by with date

    List<RepositoryPointOfSales> getSalesWithDateFromRepositoryByPoint(int idPointOfSales); // return all sales from pointOfSales without group by, with date

    List<RepositoryPointOfSales> getProductsFromRepositoryByPoint(int idPointOfSales); // return  list of products from pointOfSales grouped by idPointOfSales and productName and sum amount and totalPrice

    List<RepositoryPointOfSales> averageOfDay(int idPointOfSales, Date firstDay, Date secondDay); //return list of average sales per day in the interval firstDay - secondDay

    List<RepositoryPointOfSales> averageOfMonth(int idPointOfSales, Date firstMonth, Date secondMonth); //return list of average sales per month in the interval firstMonth - secondMonth

}
