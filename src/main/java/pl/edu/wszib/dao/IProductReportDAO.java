package pl.edu.wszib.dao;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Date;
import java.util.List;

public interface IProductReportDAO {

    List<RepositoryPointOfSales> showSaleThatDay(Date date);

}
