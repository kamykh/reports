package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IProductReportDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IProductReportService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductReportServiceImpl implements IProductReportService {

    @Autowired
    IProductReportDAO productReportDAO;

    public ProductReportServiceImpl(IProductReportDAO productReportDAO) {
        this.productReportDAO = productReportDAO;
    }

    public static Date StringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        System.out.println("Date object value: "+date);
        return date;
    }

    @Override
    public List<RepositoryPointOfSales> showWhatSoldThatDay(String date) throws ParseException {

        List<RepositoryPointOfSales> resultList = productReportDAO.showSaleThatDay(date);
        return resultList;
    }

    @Override
    public List<RepositoryPointOfSales> showWhatSoldBetween(String firstDate, String secondDate) {
        List<RepositoryPointOfSales> resultList = productReportDAO.showSaleBetween(firstDate,secondDate);
        return resultList;
    }

    @Override
    public List<RepositoryPointOfSales> showIncome(String productName) {
        List<RepositoryPointOfSales> resultList = productReportDAO.showIncomeByName(productName);
        return resultList;
    }

    @Override
    public List<RepositoryPointOfSales> showStats() {
        List<RepositoryPointOfSales> resultList = productReportDAO.showStats();
        return resultList;
    }
}
