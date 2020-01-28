package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IRepositoryPointOfSalesService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RepositoryPointOfSalesServiceImpl implements IRepositoryPointOfSalesService {

    @Autowired
    IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO;

    public RepositoryPointOfSalesServiceImpl(IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO) {
        this.repositoryPointOfSalesDAO = repositoryPointOfSalesDAO;
    }

    @Override
    public void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales) {
        this.repositoryPointOfSalesDAO.addProductAfterSale(repositoryPointOfSales);
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepository() {
        return this.repositoryPointOfSalesDAO.getProductsFromRepository();
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepository() {
        return this.repositoryPointOfSalesDAO.getSalesWithDateFromRepository();
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepositoryByPoint(int idPointOfSales) {
        return this.repositoryPointOfSalesDAO.getSalesWithDateFromRepositoryByPoint(idPointOfSales);
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepositoryByPoint(int idPointOfSales) {
        return this.repositoryPointOfSalesDAO.getProductsFromRepositoryByPoint(idPointOfSales);
    }

    @Override
    public List<RepositoryPointOfSales> averageOfDay(int idPointOfSales, Date firstDay, Date secondDay) {
        return this.repositoryPointOfSalesDAO.averageOfDay(idPointOfSales, firstDay, secondDay);
    }

    @Override
    public List<RepositoryPointOfSales> averageOfMonth(int idPointOfSales, Date firstMonth, Date secondMonth) {
        return this.repositoryPointOfSalesDAO.averageOfMonth(idPointOfSales, firstMonth, secondMonth);
    }
}
