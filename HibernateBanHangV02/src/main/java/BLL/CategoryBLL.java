/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CategoryDAL;
import DAL.Category;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class CategoryBLL {

    private CategoryDAL cateDAL;

    public CategoryBLL() {
        cateDAL = new CategoryDAL();
    }

    public List loadCategory() {
        List list;
        list = cateDAL.loadCategory();
        return list;
    }
    
    public Category getCategory(int CategoryID) {
        Category c = cateDAL.getCategory(CategoryID);
        return c;
    }

    public Object[][] convertList(List<Category> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }

    public void addCategory(Category c) {
        cateDAL.addCategory(c);
    }
    public void updateCategory(Category c) {
        cateDAL.updateCategory(c);
    }
    public void deleteCategory(Category c) {
        cateDAL.deleteCategory(c);
    }

}
