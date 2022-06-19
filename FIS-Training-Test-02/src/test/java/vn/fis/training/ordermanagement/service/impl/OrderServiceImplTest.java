package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.*;
import vn.fis.training.ordermanagement.repository.OrderItemRepository;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void finOrderById() {
        System.out.println(orderService.findOrderById(1L));
    }

    @Test
    void findOrdersBetween() {
         List<Order> orders = orderService.findOrdersBetween(
                LocalDateTime.of(2001,03,24,12,25,00),
                LocalDateTime.of(2003,03,24,12,25,00));
         assertEquals(1,orders.size());

    }

    @Test
    void findWaitingApprovalOrders() {
        List<Order> orders = orderService.findWaitingApprovalOrders();
        assertEquals(3,orders.size());
    }

    @Test
    void findOrdersByOrderStatus() {
        List<Order> orders =  orderService.findOrdersByOrderStatus(OrderStatus.CREATED);
        assertEquals(3,orders.size());
    }

    @Test
    void findOrdersByCustomer() {
        Customer customer = customerService.findCustomerById(1L);
        List<Order> orders = orderService.findOrdersByCustomer(customer);
        assertEquals(2,orders.size());
    }

    @Test
    void createOrder() {
        Customer customer = new Customer();
        customer.setAddress("Khánh Hoà");
        customer.setMobile("0832546888");
        customer.setName("Khuất Thị Vy");

        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmount(0.0);
        order.setOrderDateTime(LocalDateTime.of(2002,8,16,10,35,37));
        order.setCustomer(customer);
        orderService.createOrder(order);
        System.out.println(orderService.findOrderById(17L));
    }

    @Test
    void addOrderItem() {
        Product product = new Product();
        product.setName("Bún bò huế");
        product.setPrice(45.0);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(2);
        orderItem.setAmount(90.0);
        orderItem.setOrder(orderService.findOrderById(1L));

        orderService.addOrderItem(1L,orderItem);
        System.out.println(orderService.findOrderById(1L).getOrderItems());
    }

    @Test
    void removeOrderItem() {
        OrderItem orderItem = orderItemRepository.findById(10L).get();
        orderService.removeOrderItem(5L,orderItem);
//        System.out.println(orderService.findOrderById(1L).getOrderItems());
//        orderItemRepository.delete(orderItem);
    }

    @Test
    void updateOrderStatus() {
        Order order = orderService.findOrderById(1L);
        orderService.updateOrderStatus(order,OrderStatus.PAID);
        Order o = orderService.findOrderById(1L);
        assertEquals(80.0,o.getTotalAmount(),0.0000000000001);
    }
}