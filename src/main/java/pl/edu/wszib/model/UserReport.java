package pl.edu.wszib.model;

import java.util.List;

public class UserReport {
    private int userID;
    private double salesPerDay;
    private double salesPerMonth;
    private List<Double> amountsOfSales;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getSalesPerDay() {
        return salesPerDay;
    }

    public void setSalesPerDay(double salesPerDay) {
        this.salesPerDay = salesPerDay;
    }

    public double getSalesPerMonth() {
        return salesPerMonth;
    }

    public void setSalesPerMonth(double salesPerMonth) {
        this.salesPerMonth = salesPerMonth;
    }

    public List<Double> getAmountOfSales() {
        return amountsOfSales;
    }

    public void setAmountOfSales(List<Double> amountOfSales) {
        this.amountsOfSales = amountOfSales;
    }

    @Override
    public String toString() {
        return "UserReport{" +
                "userID=" + userID +
                ", salesPerDay=" + salesPerDay +
                ", salesPerMonth=" + salesPerMonth +
                ", amountOfSales=" + amountsOfSales +
                '}';
    }
}
