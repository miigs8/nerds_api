package com.nerds.app.repository;

import java.util.List;
import java.util.Optional;

import com.nerds.app.model.Equipment;

public interface EquipmentRepository {
    Equipment save(Equipment equipment);
    Optional<Equipment> findBySerialNumber(String serialNumber);
    List<Equipment> findAll();
    boolean existsBySerialNumber(String serialNumber);
    void deleteBySerialNumber(String serialNumber);
}