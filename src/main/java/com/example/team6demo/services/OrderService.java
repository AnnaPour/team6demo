package com.example.team6demo.services;

import com.example.team6demo.model.Account;
import com.example.team6demo.model.Order;
import com.example.team6demo.model.PaymentMethod;

public interface OrderService extends BaseService<Order, Long>  {
    Order initiateOrder(Account account);

   void addItem(Order order, Product product, int quantity);

  void updateItem(Order order, Product product, int quantity);

  void removeItem(Order order, Product product);

    Order checkout(Order order, PaymentMethod paymentMethod);


    void checkout(Order secondOrder, com.example.team6demo.model.model.PaymentMethod paymentMethod);
}
