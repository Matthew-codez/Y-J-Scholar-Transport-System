package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.ScholarRouteAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarRouteAssignmentRepository extends JpaRepository<ScholarRouteAssignment, Integer> {
}
