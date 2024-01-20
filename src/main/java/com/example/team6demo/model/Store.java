package com.example.team6demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "STORES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
public class Store extends BaseModel {
    @Column(length = 100, nullable = false, unique = true)
    private String brandName;

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private Integer phone;

    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 100, nullable = false)
    private String categoryName;


    public static void setCategory(Object category) {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private Integer id;
    private String brandName;
    private String email;
    private Integer phone;
    private String address;
    private String categoryName;

    public Store(int id, String brandName, String email, int phone, String address, String categoryName) {
        this.id = id;
        this.brandName = brandName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.categoryName = categoryName;


    }
}