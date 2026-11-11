package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.DriverRouteAssignment;

import java.util.List;
import java.util.Optional;

public interface DriverRouteAssignmentService {
    DriverRouteAssignment createDriverRouteAssignment( DriverRouteAssignment entity );

    List<DriverRouteAssignment> getAllDriverRouteAssignments();

    Optional<DriverRouteAssignment> getDriverRouteAssignmentById(Integer id);

    DriverRouteAssignment updateDriverRouteAssignment(Integer id, DriverRouteAssignment entityDetails);

    void deleteDriverRouteAssignment(Integer id);
}
