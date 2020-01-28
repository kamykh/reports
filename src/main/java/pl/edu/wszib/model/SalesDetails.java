package pl.edu.wszib.model;

import javax.persistence.*;

@Entity
@Table(name = "salesdetails")
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SalesDetailsID;
    private int SalesID;
    private int ProductID;
    private int Quantity;
    private double Price;

    public SalesDetails() {
    }

    public int getSalesDetailsID() {
        return SalesDetailsID;
    }

    public void setSalesDetailsID(int salesDetailsID) {
        SalesDetailsID = salesDetailsID;
    }

    public int getSalesID() {
        return SalesID;
    }

    public void setSalesID(int salesID) {
        SalesID = salesID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "SalesDetails{" +
                "SalesDetailsID=" + SalesDetailsID +
                ", SalesID=" + SalesID +
                ", ProductID=" + ProductID +
                ", Quantity=" + Quantity +
                ", Price=" + Price +
                '}';
    }
}
