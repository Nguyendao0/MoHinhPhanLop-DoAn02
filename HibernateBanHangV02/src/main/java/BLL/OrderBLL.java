/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OrderDAL;
import DAL.Orders;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class OrderBLL {

    private OrderDAL ordDAL;

    public OrderBLL() {
        ordDAL = new OrderDAL();
    }

    public Orders getOrder(int OrderID) {
        Orders c = ordDAL.getOrder(OrderID);
        return c;
    }

    public List loadOrder() {
        List list;
        list = ordDAL.loadOrder();
        return list;
    }

    public List<Orders> getOrderInCustomer(int orderID) {
        return ordDAL.getOrderInCustomer(orderID);
    }

    public Object[][] convertList(List<Orders> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getOrderID();
            obj[i][1] = list.get(i).getDate();
            obj[i][2] = list.get(i).getTotal();
            obj[i][3] = list.get(i).getNote();
            obj[i][4] = list.get(i).getCustomers();
        }
        return obj;
    }

    public void addOrder(Orders c) {
        ordDAL.addOrder(c);
    }

    public void updateOrder(Orders c) {
        ordDAL.updateOrder(c);
    }

    public void deleteOrder(Orders c) {
        ordDAL.deleteOrder(c);
    }
}
