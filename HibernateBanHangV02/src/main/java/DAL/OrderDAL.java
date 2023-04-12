/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Text;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen
 */
public class OrderDAL {

    Session session;

    public OrderDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    //tim kiem order theo id
    public Orders getOrder(int OrderID) {
        Orders ord;
        session.beginTransaction();
        ord = session.get(Orders.class, OrderID);
        session.getTransaction().commit();
        return ord;
    }
    //tim kiem order trong customer
    public List getOrderInCustomer(int customerID)
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Orders WHERE CustomerID = :customerID");
        q.setParameter("customerID", customerID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public List loadOrder()
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Orders");   
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
        public void addOrder(Orders c) {
        session.save(c);
    }

    public void updateOrder(Orders c) {
        session.update(c);
    }

    public void deleteOrder(Orders c) {
        session.delete(c);
    }

//    public static void main(String[] args) {
//
//        OrderDAL orddal = new OrderDAL();
//        
//        LocalDate localDate = LocalDate.now();
//        Date date = java.sql.Date.valueOf(localDate);
//
//        Orders order = new Orders();
//        order.setOrderID(4);
//        order.setDate(date);
//        order.setTotal(100.0f);
//        order.setNote("This is a new order (da update)");
//
//        Customers customer = new Customers();
//        customer.setCustomerID(1);
//        order.setCustomers(customer);
//
//        
//        //lưu vào csdl
//
////        orddal.addOrder(order);
////        orddal.deleteOrder(order);
////        orddal.updateOrder(order);
////        System.out.print("name: di ngu   "+ orddal.getOrder(1).getTotal() + "\n");
////        orddal.Search();
////       System.out.print("name: " + orddal.getOrder(1).getTotal() + "\n");
////
//        List list = orddal.getOrderInCustomer(1);
//        
//        for (Iterator iterator = list.iterator(); iterator.hasNext();){
//             Orders v = (Orders) iterator.next(); 
//             
//             System.out.print("xin chao " );
//             
//             System.out.print("ID: " + v.getCustomers().getFullname()); 
//             System.out.print("   Note: " + v.getNote());
//             System.out.println("   Name: " + v.getTotal()); 
//             
//        }
//    }
}
