package vn.fis.training.store;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public final class InMemoryCustomerStore {
    /**
     *  Map dung de lu tru customer trong he thong
     */
    private final Map<String, Customer> mapCustomer = new HashMap<>();


    public Map<String, Customer> getMapCustomer() {
        return mapCustomer;
    }

    public Customer findById(String id) {
        Customer c = mapCustomer.get(id);
        return c;
    }

    /**
     * @param customer doi tuong customer (da duoc chuan hoa truoc do)
     * @return Customer: Doi tuong customer sau khi da duoc luu thanh cong vao he thong
     * @throws vn.fis.training.exception.ApplicationException tuong ung.
     */
    public Customer insertOrUpdate(Customer customer) {
        //TODO: Implement theo dac ta
        customer.setName(changeName(customer.getName()));
        mapCustomer.put(customer.getId(),customer);
        return customer;
    }

    /**
     * @return : tra ve toan bo danh sach customer trong he thong
     */
    public List<Customer> findAll() {
        return new ArrayList<>(mapCustomer.values());
    }

    /**
     * @param id: Id cua customer muon delete
     */
    public void deleteById(String id) {
        //TODO: Implement method  dac ta
        mapCustomer.remove(id);
    }

    public String changeName(String s) {
        String res = "";
        s = s.toLowerCase();
        s = s.trim();
        String[] word = s.split("\\s+");
        for(String temp : word) {
            res += temp.substring(0,1).toUpperCase() + temp.substring(1,temp.length()) + " ";
        }
        res = res.substring(0,res.length() - 1);
        return res;
    }

}
