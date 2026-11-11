package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Route;
import com.ywshuttle.transport.repository.RouteRepository;
import com.ywshuttle.transport.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository repository;

    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Route createRoute(Route entity) {
        return repository.save(entity);
    }

    @Override
    public List<Route> getAllRoutes() {
        return repository.findAll();
    }

    @Override
    public Optional<Route> getRouteById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Route updateRoute(Integer id, Route entityDetails) {
        Route entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteRoute(Integer id) {
        Route entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
        repository.delete(entity);
    }

    @Override
    public List<Route> searchRoutesByPickupArea(String pickupArea) {
        return repository.findByPickupAreaContainingIgnoreCase(pickupArea);
    }
}
