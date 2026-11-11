package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findByPickupAreaContainingIgnoreCase(String pickupArea);
}
