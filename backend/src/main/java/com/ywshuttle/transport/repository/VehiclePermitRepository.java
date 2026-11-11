package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.VehiclePermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclePermitRepository extends JpaRepository<VehiclePermit, Integer> {
}
