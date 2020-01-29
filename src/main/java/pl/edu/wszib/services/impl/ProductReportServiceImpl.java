package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IProductReportDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IProductReportService;

import java.util.Date;
import java.util.List;

public class ProductReportServiceImpl implements IProductReportService {

    @Autowired
    IProductReportDAO productReportDAO;

    public ProductReportServiceImpl(IProductReportDAO productReportDAO) {
        this.productReportDAO = productReportDAO;
    }


    @Override
    public List<RepositoryPointOfSales> showWhatSoldThatDay(Date date) {
        List<RepositoryPointOfSales> resultList = productReportDAO.showSaleThatDay(date);
        return resultList;
    }
}
