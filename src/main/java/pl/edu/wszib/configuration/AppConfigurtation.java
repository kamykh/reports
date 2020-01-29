package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.IProductReportDAO;
import pl.edu.wszib.dao.IReportThatYouCanSeeDAO;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.dao.ISalesDAO;
import pl.edu.wszib.dao.impl.ProductReportDAOImpl;
import pl.edu.wszib.dao.impl.ReportThatYouCanSeeDAOImpl;
import pl.edu.wszib.dao.impl.RepositoryPointOfSalesDAOImpl;
import pl.edu.wszib.dao.impl.SalesDAOImpl;
import pl.edu.wszib.rest.IReportThatYouCanSeeRest;
import pl.edu.wszib.rest.ISaleRest;
import pl.edu.wszib.rest.impl.ReportThatYouCanSeeRestImpl;
import pl.edu.wszib.rest.impl.salesRest;
import pl.edu.wszib.services.IProductReportService;
import pl.edu.wszib.services.IReportThatYouCanSeeService;
import pl.edu.wszib.services.IRepositoryPointOfSalesService;
import pl.edu.wszib.services.IUserReport;
import pl.edu.wszib.services.impl.ProductReportServiceImpl;
import pl.edu.wszib.services.impl.ReportThatYouCanSeeServiceImpl;
import pl.edu.wszib.services.impl.RepositoryPointOfSalesServiceImpl;
import pl.edu.wszib.services.impl.UserReportImpl;

@Configuration
public class AppConfigurtation {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

    @Bean
    public SessionFactory hibernateSessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public ISalesDAO salesDAO(SessionFactory hibernateSessionFactory) {
        return new SalesDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IUserReport userReport(ISalesDAO salesDAO) {
        return new UserReportImpl(salesDAO);
    }
    @Bean
    public ISaleRest saleRest(ISalesDAO salesDAO) {
        return new salesRest(salesDAO);
    }

    @Bean
    public IReportThatYouCanSeeRest reportThatYouCanSeeRest(IReportThatYouCanSeeDAO reportThatYouCanSeeDAO){
        return new ReportThatYouCanSeeRestImpl(reportThatYouCanSeeDAO);
    }

    @Bean
    public IReportThatYouCanSeeDAO reportThatYouCanSeeDAO(SessionFactory hibernateSessionFactory){
        return new ReportThatYouCanSeeDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IReportThatYouCanSeeService reportThatYouCanSeeService(IReportThatYouCanSeeDAO reportThatYouCanSeeDAO){
        return  new ReportThatYouCanSeeServiceImpl(reportThatYouCanSeeDAO);
    }

    @Bean
    public IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO(SessionFactory hibernateSessionFactory){
        return new RepositoryPointOfSalesDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IRepositoryPointOfSalesService repositoryPointOfSalesService(IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO){
        return new RepositoryPointOfSalesServiceImpl(repositoryPointOfSalesDAO);
    }

    @Bean
    public IProductReportDAO productReportDAO(SessionFactory hibernateSessionFactory){
        return new ProductReportDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IProductReportService productReportService(IProductReportDAO productReportDAO){
        return new ProductReportServiceImpl(productReportDAO);
    }
}
