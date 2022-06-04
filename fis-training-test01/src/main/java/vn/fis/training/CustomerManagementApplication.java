package vn.fis.training;


import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.service.CustomerService;
import vn.fis.training.service.SimpleCustomerService;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CustomerManagementApplication
{
    public static void main( String[] args )
    {
        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        InMemoryCustomerStore inMemoryCustomerStore = new InMemoryCustomerStore();

        Customer c1 = new Customer("1233125","Nguyen Van Kien",LocalDate.of(2017, 5, 15),
                "0912345678", CustomerStatus.ACTIVE,localDateTime);
        Customer c2 = new Customer("124212135","Do Ba Hai",LocalDate.of(2001, 5, 15),
                "0936431256", CustomerStatus.ACTIVE,localDateTime);
        Customer c3 = new Customer("1545345","Tran Hai Nam",LocalDate.of(1999, 5, 15),
                "0863214213", CustomerStatus.ACTIVE,localDateTime);
        Customer c4 = new Customer("12543543","Do Duy Nam",LocalDate.of(1999, 5, 15),
                "0821412847", CustomerStatus.ACTIVE,localDateTime);
        Customer c5 = new Customer("1424125","Do Dang Nam",LocalDate.of(2001, 5, 15),
                "0162361636", CustomerStatus.ACTIVE,localDateTime);
        Customer c6 = new Customer("123213213","Chu Cao Kien",LocalDate.of(1999, 5, 15),
                "08427217321", CustomerStatus.ACTIVE,localDateTime);
//        inMemoryCustomerStore.insertOrUpdate(c1);
//        inMemoryCustomerStore.insertOrUpdate(c2);
//        inMemoryCustomerStore.insertOrUpdate(c3);
//        inMemoryCustomerStore.getMapCustomer().
//        List<Customer> listCustomer = inMemoryCustomerStore.findAll();
//        System.out.println(inMemoryCustomerStore.findById(c1.getId()));
//        System.out.println(listCustomer);

        CustomerService customerService = new SimpleCustomerService();
        customerService.setCustomerStore(new InMemoryCustomerStore());
        customerService.createCustomer(c1);
        customerService.createCustomer(c2);
        customerService.createCustomer(c3);
        customerService.createCustomer(c4);
        customerService.createCustomer(c5);
        customerService.createCustomer(c6);
        System.out.println(customerService.summaryCustomerByAgeOrderByAgeDesc());
    }

    // TODO: Implement method to test all CustomerService
}
