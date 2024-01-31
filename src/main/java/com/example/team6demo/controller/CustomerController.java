package com.example.team6demo.controller;



import com.example.team6demo.mapper.BaseMapper;
import com.example.team6demo.mapper.CustomerMapper;
import com.example.team6demo.model.Customer;
import com.example.team6demo.services.BaseService;
import com.example.team6demo.services.CustomerService;
import com.example.team6demo.tran.ApiResponse;
import com.example.team6demo.tran.resource.CategoryResource;
import com.example.team6demo.tran.resource.CustomerResource;
import com.fasterxml.classmate.AnnotationOverrides;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController extends BaseController<Customer, CustomerResource> {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    protected BaseService<Customer, Long> getBaseService() {
        return customerService;
    }

    @Override
    protected BaseMapper<Category, CategoryResource> getMapper() {
        return customerMapper;
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<CustomerResource>> findByEmail(@RequestParam String email) {
        AnnotationOverrides ApiResponse;
        return ResponseEntity.ok(ApiResponse.<CustomerResource>builder()
                .data(customerMapper.toResource(customerService.findByEmail(email)))
                .build());
    }
}

