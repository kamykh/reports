package pl.edu.wszib.dao.impl;

import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IProductReportDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductReportDAOImpl implements IProductReportDAO {

    @Autowired
    SessionFactory sessionFactory;

    public ProductReportDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<RepositoryPointOfSales> showSaleThatDay(Date date) {


        Calendar day = Calendar.getInstance();
        day.setTime(date);
        int tDay = day.get(Calendar.DAY_OF_MONTH);
        int tMonth = day.get(Calendar.MONTH) + 1;
        int tYear = day.get(Calendar.YEAR);


        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> resultList = session
                .createQuery("SELECT productName,amountOfProduct AS numberSold " +
                        "FROM pl.edu.wszib.model.RepositoryPointOfSales WHERE DATE(dateOfSell) = '" + tYear + "-" + tMonth + "-" + tDay + "' GROUP BY productName")
                .list();
        return resultList;

    }
}
