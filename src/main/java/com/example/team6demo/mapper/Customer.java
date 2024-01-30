package com.example.team6demo.mapper;




import com.example.team6demo.model.model.Customer;
import com.example.team6demo.tran.resource.CustomerResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
interface CustomerMapper extends BaseMapper<Customer, CustomerResource> {
}
