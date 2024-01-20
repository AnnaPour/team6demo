package com.example.team6demo.tran.resource;

public record ApiError(Integer status, String message, String path) {
}
