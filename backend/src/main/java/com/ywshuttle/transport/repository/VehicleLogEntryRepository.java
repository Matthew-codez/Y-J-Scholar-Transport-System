package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.VehicleLogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLogEntryRepository extends JpaRepository<VehicleLogEntry, Integer> {
}
