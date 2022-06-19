package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Long customerId) {
        Optional<Customer> opt = customerRepository.findById(customerId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }
    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        Optional<Customer> opt = customerRepository.findById(customerId);
        if(opt.isPresent())
            customerRepository.deleteById(customerId);
        else
            throw new IllegalArgumentException(String.format("ID khong ton tai: %s",customerId));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByMobileNumber(String mobileNumber) {
        return customerRepository.findByMobile(mobileNumber);
    }
}
