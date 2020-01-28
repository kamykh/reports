package pl.edu.wszib.dao;

import pl.edu.wszib.model.ReportThatYouCanSee;

import java.util.List;

public interface IReportThatYouCanSeeDAO {
   // List<ReportThatYouCanSee> getAllRaport();

    void saveRaport(ReportThatYouCanSee reportThatYouCanSee);

    ReportThatYouCanSee getRaportByLogin(String login);

    ReportThatYouCanSee getRaportByPointOfSales(String pointOfSales);

    ReportThatYouCanSee getRaportByWhenWasLogged(String whenWasLogged);

    List<ReportThatYouCanSee> getAllRaports();
}
