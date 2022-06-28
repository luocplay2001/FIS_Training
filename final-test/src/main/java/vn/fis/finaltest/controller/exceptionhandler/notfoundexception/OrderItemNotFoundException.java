package vn.fis.finaltest.controller.exceptionhandler.notfoundexception;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException(Long orderItemId) {
        super(String.format("Không tìm thấy orderItem với id = %s",orderItemId));
    }
}
