package com.nerds.app.model;

import com.nerds.app.enums.PowerSource;
import com.nerds.app.util.StringValidator;

public class Equipment {
    private final String serialNumber;
    private final String name;
    private final String description;
    private final PowerSource type;
    private final boolean isBivolt;

    private Equipment(Builder builder) {
        this.serialNumber = builder.serialNumber;
        this.name = builder.name;
        this.description = builder.description;
        this.type = builder.type;
        this.isBivolt = builder.isBivolt;
    }

    public String getSerialNumber() { return serialNumber; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public PowerSource getType() { return type; }

    public boolean isBivolt() { return isBivolt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String serialNumber;
        private String name;
        private String description;
        private PowerSource type;
        private boolean isBivolt;

        public Builder serialNumber(String serialNumber) {
            if (!StringValidator.isAlphanumeric(serialNumber)) {
                throw new IllegalArgumentException("[ERROR] Serial number is invalid");
            }

            this.serialNumber = serialNumber;
            return this;
        }

        public Builder name(String name) {
            if (!StringValidator.isAlphabetic(name)) {
                throw new IllegalArgumentException("[ERROR] Name is invalid");
            }

            this.name = name;
            return this;
        }

        public Builder description(String description) {
            if (StringValidator.isBlank(description)) {
                throw new IllegalArgumentException("[ERROR] Description is invalid");
            }

            this.description = description;
            return this;
        }

        public Builder type(PowerSource type) {
            this.type = type;
            return this;
        }

        public Builder isBivolt(boolean isBivolt) {
            if (type != PowerSource.ELECTRIC) {
                throw new IllegalArgumentException("[ERROR] Only electric equipment can be bivolt");
            }

            this.isBivolt = isBivolt;
            return this;
        }
        
        public Equipment build() {
            return new Equipment(this);
        }
    }
}