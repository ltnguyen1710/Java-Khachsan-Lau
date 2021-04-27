
package DTO;

import java.util.Date;

public class Customer {
    private String ID,Name,sex;
    private String date;

    public Customer() {
    }

    public Customer(String ID, String Name, String sex, String date) {
        this.ID = ID;
        this.Name = Name;
        this.sex = sex;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

   
    
}
