package pl.edu.wszib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "trepositorypointofsales")
public class RepositoryPointOfSales {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idPointOfSales;
    private String productName;
    private int amountOfProduct;
    private int priceForOneProduct;
    private int totalPrice;
    private Date dateOfSell;


    public RepositoryPointOfSales() {

    }

    public RepositoryPointOfSales(int idPointOfSales, String productName, int amountOfProduct, int priceForOneProduct, int totalPrice, Date dateOfSell) {
        this.idPointOfSales = idPointOfSales;
        this.productName = productName;
        this.amountOfProduct = amountOfProduct;
        this.priceForOneProduct = priceForOneProduct;
        this.totalPrice = totalPrice;
        this.dateOfSell = dateOfSell;
    }

    public int getIdPointOfSales() {
        return idPointOfSales;
    }

    public void setIdPointOfSales(int idPointOfSales) {
        this.idPointOfSales = idPointOfSales;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public int getPriceForOneProduct() {
        return priceForOneProduct;
    }

    public void setPriceForOneProduct(int priceForOneProduct) {
        this.priceForOneProduct = priceForOneProduct;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfSell() {
        return dateOfSell;
    }

    public void setDateOfSell(Date dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    @Override
    public String toString() {
        return "RepositoryPointOfSales{" +
                "id=" + id +
                ", idPointOfSales=" + idPointOfSales +
                ", productName='" + productName + '\'' +
                ", amountOfProduct=" + amountOfProduct +
                ", priceForOneProduct=" + priceForOneProduct +
                ", totalPrice=" + totalPrice +
                ", dateOfSell=" + dateOfSell +
                '}';
    }


//    public  void vv() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
//        Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
//        System.out.println(sdf.format(calendar.getTime()));
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // the day of the week in numerical format
//    }
}
