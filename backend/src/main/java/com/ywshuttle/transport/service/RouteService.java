package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    Route createRoute(Route entity);

    List<Route> getAllRoutes();

    Optional<Route> getRouteById(Integer id);

    Route updateRoute(Integer id, Route entityDetails);

    void deleteRoute(Integer id);

    List<Route> searchRoutesByPickupArea(String pickupArea);
}
