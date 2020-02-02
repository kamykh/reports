package pl.edu.wszib.dao;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface IProductReportDAO {

    List<RepositoryPointOfSales> showSaleThatDay(String date);
    List<RepositoryPointOfSales> showSaleBetween(String firstDate, String secondDate);
    List<RepositoryPointOfSales> showIncomeByName(String productName);
    List<RepositoryPointOfSales> showStats();
}
