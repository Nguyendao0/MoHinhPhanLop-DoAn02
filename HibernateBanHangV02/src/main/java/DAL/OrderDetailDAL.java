/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen
 */
public class OrderDetailDAL {
    Session session;
    
    public OrderDetailDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public OrderDetail getOrderDetail(int orderID)
    {
        OrderDetail obj;
        session.beginTransaction();
        obj = session.get(OrderDetail.class, orderID);
        session.getTransaction().commit();
        return obj;
        
    }
    
    public List loadOrderDetail()
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM OrderDetail");   
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public List getOrderDetailInOrder(int orderID)
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM OrderDetail WHERE OrderID = :orderID");
        q.setParameter("orderID", orderID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    public void addOrderDetail(OrderDetail obj)
    {
        session.save(obj);
    }
    public void updateOrderDetail(OrderDetail obj)
    {
        session.update(obj);
    }
    public void deleteOrderDetail(OrderDetail obj)
    {
        session.delete(obj);
    }
}
