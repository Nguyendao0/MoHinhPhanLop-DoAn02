/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Nguyen
 */
@Data
public class OrderDetailPK implements Serializable {

    private Vegetable vegetable;
    private Orders orders;
}
