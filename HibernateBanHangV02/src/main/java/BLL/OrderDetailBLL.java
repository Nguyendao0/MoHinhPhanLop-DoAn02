/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OrderDetail;
import DAL.OrderDetailDAL;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class OrderDetailBLL {

    private OrderDetailDAL odDAL;

    public OrderDetailBLL() {
        odDAL = new OrderDetailDAL();
    }

    public OrderDetail getOrderDetail(int orderID) {
        return odDAL.getOrderDetail(orderID);
    }

    public List<OrderDetail> loadOrderDetail() {
        return odDAL.loadOrderDetail();
    }

    public List<OrderDetail> getOrderDetailInOrder(int orderID) {
        return odDAL.getOrderDetailInOrder(orderID);
    }

    public Object[][] converOrderDetail(List<OrderDetail> list) {
        int rows = list.size();
        int cols = 2;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getQuantity();
            obj[i][1] = list.get(i).getPrice();
        }
        return obj;
    }

    public void addOrderDetail(OrderDetail c) {
        odDAL.addOrderDetail(c);
    }

    public void updateOrderDetail(OrderDetail c) {
        odDAL.updateOrderDetail(c);
    }

    public void deleteOrderDetail(OrderDetail c) {
        odDAL.deleteOrderDetail(c);
    }
}
