/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import org.hibernate.annotations.Tuplizer;
import org.hibernate.tuple.entity.PojoEntityTuplizer;


/**
 *
 * @author Nguyen
 */
@Data
@Entity
@IdClass(OrderDetailPK.class)
@Table(name ="OrderDetail")
@Tuplizer(impl = PojoEntityTuplizer.class)
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="VegetableID")
    private Vegetable vegetable;

    @Id
    @ManyToOne
    @JoinColumn(name="OrderID")
    private Orders orders;

    @Column 
    private byte Quantity;
    
    @Column
    private float Price;
}



