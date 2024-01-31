package com.example.team6demo.tran;

import com.example.team6demo.tran.resource.BaseResource;
import org.springframework.http.codec.ServerSentEvent;

public class ApiResponse<R extends BaseResource> {

    public static ServerSentEvent<Object> builder() {
        return null;
    }
}
