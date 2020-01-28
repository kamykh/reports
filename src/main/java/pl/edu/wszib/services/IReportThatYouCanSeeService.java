package pl.edu.wszib.services;

import pl.edu.wszib.model.ReportThatYouCanSee;

public interface IReportThatYouCanSeeService {
    ReportThatYouCanSee getRaportByLogin(String login);

    ReportThatYouCanSee getRaportByPointOfSales(String pointOfSales);

    ReportThatYouCanSee getRaportByWhenWasLogged(String whenWasLogged);
}
