package com.github.pedroluiznogueira.vehiclecatalogapi.repository;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
}
