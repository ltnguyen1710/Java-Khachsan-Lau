
package DTO;

import java.util.Date;

public class Room {
    //da sua lai cac thuoc tinh cua phong
    private int ID;
    private String status;
    private int price;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" + "ID=" + ID + ", status=" + status + ", price=" + price + '}';
    }

    public void datphong(){
        
    }
}
