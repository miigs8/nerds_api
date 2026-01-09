package com.nerds.app.dto;

import com.nerds.app.enums.PowerSource;

public record EquipmentDTO(
        String serialNumber,
        String name,
        String description,
        PowerSource type,
        boolean isBivolt
) {}