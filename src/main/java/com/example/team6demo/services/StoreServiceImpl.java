package com.example.team6demo.services;

import com.example.team6demo.model.Store;
import com.example.team6demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
    private final StoreRepository storeRepository;


    @Override
    protected JpaRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    @Override
    public Store findById(final String id) {
        return storeRepository.findById(id);
    }


}
