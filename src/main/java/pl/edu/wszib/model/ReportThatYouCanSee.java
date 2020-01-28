package pl.edu.wszib.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "treportthatyoucansee")
public class ReportThatYouCanSee {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;
    private String pointOfSales;
    private Date whenWasLogged;

    public ReportThatYouCanSee(String login, String pointOfSales, Date whenWasLogged) {
        this.login = login;
        this.pointOfSales = pointOfSales;
        this.whenWasLogged = whenWasLogged;
    }

    public ReportThatYouCanSee() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPointOfSales() {
        return pointOfSales;
    }

    public void setPointOfSales(String pointOfSales) {
        this.pointOfSales = pointOfSales;
    }

    public Date getWhenWasLogged() {
        return whenWasLogged;
    }

    public void setWhenWasLogged(Date whenWasLogged) {
        this.whenWasLogged = whenWasLogged;
    }

    @Override
    public String toString() {
        return "ReportThatYouCanSee{" +
                "login='" + login + '\'' +
                ", pointOfSales='" + pointOfSales + '\'' +
                ", whenWasLogged=" + whenWasLogged +
                '}';
    }


}
