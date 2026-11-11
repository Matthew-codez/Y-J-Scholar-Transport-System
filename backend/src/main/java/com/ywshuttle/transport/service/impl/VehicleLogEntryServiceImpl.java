package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.VehicleLogEntry;
import com.ywshuttle.transport.repository.VehicleLogEntryRepository;
import com.ywshuttle.transport.service.VehicleLogEntryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleLogEntryServiceImpl implements VehicleLogEntryService {
    private final VehicleLogEntryRepository repository;

    public VehicleLogEntryServiceImpl(VehicleLogEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleLogEntry createVehicleLogEntry(VehicleLogEntry entity) {
        return repository.save(entity);
    }

    @Override
    public List<VehicleLogEntry> getAllVehicleLogEntrys() {
        return repository.findAll();
    }

    @Override
    public Optional<VehicleLogEntry> getVehicleLogEntryById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public VehicleLogEntry updateVehicleLogEntry(Integer id, VehicleLogEntry entityDetails) {
        VehicleLogEntry entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehicleLogEntry not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteVehicleLogEntry(Integer id) {
        VehicleLogEntry entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehicleLogEntry not found with id: " + id));
        repository.delete(entity);
    }
}
