package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.ISalesDAO;
import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.SalesDetails;

import java.util.List;

@Component
public class SalesDAOImpl implements ISalesDAO {


    SessionFactory sessionFactory;


    public SalesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SalesDAOImpl() {

    }

    @Override
    public void addSales(Sales sales) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(sales);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void addSalesDetails(SalesDetails salesDetails) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(salesDetails);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Double> AmountsOfSalesByUser(int userID) {
        Session session = sessionFactory.openSession();

        List<Double> amountofSaleByUser = session.createSQLQuery("Select amountOfSales from sales  where userID =" + userID).list();

        session.close();
        return amountofSaleByUser;
    }

    @Override
    public double sales(int userID) {
        Session session = sessionFactory.openSession();

        List<Object> CountOfSales = session.createSQLQuery("Select salesID  from sales WHERE userID =" + userID).list();


        session.close();
        return CountOfSales.size();
    }

    @Override
    public List<Sales> getSalesByUserID(int userID) {
        Session session = sessionFactory.openSession();

        List<Sales> SalesByUserID = session.createSQLQuery("select * from sales WHERE userID = " + userID).list();

        session.close();
        return SalesByUserID;

    }

    @Override
    public Sales getSales(int userID) {
        Session session = sessionFactory.openSession();

        Sales sales = (Sales) session.createQuery("FROM pl.edu.wszib.model.Sales WHERE userID = " + userID).uniqueResult();

        session.close();
        return sales;
    }
}