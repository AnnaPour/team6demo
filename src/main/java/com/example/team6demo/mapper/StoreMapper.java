package com.example.team6demo.mapper;

import com.example.team6demo.model.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = Ignore.class)
public interface StoreMapper extends BaseMapper<Store, StoreResource> {
}
