package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Driver;
import com.ywshuttle.transport.repository.DriverRepository;
import com.ywshuttle.transport.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver createDriver(Driver entity) {
        return repository.save(entity);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Driver updateDriver(Integer id, Driver entityDetails) {
        Driver entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteDriver(Integer id) {
        Driver entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        repository.delete(entity);
    }
}
