package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.VehiclePermit;
import com.ywshuttle.transport.repository.VehiclePermitRepository;
import com.ywshuttle.transport.service.VehiclePermitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclePermitServiceImpl implements VehiclePermitService {
    private final VehiclePermitRepository repository;

    public VehiclePermitServiceImpl(VehiclePermitRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehiclePermit createVehiclePermit(VehiclePermit entity) {
        return repository.save(entity);
    }

    @Override
    public List<VehiclePermit> getAllVehiclePermits() {
        return repository.findAll();
    }

    @Override
    public Optional<VehiclePermit> getVehiclePermitById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public VehiclePermit updateVehiclePermit(Integer id, VehiclePermit entityDetails) {
        VehiclePermit entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehiclePermit not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteVehiclePermit(Integer id) {
        VehiclePermit entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehiclePermit not found with id: " + id));
        repository.delete(entity);
    }
}
