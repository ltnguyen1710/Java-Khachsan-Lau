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

    public Vector<Customer> getCustomerlist() {
        Vector<Customer> customer = new Vector();
        customer = dalcustomer.getCustomerlist();
        return customer;
    }

    public String tenCus(String cmnd) {
        return dalcustomer.tenCus(cmnd);
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

    public String FixCus(String ID, String ten, String Sex, String date) {
        if (dalcustomer.FixCus(ID, ten, Sex, date)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    public String DelCus(String ID) {
        if (dalcustomer.DelCus(ID)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
}
