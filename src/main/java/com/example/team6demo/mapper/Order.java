package com.example.team6demo.mapper;


import com.example.team6demo.model.model.OrderItem;
import com.example.team6demo.tran.resource.OrderItemResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
interface OrderItemMapper extends BaseMapper<OrderItem, OrderItemResource> {
}