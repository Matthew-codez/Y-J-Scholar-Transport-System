package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.ScholarRouteAssignment;

import java.util.List;
import java.util.Optional;

public interface ScholarRouteAssignmentService {
    ScholarRouteAssignment createScholarRouteAssignment( ScholarRouteAssignment entity );

    List<ScholarRouteAssignment> getAllScholarRouteAssignments();

    Optional<ScholarRouteAssignment> getScholarRouteAssignmentById(Integer id);

    ScholarRouteAssignment updateScholarRouteAssignment(Integer id, ScholarRouteAssignment entityDetails);

    void deleteScholarRouteAssignment(Integer id);
}
