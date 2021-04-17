
package DTO;

import java.util.Date;

public class Customer {
    private String ID,Name,sex;
    private Date date;
    

    public Customer(String ID, String Name, String sex, Date date) {
        this.ID = ID;
        this.Name = Name;
        this.sex = sex;
        this.date = date;
    }

    public Customer() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
