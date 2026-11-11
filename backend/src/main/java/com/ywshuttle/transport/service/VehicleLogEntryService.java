package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.VehicleLogEntry;

import java.util.List;
import java.util.Optional;

public interface VehicleLogEntryService {
    VehicleLogEntry createVehicleLogEntry( VehicleLogEntry entity );

    List<VehicleLogEntry> getAllVehicleLogEntrys();

    Optional<VehicleLogEntry> getVehicleLogEntryById(Integer id);

    VehicleLogEntry updateVehicleLogEntry(Integer id, VehicleLogEntry entityDetails);

    void deleteVehicleLogEntry(Integer id);
}
