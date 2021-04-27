/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.DALCustomer;
import DTO.Customer;
/**
 *
 * @author Utech
 */
public class BLLCustomer {
    DALCustomer dalcustomer=new DALCustomer();
    public boolean addCus(Customer cus){
        if(!dalcustomer.hasCusID(cus.getID())){
            return dalcustomer.addCus(cus);
        }
        return false;
    }
}
