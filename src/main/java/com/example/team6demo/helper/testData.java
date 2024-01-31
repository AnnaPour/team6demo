package com.example.team6demo.helper;


import com.example.team6demo.model.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@ToString(callSuper = true)

public class testData {


    ArrayList<Store> list = new ArrayList<>(){};

    Store data = new Store(1,"Souvlakeri", "souvlaki@gmail.com",20,"Athens,12334","Souvlaki");
    Store data1 = new Store(2,"Las Ramblas", "lasramblas@gmail.com",20,"Athens,12334","Coffee");
    Store data2 = new Store(3,"SouvLike", "sounlike@gmail.com",20,"Athens,12334","Souvlaki");
    Store data3 = new Store(4,"Tortigia", "tortigia@gmail.com",20,"Athens,12334","Mexican");
    Store data4 = new Store(5,"HAM_burger", "hamburger@gmail.com",20,"Athens,12334","Burger");
    Store data5 = new Store(6,"La_italiana", "mitaliana@gmail.com",20,"Athens,12334","Pizza");


    public ArrayList<Store> getList() {
        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);

        return list;
    }
}