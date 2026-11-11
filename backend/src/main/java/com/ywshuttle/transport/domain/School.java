package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Integer schoolId;

    @Column(nullable = false)
    private String name;

    @Column(name = "school_location")
    private String schoolLocation;

    @OneToMany(mappedBy = "school")
    private List<Scholar> scholars = new ArrayList<>();

    protected School() {}

    public School(String name, String schoolLocation) {
        this.name = name;
        this.schoolLocation = schoolLocation;
    }

    public Integer getSchoolId() { return schoolId; }
    public void setSchoolId(Integer schoolId) { this.schoolId = schoolId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSchoolLocation() { return schoolLocation; }
    public void setSchoolLocation(String schoolLocation) { this.schoolLocation = schoolLocation; }
    public List<Scholar> getScholars() { return scholars; }
    public void setScholars(List<Scholar> scholars) { this.scholars = scholars; }
}
