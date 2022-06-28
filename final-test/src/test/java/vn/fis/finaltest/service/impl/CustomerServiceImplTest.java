package vn.fis.finaltest.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import vn.fis.finaltest.dto.CustomerDTO;
import vn.fis.finaltest.service.CustomerService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @Order(1)
    void findAll() {
        Page<CustomerDTO> customerDTOs = customerService.findAll(PageRequest.of(0,4));
        customerDTOs.forEach(customerDTO ->  log.info("CustomerDTO: {}",customerDTO));
        assertEquals(4,customerDTOs.getSize());
    }

    @Test
    @Order(2)
    void findById() {
        CustomerDTO customerDTO = customerService.findById(1L);
        assertEquals("Canh Nậu Thạch Thất Hà Nội",customerDTO.getAddress());
        assertEquals("0861247509",customerDTO.getMobile());
        assertEquals("Nguyễn Văn Kiên",customerDTO.getName());
    }

    @Test
    @Order(3)
    void createCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Đỗ Đăng Dũng")
                .address("Chàng Sơn Thạch Thất Hà Nội")
                .mobile("0978231222")
                .build();

        customerService.createCustomer(customerDTO);

        CustomerDTO c = customerService.findById(10L);
        assertEquals("Chàng Sơn Thạch Thất Hà Nội",c.getAddress());
        assertEquals("0978231222",c.getMobile());
        assertEquals("Đỗ Đăng Dũng",c.getName());
    }

    @Test
    @Order(4)
    void updateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Đỗ Đăng Khải")
                .address("Hữu Bằng Thạch Thất Hà Nội")
                .mobile("0978233333")
                .build();

        customerService.updateCustomer(10L,customerDTO);
        CustomerDTO c = customerService.findById(10L);
        assertEquals("Hữu Bằng Thạch Thất Hà Nội",c.getAddress());
        assertEquals("0978233333",c.getMobile());
        assertEquals("Đỗ Đăng Khải",c.getName());
    }

    @Test
    @Order(5)
    void deleteCustomerById() {
        customerService.deleteCustomerById(10L);
    }
}