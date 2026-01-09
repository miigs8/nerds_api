package com.nerds.app.mapper;

import com.nerds.app.dto.EquipmentDTO;
import com.nerds.app.model.Equipment;
import com.nerds.app.repository.jpa.EquipmentEntity;

public class EquipmentMapper {
    private EquipmentMapper() {
        throw new IllegalStateException("[ERROR] Cannot instantiate mapper class");
    }

    public static EquipmentEntity toEntity(Equipment equipment) {
        return new EquipmentEntity(
            equipment.getSerialNumber(),
            equipment.getName(),
            equipment.getDescription(),
            equipment.getType(),
            equipment.isBivolt()
        );
    }

    public static EquipmentDTO toDTO(Equipment equipment) {
        return new EquipmentDTO(
            equipment.getSerialNumber(),
            equipment.getName(),
            equipment.getDescription(),
            equipment.getType(),
            equipment.isBivolt()
        );
    }

    public static Equipment toModel(EquipmentEntity entity) {
        return Equipment.builder()
            .serialNumber(entity.getSerialNumber())
            .name(entity.getName())
            .description(entity.getDescription())
            .type(entity.getType())
            .isBivolt(entity.isBivolt())
            .build();
    }

    public static Equipment toModel(EquipmentDTO entity) {
        return Equipment.builder()
            .serialNumber(entity.serialNumber())
            .name(entity.name())
            .description(entity.description())
            .type(entity.type())
            .isBivolt(entity.isBivolt())
            .build();
    }
}
