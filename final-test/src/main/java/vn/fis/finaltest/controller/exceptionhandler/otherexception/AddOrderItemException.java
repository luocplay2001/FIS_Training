package vn.fis.finaltest.controller.exceptionhandler.otherexception;

import vn.fis.finaltest.model.Status;

public class AddOrderItemException extends RuntimeException{
    public AddOrderItemException(Status status) {
        super(String.format("Chỉ được thêm orderItem vào order có trạng thái là %s",status.name()));
    }
}
