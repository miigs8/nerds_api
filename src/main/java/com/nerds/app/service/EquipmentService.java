package com.nerds.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nerds.app.model.Equipment;
import com.nerds.app.dto.EquipmentDTO;
import com.nerds.app.exception.EquipmentAlreadyExistsException;
import com.nerds.app.exception.EquipmentNotFoundException;
import com.nerds.app.mapper.EquipmentMapper;
import com.nerds.app.repository.EquipmentRepository;

import jakarta.transaction.Transactional;

@Service
public class EquipmentService {
    private final EquipmentRepository repository;

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = EquipmentMapper.toModel(equipmentDTO);

        if (repository.existsBySerialNumber(equipment.getSerialNumber())) {
            throw new EquipmentAlreadyExistsException(equipment.getSerialNumber());
        }

        Equipment savedEquipment = repository.save(equipment);
        return EquipmentMapper.toDTO(savedEquipment);
    }

    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = repository.findAll();

        List<EquipmentDTO> equipmentDTOs = new ArrayList<EquipmentDTO>();

        for (Equipment equipment : equipments) {
            equipmentDTOs.add(EquipmentMapper.toDTO(equipment));
        }

        return equipmentDTOs;
    }

    public EquipmentDTO getEquipmentBySerialNumber(String serialNumber) {
        Optional<Equipment> equipment = repository.findBySerialNumber(serialNumber);

        if (equipment.isEmpty()) { 
            throw new EquipmentNotFoundException(serialNumber);
        }

        return EquipmentMapper.toDTO(equipment.get());
    }

    @Transactional
    public void deleteEquipment(String serialNumber) {
        if (!repository.existsBySerialNumber(serialNumber)) {
            throw new EquipmentNotFoundException(serialNumber);
        }

        repository.deleteBySerialNumber(serialNumber);
    }

    @Transactional
    public EquipmentDTO updateEquipmentDTO(String serialNumber, EquipmentDTO equipmentDTO) {
        Equipment equipment = EquipmentMapper.toModel(equipmentDTO);

        if (!repository.existsBySerialNumber(serialNumber)) {
            throw new EquipmentNotFoundException(serialNumber);
        }

        if (repository.existsBySerialNumber(equipment.getSerialNumber())
                && !equipment.getSerialNumber().equals(serialNumber)) {
            throw new EquipmentAlreadyExistsException(equipment.getSerialNumber());
        }

        Equipment updatedEquipment = repository.save(equipment);
        return EquipmentMapper.toDTO(updatedEquipment);
    }
}