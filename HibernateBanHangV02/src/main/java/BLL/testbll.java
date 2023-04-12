/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Category;
import DAL.OrderDetail;
import DAL.OrderDetailDAL;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class testbll {
    public static void main(String[] args) {
        OrderDetailDAL bll = new OrderDetailDAL();
        List list = bll.loadOrderDetail();
        
        for (Iterator iterator = list.iterator(); iterator.hasNext();){
             OrderDetail v = (OrderDetail) iterator.next(); 
             System.out.print("ID order: " + v.getOrders().getOrderID());
             //System.out.print("   name vegetable: " + v.getVegetable().getVegetable_Name());
             System.out.print("   ID vegetable: " + v.getVegetable().getVegetableID());             
             System.out.print("   Quantity: " + v.getQuantity()); 
             System.out.println("   Price: " + v.getPrice()); 
             
          }
    }
}
