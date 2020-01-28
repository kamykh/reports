package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.ISalesDAO;
import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.UserReport;
import pl.edu.wszib.services.IUserReport;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserReportImpl implements IUserReport {

    @Autowired
    ISalesDAO salesDAO;

    LocalDate currentDate = LocalDate.now();

    public UserReportImpl(ISalesDAO salesDAO) {
        this.salesDAO = salesDAO;
    }

    @Override
    public UserReport getUserReportByUserID(int userID) {
        UserReport userReport = new UserReport();

        List<Sales> sales = salesDAO.getSalesByUserID(userID);

        int y = currentDate.getYear();
        userReport.setUserID(userID);
        userReport.setAmountOfSales(salesDAO.AmountsOfSalesByUser(userID));

        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
            userReport.setSalesPerDay(salesDAO.sales(userID)/366);
        }
        else{
            userReport.setSalesPerDay(salesDAO.sales(userID)/365);
        }
         userReport.setSalesPerMonth(salesDAO.sales(userID)/12);
        return userReport;
    }

    @Override
    public List<Sales> getsalesbyUserID(int userID) {
        List<Sales> salesByUser = salesDAO.getSalesByUserID(userID);
        return salesByUser;
    }

    @Override
    public List<Double> getAmountsOfSales(int userId) {
        List<Double> amountOfSales = salesDAO.AmountsOfSalesByUser(userId);
        return amountOfSales;
    }


}
