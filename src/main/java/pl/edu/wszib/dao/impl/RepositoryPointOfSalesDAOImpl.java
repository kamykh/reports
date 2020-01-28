package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RepositoryPointOfSalesDAOImpl implements IRepositoryPointOfSalesDAO {
    @Autowired
    SessionFactory sessionFactory;


    public RepositoryPointOfSalesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales) { //adding product after sale
        Session session;
        Transaction tx = null;

        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(repositoryPointOfSales);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepository() {  // return  list of products grouped by idPointOfSales and productName, with sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listProductsFromRepository = session
                .createQuery("SELECT R.idPointOfSales, R.productName, SUM(R.amountOfProduct), R.priceForOneProduct, SUM(R.totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales R " +
                        "GROUP BY R.idPointOfSales, R.productName")
                .list();
        session.close();
        return listProductsFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepository() {  // return all sales without group by , with date
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listSalesWithDateFromRepository = session
                .createQuery("FROM pl.edu.wszib.model.RepositoryPointOfSales")
                .list();
        session.close();
        return listSalesWithDateFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepositoryByPoint(int idPointOfSales) {// return all sales from pointOfSales , with date
        Session session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listSalesWithDateFromRepositoryByPoint = session
                .createQuery("Select idPointOfSales, productName,amountOfProduct, priceForOneProduct,totalPrice, dateOfSell FROM pl.edu.wszib.model.RepositoryPointOfSales R WHERE  R.idPointOfSales = '" + idPointOfSales + "'")
                .list();
        session.close();

        return listSalesWithDateFromRepositoryByPoint;
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepositoryByPoint(int idPointOfSales) {// return  list of products from pointOfSales grouped by idPointOfSales and productName, with sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listProductsFromRepositoryByPoint = session
                .createQuery("Select R.idPointOfSales, R.productName, SUM(R.amountOfProduct), R.priceForOneProduct, SUM(R.totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales R " +
                        "WHERE R.idPointOfSales = '" + idPointOfSales + "' GROUP BY R.idPointOfSales, R.productName")
                .list();
        session.close();

        return listProductsFromRepositoryByPoint;
    }

    @Override
    public List<RepositoryPointOfSales> averageOfDay(int idPointOfSales, Date firstDay, Date secondDay) {
        Calendar firstDayCal = Calendar.getInstance();
        firstDayCal.setTime(firstDay);
        int firDay = firstDayCal.get(Calendar.DAY_OF_MONTH);
        int firMonth = firstDayCal.get(Calendar.MONTH);
        int firYear = firstDayCal.get(Calendar.YEAR);

        Calendar secondDayCal = Calendar.getInstance();
        secondDayCal.setTime(secondDay);
        int secDay = secondDayCal.get(Calendar.DAY_OF_MONTH);
        int secMonth = secondDayCal.get(Calendar.MONTH);
        int secYear = secondDayCal.get(Calendar.YEAR);

        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAverageOfDayFromRepositoryByPoint = session
                .createQuery("SELECT idPointOfSales, AVG(totalPrice) AS totalPricePerDay, dateOfSell, " +
                        "AVG(SELECT  AVG(totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between 2000-21-01 00:00:00' and 2000-23-01 23:59:00' GROUP BY idPointOfSales, day(dateOfSell))) AS averagePerDay" +
                        "  FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between 2000-21-01 00:00:00' and 2000-23-01 23:59:00' " +
                        " GROUP BY idPointOfSales, day(dateOfSell)")
                .list();

        secondDay.getTime();

        session.close();

        return listAverageOfDayFromRepositoryByPoint;

    }

    @Override
    public List<RepositoryPointOfSales> averageOfMonth(int idPointOfSales, Date firstMonth, Date secondMonth) {
        Calendar firstDayCal = Calendar.getInstance();
        firstDayCal.setTime(firstMonth);
        int firDay = firstDayCal.get(Calendar.DAY_OF_MONTH);
        int firMonth = firstDayCal.get(Calendar.MONTH);
        int firYear = firstDayCal.get(Calendar.YEAR);

        Calendar secondDayCal = Calendar.getInstance();
        secondDayCal.setTime(secondMonth);
        int secDay = secondDayCal.get(Calendar.DAY_OF_MONTH);
        int secMonth = secondDayCal.get(Calendar.MONTH);
        int secYear = secondDayCal.get(Calendar.YEAR);
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAverageOfMonthFromRepositoryByPoint = session
                .createQuery("SELECT idPointOfSales, AVG(totalPrice) AS averagePrice, dateOfSell, " +
                        "AVG(SELECT AVG(totalPrice)  FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firYear + "'-'" + firMonth + "'-00 00:00:00' and '"
                        + secYear + "'-'" + secMonth + "'-31 23:59:00' " + " GROUP BY idPointOfSales, month(dateOfSell))) AS averagePerMonth" +
                        "FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firYear + "'-'" + firMonth + "'-00 00:00:00' and '"
                        + secYear + "'-'" + secMonth + "'-31 23:59:00' " +
                        " GROUP BY idPointOfSales, month(dateOfSell)")
                .list();
        session.close();

        return listAverageOfMonthFromRepositoryByPoint;
    }
}
