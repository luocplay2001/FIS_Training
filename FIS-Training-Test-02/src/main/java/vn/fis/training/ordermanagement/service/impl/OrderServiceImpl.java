package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order finOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long orderId, OrderItem orderItem) {
        Order order = finOrderById(orderId);
        order.getOrderItems().add(orderItem);
        order.setTotalAmount(order.getTotalAmount() + (orderItem.getAmount() * orderItem.getQuantity()));
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order removeOrderItem(Long orderId, OrderItem orderItem) {
        Order order = finOrderById(orderId);
        order.setTotalAmount(order.getTotalAmount() - (orderItem.getAmount() * orderItem.getQuantity()));
        order.getOrderItems().remove(orderItem);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        order.setStatus(orderStatus);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return orderRepository.findByOrderDateTimeBetween(fromDateTime,toDateTime);
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        return orderRepository.findByStatus(OrderStatus.WAITING_APPROVAL);
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findByStatus(orderStatus);
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return orderRepository.findByCustomer(customer.getId());
    }
}
