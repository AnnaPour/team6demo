package com.example.team6demo.repository;

import com.example.team6demo.base.BaseComponent;
import com.example.team6demo.model.BaseModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class StoreRepositoryImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
    protected abstract ConcurrentHashMap<Long, T> getStorage();

    protected abstract AtomicLong getSequence();

    @Override
    public T create(final T item) {
        item.setId(getSequence().incrementAndGet());
        getStorage().put(item.getId(), item);
        return item;
    }

    @Override
    public List<T> createAll(final T... items) {
        return createAll(Arrays.asList(items));
    }

    @Override
    public List<T> createAll(final List<T> items) {
        List<T> updateItems = new ArrayList<>();
        items.forEach(i -> {
            i.setId(getSequence().incrementAndGet());
            getStorage().put(i.getId(), i);
            updateItems.add(i);
        });
        return updateItems;
    }
}
