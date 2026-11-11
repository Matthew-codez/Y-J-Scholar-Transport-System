package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    School createSchool( School entity );

    List<School> getAllSchools();

    Optional<School> getSchoolById(Integer id);

    School updateSchool(Integer id, School entityDetails);

    void deleteSchool(Integer id);
}
