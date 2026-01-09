package com.nerds.app.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nerds.app.dto.EquipmentDTO;
import com.nerds.app.service.EquipmentService;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public ResponseEntity<EquipmentDTO> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        EquipmentDTO created = equipmentService.createEquipment(equipmentDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", "/equipments/" + created.serialNumber())
                .body(created);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<EquipmentDTO> getEquipmentBySerialNumber(@PathVariable String serialNumber) {
        EquipmentDTO equipment = equipmentService.getEquipmentBySerialNumber(serialNumber);
        return ResponseEntity.ok(equipment);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EquipmentDTO>> getAllEquipments() {
        List<EquipmentDTO> equipments = equipmentService.getAllEquipments();
        return ResponseEntity.ok(equipments);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<EquipmentDTO> updateEquipment(
            @PathVariable String serialNumber, 
            @RequestBody EquipmentDTO equipmentDTO) {

        EquipmentDTO updated = equipmentService.updateEquipmentDTO(serialNumber, equipmentDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable String serialNumber) {
        equipmentService.deleteEquipment(serialNumber);
        return ResponseEntity.noContent().build();
    }
}