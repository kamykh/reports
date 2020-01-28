package pl.edu.wszib.services.impl;

import pl.edu.wszib.dao.IReportThatYouCanSeeDAO;
import pl.edu.wszib.model.ReportThatYouCanSee;
import pl.edu.wszib.services.IReportThatYouCanSeeService;

public class ReportThatYouCanSeeServiceImpl implements IReportThatYouCanSeeService {

    IReportThatYouCanSeeDAO raportDAO;
    public ReportThatYouCanSeeServiceImpl(IReportThatYouCanSeeDAO raportDAO) {
        this.raportDAO = raportDAO;
    }


    @Override
    public ReportThatYouCanSee getRaportByLogin(String login){
        return this.raportDAO.getRaportByLogin(login);
    }

    @Override
    public ReportThatYouCanSee getRaportByPointOfSales(String pointOfSales){
        return this.raportDAO.getRaportByLogin(pointOfSales);
    }

    @Override
    public ReportThatYouCanSee getRaportByWhenWasLogged(String whenWasLogged){
        return this.raportDAO.getRaportByLogin(whenWasLogged);
    }
}
