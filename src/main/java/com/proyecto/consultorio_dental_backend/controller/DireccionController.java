package com.proyecto.consultorio_dental_backend.controller;


import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Optional<DireccionDTO> direccionDTO = direccionService.findById(id);

        if (direccionDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(direccionDTO.get());

    }
}
