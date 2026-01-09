package com.nerds.app.exception;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(String serialNumber) {
        super("[ERROR] Entity with serial number " + serialNumber + " not found.");
    }
}
