package pl.edu.wszib.services;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Date;
import java.util.List;

public interface IProductReportService {
    List<RepositoryPointOfSales> showWhatSoldThatDay(Date date);
}
