package com.example.team6demo.controller;
import com.example.team6demo.mapper.BaseMapper;
import com.example.team6demo.model.Order;
import com.example.team6demo.services.BaseService;
import com.example.team6demo.services.OrderService;
import com.example.team6demo.tran.resource.CategoryResource;
import com.example.team6demo.tran.resource.OrderResource;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController extends BaseController<Order, OrderResource> {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    protected BaseService<Order, Long> getBaseService() {
        return orderService;
    }

    @Override
    protected BaseMapper<Category, CategoryResource> getMapper() {
        return orderMapper;
    }
}

