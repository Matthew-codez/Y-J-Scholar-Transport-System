package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "parent")
    private List<Scholar> scholars = new ArrayList<>();

    protected Parent() {}

    public Parent(String name, String phoneNo, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Integer getParentId() { return parentId; }
    public void setParentId(Integer parentId) { this.parentId = parentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Scholar> getScholars() { return scholars; }
    public void setScholars(List<Scholar> scholars) { this.scholars = scholars; }
}
