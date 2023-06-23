package sg.edu.nus.iss.paf_day21_workshop.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;
    private Integer employeeId;
    private Integer customerId;
    private Date orderDate;
    private String shippedDate;
    private Integer shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private String shippingFee;
    private String taxes;
    private String paymentType;
    private String paidDate;
    private String notes;
    private String taxRate;
    private Integer taxStatusId;
    private Integer statusId;

}
