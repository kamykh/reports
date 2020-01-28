package pl.edu.wszib.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IProductReportDAO;

public class ProductReportDAOImpl implements IProductReportDAO {

    @Autowired
    SessionFactory sessionFactory;


}
