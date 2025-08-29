package com.proyecto.consultorio_dental_backend.controller;


import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/direccion")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        if (!CommonUtils.isValidId(id)){
            return ResponseEntity.badRequest()
                    .body(CommonUtils.errorMessageMap(String.format("No existe direccion con el id %s", id)));
        }

        Optional<DireccionResponseDTO> direccionDTO = direccionService.findById(id);

        if (direccionDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(direccionDTO.get());

    }

    @PatchMapping("/")
    public ResponseEntity<?> updateDireccion(@RequestBody DireccionRequestDTO dto){

        if (dto == null){
            return ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("No se envió ninguna dirección"));
        }

        if (dto.getId() == null) {
            return ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("El campo id está vacío"));
        }

        if (dto.getDetalle() == null || dto.getDetalle().isEmpty()) {
            return ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("El campo detalle está vacío"));
        }

        if (dto.getDistritoId() == null) {
            return ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("El campo distritoId está vacío"));
        }

        return direccionService.update(dto)
                ? ResponseEntity.ok().body(Map.of("Éxito", "Recurso actualizado correctamente"))
                : ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("Error al actualizar"));

    }
}
