package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Route;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Route>>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(ApiResponse.success("Routes retrieved successfully", routes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Route>> getRouteById(@PathVariable Integer id) {
        Route route = routeService.getRouteById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Route retrieved successfully", route));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Route>> createRoute(@Valid @RequestBody Route route) {
        Route createdRoute = routeService.createRoute(route);
        return new ResponseEntity<>(ApiResponse.success("Route created successfully", createdRoute), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Route>> updateRoute(@PathVariable Integer id, @Valid @RequestBody Route route) {
        Route updatedRoute = routeService.updateRoute(id, route);
        return ResponseEntity.ok(ApiResponse.success("Route updated successfully", updatedRoute));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRoute(@PathVariable Integer id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok(ApiResponse.success("Route deleted successfully", null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Route>>> searchRoutes(@RequestParam String pickupArea) {
        List<Route> routes = routeService.searchRoutesByPickupArea(pickupArea);
        return ResponseEntity.ok(ApiResponse.success("Routes found successfully", routes));
    }
}
