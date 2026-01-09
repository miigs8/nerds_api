package com.nerds.app.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEquipmentRepository extends JpaRepository<EquipmentEntity, String> {
    Optional<EquipmentEntity> findBySerialNumber(String serialNumber);
    List<EquipmentEntity> findAll();
    void deleteBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
}