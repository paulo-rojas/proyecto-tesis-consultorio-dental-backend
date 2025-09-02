package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.mapper.PacienteMapper;
import com.proyecto.consultorio_dental_backend.repository.DireccionRepository;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{


    private final PacienteRepository pacienteRepository;
    private final DistritoRepository distritoRepository;
    private final DireccionRepository direccionRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, DistritoRepository distritoRepository, DireccionRepository direccionRepository) {
        this.pacienteRepository = pacienteRepository;
        this.distritoRepository = distritoRepository;
        this.direccionRepository = direccionRepository;
    }

    @Override
    public Optional<PacienteDTO> findByDni(String dni) {
        return pacienteRepository.findByDni(dni).map(PacienteMapper::toDTO);
    }

    @Override
    public Optional<PacienteDTO> findById(Integer id) {
        return pacienteRepository.findById(id).map(PacienteMapper::toDTO);
    }

    @Override
    public List<PacienteDTO> findAll(){
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    public void save(PacienteDTO paciente) {
        pacienteRepository.save(PacienteMapper.toEntity(paciente));
    }

    @Override
    public boolean existsById(Integer id) {
        return pacienteRepository.existsById(id);
    }

    @Override
    public ResponseEntity<?> saveDireccion(Integer id, DireccionRequestDTO dto) {

        PacienteEntity paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));


        DistritoEntity distrito = distritoRepository.findById(dto.getDistritoId())
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado"));

        DireccionEntity direccion = new DireccionEntity();

        direccion.setDetalle(dto.getDetalle());
        direccion.setDistrito(distrito);

        DireccionEntity savedDireccion = direccionRepository.save(direccion);

        paciente.setDireccion(savedDireccion);
        pacienteRepository.save(paciente);

        return ResponseEntity.ok().build();
    }

}
