package com.example.team6demo.services;

import com.example.team6demo.model.Store;
import com.example.team6demo.repository.BaseRepository;
import com.example.team6demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreCategoryService storeCategoryService;

    @Override
    protected BaseRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    @Override
    public Store findById(final String id) {
        return storeRepository.findById(id);
    }


}
