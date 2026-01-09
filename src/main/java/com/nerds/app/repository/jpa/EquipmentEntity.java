package com.nerds.app.repository.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import com.nerds.app.enums.PowerSource;

@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String serialNumber;
    
    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    private PowerSource type;

    private boolean isBivolt;

    protected EquipmentEntity() {}

    public String getSerialNumber() { return serialNumber; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public PowerSource getType() { return type; }

    public boolean isBivolt() { return isBivolt; }

    public EquipmentEntity(String serialNumber, String name, String description, PowerSource type, boolean isBivolt) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.type = type;
        this.isBivolt = isBivolt;
    }
}
