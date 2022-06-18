package vn.fis.training.ordermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;

@SpringBootApplication
public class OrderManagementApplication {
	private static final Logger log = LoggerFactory.getLogger(OrderManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}


	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;
	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.info("Welcome to spring application. Pls write test method in here to run for testing only");
				log.info("Total order with Waiting Approval status : {} order(s)",
						orderService.findWaitingApprovalOrders().size());
				log.info("Total order with CREATED status : {} order(s)",
						orderService.findOrdersByOrderStatus(OrderStatus.CREATED).size());
				log.info(customerService.findByMobileNumber("0357826757").toString());
				log.info(customerService.findCustomerById(1L).toString());
				log.info("Total order with Date : {} order(s)",
						orderService.findOrdersBetween(
						LocalDateTime.of(2001,03,24,12,25,00),
						LocalDateTime.of(2003,03,24,12,25,00)).size());
				log.info("Total order with Customer : {} order(s)",
						orderService.findOrdersByCustomer(customerService.findCustomerById(1L)).size());
			}
		};
	}

}
