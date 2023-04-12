/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen
 */
public class VegetableDAL {
    Session session;
    
    public VegetableDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public Vegetable getVegetable(int vegetableID)
    {
        Vegetable obj;
        session.beginTransaction();
        obj = session.get(Vegetable.class, vegetableID);
        session.getTransaction().commit();
        return obj;    
    }
    
    public List getVegetableInCategory(int categoryID)
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE CatagoryID = :categoryID");
        q.setParameter("categoryID", categoryID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public List loadVegetable()
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable");       
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public ArrayList Search(String name)
    {      
     ArrayList<Vegetable> list = new ArrayList<Vegetable>();
     List<Vegetable> lv = new ArrayList<>();
     lv = loadVegetable();
        for(Vegetable v : lv) {
            if(v.getVegetable_Name().contains(name))
            {
               list.add(v);
            }        
        }   
        return list;
    }
    
    public void addVegetable(Vegetable obj)
    {
        session.save(obj);
    }
    public void updateVegetable(Vegetable obj)
    {
        session.update(obj);
    }
    public void deleteVegetable(Vegetable obj)
    {
        session.delete(obj);
    }
    
//    public static void main(String args[])
//    {
//        VegetableDAL vegdal = new VegetableDAL();
//        
//        Category c = new Category();
//        c.setCatagoryID(1);
//        
//        
//        //nhap du lieu
//        Vegetable veg = new Vegetable();
//        veg.setVegetableID(10);
//        veg.setVegetable_Name("rau den");
//        veg.setAmount(20);
//        veg.setUnit("kg");
//        veg.setPrice(50.0);
//        veg.setImage("images/celery.jpg");
//        veg.setCatagory(c);
//        
//        //vegdal.Search("rau");
//        //lưu vào csdl
////        System.out.print("name: " + vegdal.getVegetable(1).getVegetable_Name() + "\n");
////        
////        
////        
////        
////        List<Vegetable> list = vegdal.getVegetableInCategory(1);
////        for (Vegetable v : list) {
////            System.out.println(v.getVegetable_Name());
////        }
//        List list = vegdal.Search("rau");
//        
//        for (Iterator iterator = list.iterator(); iterator.hasNext();){
//             Vegetable v = (Vegetable) iterator.next(); 
//             
//             System.out.print("xin chao " );
//             
//             System.out.print("ID: " + v.getVegetableID()); 
//             System.out.println("   Name: " + v.getVegetable_Name()); 
//             
//        }
////        
//    
//    }
}
