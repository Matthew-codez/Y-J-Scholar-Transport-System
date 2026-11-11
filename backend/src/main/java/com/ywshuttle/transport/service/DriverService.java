package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    Driver createDriver( Driver entity );

    List<Driver> getAllDrivers();

    Optional<Driver> getDriverById(Integer id);

    Driver updateDriver(Integer id, Driver entityDetails);

    void deleteDriver(Integer id);
}
