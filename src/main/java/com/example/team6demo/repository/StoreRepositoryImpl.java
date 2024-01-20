package com.example.team6demo.repository;

import com.example.team6demo.model.Store;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


    @Repository
    public abstract class StoreRepositoryImpl extends BaseRepositoryImpl<Store> implements StoreRepository {
        private final ConcurrentHashMap<Long, Store> storage = new ConcurrentHashMap<>();
        private final AtomicLong sequence = new AtomicLong(0);

        @Override
        protected ConcurrentHashMap<Long, Store> getStorage() {
            return storage;
        }

        @Override
        protected AtomicLong getSequence() {
            return sequence;
        }

        @Override
        public Store findById(final String id) {
            return storage.values()
                    .stream()
                    .filter(c -> id.equalsIgnoreCase(String.valueOf(c.getId())))
                    .findFirst()
                    .orElse(null);
        }
    }

