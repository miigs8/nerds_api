package com.nerds.app.exception;

public class EquipmentAlreadyExistsException extends RuntimeException {
    public EquipmentAlreadyExistsException(String serialNumber) {
        super("[ERROR] Entity with serial number " + serialNumber + " already exists.");
    }
}
