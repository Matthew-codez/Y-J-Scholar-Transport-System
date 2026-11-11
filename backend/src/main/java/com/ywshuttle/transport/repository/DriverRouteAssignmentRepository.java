package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.DriverRouteAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRouteAssignmentRepository extends JpaRepository<DriverRouteAssignment, Integer> {
}
