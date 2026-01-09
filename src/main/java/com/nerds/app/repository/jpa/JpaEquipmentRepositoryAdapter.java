package com.nerds.app.repository.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nerds.app.mapper.EquipmentMapper;
import com.nerds.app.model.Equipment;
import com.nerds.app.repository.EquipmentRepository;

@Repository
public class JpaEquipmentRepositoryAdapter implements EquipmentRepository {
    private final JpaEquipmentRepository jpaRepository;

    public JpaEquipmentRepositoryAdapter(JpaEquipmentRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Equipment save(Equipment equipment) {
        EquipmentEntity entity = EquipmentMapper.toEntity(equipment);
        EquipmentEntity savedEntity = jpaRepository.save(entity);
        return EquipmentMapper.toModel(savedEntity);
    }

    @Override
    public List<Equipment> findAll() {
        List<EquipmentEntity> entities = jpaRepository.findAll();
        
        List<Equipment> equipments = new ArrayList<>();
        for (EquipmentEntity entity : entities) {
            Equipment equipment = EquipmentMapper.toModel(entity);
            equipments.add(equipment);
        }
        
        return equipments;
    }

    @Override
    public Optional<Equipment> findBySerialNumber(String serialNumber) {
        Optional<EquipmentEntity> entity = jpaRepository.findBySerialNumber(serialNumber);
        return entity.map(EquipmentMapper::toModel);
    }

    @Override
    public boolean existsBySerialNumber(String serialNumber) {
        return jpaRepository.existsBySerialNumber(serialNumber);
    }

    @Override
    public void deleteBySerialNumber(String serialNumber) {
        jpaRepository.deleteBySerialNumber(serialNumber);
    }
}
