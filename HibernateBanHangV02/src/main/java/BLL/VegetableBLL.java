/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.VegetableDAL;
import DAL.Vegetable;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class VegetableBLL {

    private VegetableDAL vegDAL;

    public VegetableBLL() {
        vegDAL = new VegetableDAL();
    }

    public Vegetable getVegetable(int VegetableID) {
        return vegDAL.getVegetable(VegetableID);
    }

    public List<Vegetable> loadVegetable() {
        return vegDAL.loadVegetable();
    }

    public List<Vegetable> getVegetableInCategory(int categoryID) {
        return vegDAL.getVegetableInCategory(categoryID);
    }

    public Object[][] converVegetable(List<Vegetable> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetable_Name();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getAmount();
            obj[i][4] = list.get(i).getImage();
            obj[i][5] = list.get(i).getPrice();
        }
        return obj;
    }

    public void addVegetable(Vegetable v) {
        vegDAL.addVegetable(v);
    }

    public void updateVegetable(Vegetable v) {
        vegDAL.updateVegetable(v);
    }

    public void deleteVegetable(Vegetable v) {
        vegDAL.deleteVegetable(v);
    }
}
