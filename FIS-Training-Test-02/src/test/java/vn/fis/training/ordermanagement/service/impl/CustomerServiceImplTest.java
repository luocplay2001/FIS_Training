package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Test
    @Order(1)
    void findAll() {
        // table cua em ban dau la co 5 customer
        assertEquals(5,customerService.findAll().size());
    }


    @Test
    @Order(2)
    void findCustomerById() {
        Customer customer = customerService.findCustomerById(1L);
        assertEquals("Nguyễn Văn Kiên",customer.getName());
        assertEquals("Hà Nội",customer.getAddress());
        assertEquals("0571828451",customer.getMobile());
    }

    @Test
    @Order(3)
    void findByMobileNumber() {
        Customer customer = customerService.findByMobileNumber("0571828451");
        assertEquals("Nguyễn Văn Kiên",customer.getName());
        assertEquals("Hà Nội",customer.getAddress());
    }

    @Test
    @Order(4)
    @Transactional
    @Rollback
    void createCustomer() {
        Customer customer = new Customer();
        customer.setAddress("Ninh Bình");
        customer.setMobile("0936271124");
        customer.setName("Đỗ Hải Phong");
        customerService.createCustomer(customer);
        // them customer co id tu dong tang luc nay no la 6
        Customer c = customerService.findCustomerById(6L);
        assertEquals("Đỗ Hải Phong",c.getName());
        assertEquals("Ninh Bình",c.getAddress());
        assertEquals("0936271124",c.getMobile());
    }

    @Test
    @Order(5)
    @Transactional
    @Rollback
    void updateCustomer() {
        // update customer co id = 6
        Customer customer = customerService.findCustomerById(6L);
        customer.setMobile("0976231666");
        customer.setAddress("Nam Định");
        customer.setName("Nguyễn Anh Quân");
        customerService.updateCustomer(customer);
        Customer c = customerService.findCustomerById(6L);
        assertEquals("Nguyễn Anh Quân",c.getName());
        assertEquals("Nam Định",c.getAddress());
        assertEquals("0976231666",c.getMobile());
    }

    @Test
    @Order(6)
    @Transactional
    @Rollback
    void deleteCustomerById() {
        // detele customer co id = 6

        Customer customer = customerService.findCustomerById(6L);
        // xoa nhung don hang ma customer da~ dat
        orderService.findAllOrders().stream().filter(o -> o.getCustomer().getId() == 6L)
                .forEach(o -> orderService.deleteOrderById(o.getId()));

        customerService.deleteCustomerById(customer.getId());
        Customer c = customerService.findCustomerById(6L);
        assertNull(c);
    }

}