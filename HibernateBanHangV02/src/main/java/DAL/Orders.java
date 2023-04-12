/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.w3c.dom.Text;

/**
 *
 * @author Nguyen
 */
@Data
@Entity
@Table (name = "`Order`")
public class Orders {
    @Id
    private int OrderID;
    @Column
    private Date Date;
    @Column
    private float Total;
    @Column
    private String Note;

    @ManyToOne
    @JoinColumn(name="CustomerID")
    private Customers customers;
    
}
