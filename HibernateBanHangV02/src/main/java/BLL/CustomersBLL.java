/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;
import DAL.CustomersDAL;
import DAL.Customers;

/**
 *
 * @author Nguyen
 */
public class CustomersBLL {

    private CustomersDAL cusDAL;

    public CustomersBLL() {
        cusDAL = new CustomersDAL();
    }

    public Customers getCustomers(int customerID) {
        return cusDAL.getCustomers(customerID);
    }

    public List<Customers> loadCustomers() {
        return cusDAL.loadCustomers();
    }

    public Object[][] converCustomers(List<Customers> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getPassword();
            obj[i][2] = list.get(i).getFullname();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
        }
        return obj;
    }

    public void addCustomers(Customers c) {
        cusDAL.addCustomers(c);
    }

    public void updateCustomers(Customers c) {
        cusDAL.updateCustomers(c);
    }

    public void deleteCustomers(Customers c) {
        cusDAL.deleteCustomers(c);
    }
}
