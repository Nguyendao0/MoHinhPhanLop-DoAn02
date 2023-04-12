/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
public class CategoryDAL {
    Session session;

    public CategoryDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCategory() {
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();
        return category;
    }
    public Category getCategory(int CategoryID)
    {
        Category c = session.get(Category.class, CategoryID);
        return c;
    }
    public void addCategory(Category c)
    {
       
        session.save(c);
        
    }
    public void updateCategory(Category c)
    {
        session.update(c);
        
    }
    public void deleteCategory(Category c)
    {
        session.delete(c);
    }
}
