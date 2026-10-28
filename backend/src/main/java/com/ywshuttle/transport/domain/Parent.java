package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parentId;
    private String name, phoneNo, email;

    protected Parent(){}
}
