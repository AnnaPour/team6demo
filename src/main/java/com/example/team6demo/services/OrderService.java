package com.example.team6demo.services;

import com.example.team6demo.model.*;

public interface OrderService extends BaseService<Order, Long>  {
    Order initiateOrder(Account account);

    Order initiateOrder(Customer customer);

    void addItem(Order order, Product product, int quantity);

  void updateItem(Order order, Product product, int quantity);

  void removeItem(Order order, Product product);

    default Order checkout(PaymentMethod paymentMethod) {
        return checkout(null, paymentMethod);
    }

    default Order checkout(Order order, PaymentMethod paymentMethod) {
        return null;
    }


    Order checkout(Order secondOrder, PaymentMethod paymentMethod);
}
