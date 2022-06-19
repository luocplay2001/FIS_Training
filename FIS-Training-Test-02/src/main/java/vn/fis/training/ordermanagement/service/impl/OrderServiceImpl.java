package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderItemRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long orderId) {
        Optional<Order> opt = orderRepository.findById(orderId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long orderId, OrderItem orderItem) {
        Order order = findOrderById(orderId);
        if(order != null) {
//            List<OrderItem> orders = order.getOrderItems();
//            orders.add(orderItem);
//            order.setOrderItems(orders);
            orderItemRepository.save(orderItem);
            if(order.getTotalAmount() == null)
                order.setTotalAmount(0.0);
            order.setTotalAmount(order.getTotalAmount() + (orderItem.getProduct().getPrice()
                    * orderItem.getQuantity()));
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order removeOrderItem(Long orderId, OrderItem orderItem) {
        Order order = findOrderById(orderId);
        if(order != null) {
            order.setTotalAmount(order.getTotalAmount() - (orderItem.getProduct().getPrice()
                    * orderItem.getQuantity()));
            orderRepository.save(order);
            orderItemRepository.deleteById(orderItem.getId());
            return order;
        }
        return null;
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
