package com.github.pedroluiznogueira.vehiclecatalogapi.service;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.Vehicle;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle register(Vehicle vehicle) {
        Vehicle resp = vehicleRepository.save(vehicle);
        if (resp == null) return null;

        return resp;
    }

    public List<Vehicle> findAll() {
        List<Vehicle> resp = vehicleRepository.findAll();
        if (resp.isEmpty()) return null;

        return resp;
    }

    public Vehicle update(Integer id, Vehicle vehicle) {
        Vehicle resp = vehicleRepository.findById(id).get();
        if (resp == null) return null;

        resp.setName(vehicle.getName());
        resp.setBrand(vehicle.getBrand());
        resp.setModel(vehicle.getModel());
        resp.setImagePath(vehicle.getImagePath());
        resp.setPrice(vehicle.getPrice());

        return vehicleRepository.save(resp);
    }

    public String delete(Integer id) {
        Vehicle resp = vehicleRepository.findById(id).get();
        if (resp == null) return null;

        vehicleRepository.delete(resp);
        return "succesfully deleted vehicle";
    }
}
