package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.DepartamentoEntity;
import com.proyecto.consultorio_dental_backend.service.DepartamentoService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<DepartamentoEntity>> findAll(){
        List<DepartamentoEntity> departamentos = departamentoService.findAll();

        if (departamentos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        if (CommonUtils.isValidId(id)){
            return ResponseEntity.badRequest().build();
        }

        return departamentoService.findById(id)
                //.map(dep -> ResponseEntity.ok().body(dep))
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }
}
