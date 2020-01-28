package pl.edu.wszib.services;

import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.UserReport;

import java.util.List;

public interface IUserReport {
    UserReport getUserReportByUserID(int userID);
    List<Sales> getsalesbyUserID(int userID);
    List<Double> getAmountsOfSales(int userId);
}
