/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Nguyen
 */
@Data
@Entity
@Table
public class Customers {
    @Id
    private int CustomerID;
    @Column 
    private String Password;
    @Column
    private String Fullname;
    @Column 
    private String Address;
    @Column
    private String City;
    
    @OneToMany (mappedBy = "customers")  
    private List<Orders> listOrder;
    
    @Override
    public String toString()
    {
        return this.Fullname;
    }
}
