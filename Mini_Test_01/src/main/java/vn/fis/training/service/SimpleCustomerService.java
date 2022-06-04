package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    @Override
    public InMemoryCustomerStore getCustomerStore() {
        return customerStore;
    }

    @Override
    public void setCustomerStore(InMemoryCustomerStore customerStore) {
        this.customerStore = customerStore;
    }

    @Override
    public Customer findById(String id) throws CustomerNotFoundException {
        if(isNullOrEmpty(id)) {
            throw new IllegalArgumentException("Khong the tim kiem voi Empty ID");
        }
        Customer customer = customerStore.findById(id);
        return customer;

    }

//    @Override
//    public Customer findById(String id) {
//        if(isNullOrEmpty(String.valueOf(id))){
//            throw new IllegalArgumentException("ko the tim kiem voiw dmtryy ID");
//        }
//        List<Customer> listCustomer = customerStore.findAll();
//        for (int idx =0; idx<listCustomer.size(); idx++){
//            if(listCustomer.get(idx).getId().equals(id)){
//                return listCustomer.get(idx);
//            }
//        }
//
//        throw new CustomerNotFoundException(
//                String.format("ko tim thay customer voi ID %s",id));
//    }

    private boolean isNullOrEmpty(String id) {
        if(id == null) return false;
        if(id.trim().length() == 0) return false;
        return true;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        validate(customer);
        checkDuplicate(customer);
        Customer c = customerStore.insertOrUpdate(customer);
        return c;
    }

    private void checkDuplicate(Customer customer) {
        if(customerStore.findAll().stream().filter(c -> {
            return c.getMobile().equals(customer.getMobile());
        }).findFirst().isPresent())
            throw  new DuplicateCustomerException(customer,String.format(
                    "Customer with phone number %s is duplicate",customer.getMobile()));
    }

    private void validate(Customer customer) {
        if(!isNullOrEmpty(customer.getName())) {
            throw new InvalidCustomerException("Customer name is empty");
        }

        if(!isNullOrEmpty(customer.getMobile())) {
            throw new InvalidCustomerException("Mobile is empty");
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        validate(customer);
        findById(customer.getId());
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = customerStore.findAll();
        return list;
    }

    @Override
    public void deleteCustomerById(String id) {
        if(isNullOrEmpty(id)) {
            throw new IllegalArgumentException("Can not delete customer with empty id");
        }
        findById(id);
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, int limit) {
        List<Customer> listCustomer = customerStore.findAll();
        listCustomer = listCustomer.stream().filter(c
                -> c.getName().contains(custName))
                .collect(Collectors.toList());
        return listCustomer.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        List<Customer> listCustomer = customerStore.findAll();
        List<SummaryCustomerByAgeDTO> summaryCustomerByAgeDTOList = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String strDate = simpleDateFormat.format(new Date());
        int dateCurrent = Integer.parseInt(strDate);
        for(Customer c : listCustomer) {
            int dateBirth = c.getBirthDay().getYear();
            int age = dateCurrent - dateBirth;
            if(mp.containsKey(age))
                mp.put(age, mp.get(age) + 1);
            else
                mp.put(age, 1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            SummaryCustomerByAgeDTO temp = new SummaryCustomerByAgeDTO(entry.getKey(), entry.getValue());
            summaryCustomerByAgeDTOList.add(temp);
        }
        return summaryCustomerByAgeDTOList.stream().sorted(
                Comparator.comparing(SummaryCustomerByAgeDTO::getAge).reversed())
                .collect(Collectors.toList());
    }

}
