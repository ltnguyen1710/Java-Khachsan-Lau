/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DALCustomer;
import DTO.Customer;
import java.util.Vector;

/**
 *
 * @author Utech
 */
public class BLLCustomer {

    DALCustomer dalcustomer = new DALCustomer();
    private Vector<Customer> customer = new Vector();
        public Vector<Customer> getCustomerlist() {
            customer=dalcustomer.getCustomerlist();
            return customer;
        }

    public boolean addCus(Customer cus) {
        if (!dalcustomer.hasCusID(cus.getID())) {
            return dalcustomer.addCus(cus);
        }
        return false;
    }

    public boolean checkID(String id) {
        if (dalcustomer.hasCusID(id)) {
            return true;
        }
        return false;
    }

    public Customer xuatcusID(String cmnd) {
        return dalcustomer.xuatcusID(cmnd);
    }
}
