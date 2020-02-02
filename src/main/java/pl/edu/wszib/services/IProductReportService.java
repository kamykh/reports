package pl.edu.wszib.services;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IProductReportService {
    List<RepositoryPointOfSales> showWhatSoldThatDay(String date) throws ParseException;
    List<RepositoryPointOfSales> showWhatSoldBetween(String firstDate, String secondDate);
    List<RepositoryPointOfSales> showIncome(String productName);
    List<RepositoryPointOfSales> showStats();
}
