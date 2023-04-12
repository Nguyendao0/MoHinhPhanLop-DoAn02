/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;



import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen
 */
public class CustomersDAL {

    Session session;

    public CustomersDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public Customers getCustomers(int CustomersID)
    {
        Customers c = session.get(Customers.class, CustomersID);
        return c;
    }
    
    public void addCustomers(Customers obj) {
        session.save(obj);
    }

    public void updateCustomers(Customers obj) {
        session.update(obj);
    }

    public void deleteCustomers(Customers obj) {
        session.delete(obj);
    }

    public List loadCustomers()
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Customers");       
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public void Search(String name)
    {
     List<Customers> lc = new ArrayList<>();
     lc = loadCustomers();
        for(Customers v : lc) {
            if(v.getFullname().contains(name))
            {
                System.out.println(v.getFullname());
            }        
        }       
    }


//    public static void main(String[] args) {
//
//        CustomersDAL cusdal = new CustomersDAL();
//
//
//        //nhap du lieu
//        Customers cus = new Customers();
//        
//        cus.setCustomerID(10);
//        cus.setFullname("rau den tim");
//        cus.setPassword("123456");
//        cus.setCity("TP HCM");
//        cus.setAddress("Thu Duc");
//        //lưu vào csdl
//        
////        cusdal.addCustomers(cus);
////        cusdal.deleteCustomers(cus);
//        cusdal.updateCustomers(cus);
//
////        cusdal.Search("a");
//        System.out.print("name: " + cusdal.getCustomers(10) + "\n");
////
////        List<Vegetable> list = cusdal.getVegetableInCategory(1);
////        for (Vegetable v : list) {
////            System.out.println(v.getVegetable_Name());
////        }
//    }

}
