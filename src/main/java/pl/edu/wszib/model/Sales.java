package pl.edu.wszib.model;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesID;
    private int userID;
    private String name;
    private String surname;
    private double amountOfSales;
    private String Date;
    private String time;

    public Sales() {
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAmounOfSales() {
        return amountOfSales;
    }

    public void setAmounOfSales(double amounOfSales) {
        this.amountOfSales = amounOfSales;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesID=" + salesID +
                ", userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", amounOfSales=" + amountOfSales +
                ", Date='" + Date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}