package com.bitee.services;

import com.bitee.entities.Order;

public interface OrderManagementService {
    void addOrder(Order order);
    Order[] getOrdersByUserId(int userId);
    Order[] getOrders();

}
