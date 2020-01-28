package pl.edu.wszib.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.IReportThatYouCanSeeDAO;
import pl.edu.wszib.model.ReportThatYouCanSee;

import java.util.List;

@Component
public class ReportThatYouCanSeeDAOImpl implements IReportThatYouCanSeeDAO {

  /*  private List<ReportThatYouCanSee> reportThatYouCanSees = new ArrayList<>();

    public ReportThatYouCanSeeDAOImpl(){
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));

        ReportThatYouCanSee reportThatYouCanSee1 = new ReportThatYouCanSee();
        reportThatYouCanSee1.setLogin("Mateusz");
        reportThatYouCanSee1.setPointOfSales("point1");
        reportThatYouCanSee1.setWhenWasLogged( ft.format(dNow));

        ReportThatYouCanSee reportThatYouCanSee2 = new ReportThatYouCanSee();
        reportThatYouCanSee2.setLogin("Piotr");
        reportThatYouCanSee2.setPointOfSales("point2");
        reportThatYouCanSee2.setWhenWasLogged(  ft.format(dNow));

        ReportThatYouCanSee reportThatYouCanSee3 = new ReportThatYouCanSee();
        reportThatYouCanSee3.setLogin("Paweł");
        reportThatYouCanSee3.setPointOfSales("point3");
        reportThatYouCanSee3.setWhenWasLogged(  ft.format(dNow));


        ReportThatYouCanSee reportThatYouCanSee4 = new ReportThatYouCanSee();
        reportThatYouCanSee4.setLogin("Jan");
        reportThatYouCanSee4.setPointOfSales("point4");
        reportThatYouCanSee4.setWhenWasLogged( ft.format(dNow));

        this.reportThatYouCanSees.add(reportThatYouCanSee1);
        this.reportThatYouCanSees.add(reportThatYouCanSee2);
        this.reportThatYouCanSees.add(reportThatYouCanSee3);
        this.reportThatYouCanSees.add(reportThatYouCanSee4);
    }

    @Override
    public List<ReportThatYouCanSee> getAllRaport(){
        return reportThatYouCanSees;
    }*/

    @Autowired
    SessionFactory sessionFactory;

    public ReportThatYouCanSeeDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveRaport(ReportThatYouCanSee reportThatYouCanSee){ //add
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(reportThatYouCanSee);
            tx.commit();
            session.close();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx != null )tx.rollback();
        }
    }

    @Override
    public ReportThatYouCanSee getRaportByLogin(String login){
        Session session = this.sessionFactory.openSession();
        ReportThatYouCanSee reportThatYouCanSee = (ReportThatYouCanSee) session
                .createQuery("FROM pl.edu.wszib.model.ReportThatYouCanSee WHERE login " + login + "").uniqueResult();
        session.close();
        return reportThatYouCanSee;
    }

    @Override
    public ReportThatYouCanSee getRaportByPointOfSales(String pointOfSales){
        Session session = this.sessionFactory.openSession();
        ReportThatYouCanSee reportThatYouCanSee = (ReportThatYouCanSee) session
                .createQuery("FROM pl.edu.wszib.ReportThatYouCanSee WHERE pointOfSales " + pointOfSales + "").uniqueResult();
        session.close();
        return reportThatYouCanSee;
    }

    @Override
    public ReportThatYouCanSee getRaportByWhenWasLogged(String whenWasLogged){
        Session session = this.sessionFactory.openSession();
        ReportThatYouCanSee reportThatYouCanSee = (ReportThatYouCanSee) session
                .createQuery("FROM pl.edu.wszib.ReportThatYouCanSee " + whenWasLogged + "").uniqueResult();
        session.close();
        return reportThatYouCanSee;
    }

    @Override
    public List<ReportThatYouCanSee> getAllRaports(){
        Session session = sessionFactory.openSession();
        List<ReportThatYouCanSee> reportThatYouCanSees = session.createQuery("FROM pl.edu.wszib.model.ReportThatYouCanSee").list();
        session.close();
        return reportThatYouCanSees;
    }
}
