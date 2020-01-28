package pl.edu.wszib.rest.response;


import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.SalesDetails;
import pl.edu.wszib.model.UserReport;

import java.util.List;

public class UserReportServiceResponse {


        private List<UserReport> userReports1;

        public List<UserReport> getUserReport() {
            return userReports1;
        }
        public void setUserReportsList(List<UserReport> userReports1) {
            this.userReports1 = userReports1; }


}


