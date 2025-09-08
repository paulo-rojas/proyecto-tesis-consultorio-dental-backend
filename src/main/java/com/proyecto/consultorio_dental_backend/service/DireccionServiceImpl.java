package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.entity.PersonaEntity;
import com.proyecto.consultorio_dental_backend.exception.DireccionNoEncontradaException;
import com.proyecto.consultorio_dental_backend.exception.DistritoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNotFoundException; // Asumiendo que esta excepción es creada
import com.proyecto.consultorio_dental_backend.exception.PersonaYaCuentaConDireccionException; // Asumiendo que esta excepción es creada
import com.proyecto.consultorio_dental_backend.mapper.DireccionMapper;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import com.proyecto.consultorio_dental_backend.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final PersonaRepository personaRepository;
    private final DistritoRepository distritoRepository;

    public DireccionServiceImpl(PersonaRepository personaRepository, DistritoRepository distritoRepository) {
        this.personaRepository = personaRepository;
        this.distritoRepository = distritoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DireccionResponseDTO findDireccionByPersonaId(Integer personaId) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        return Optional.ofNullable(persona.getDireccion())
                .map(DireccionMapper::toDTO)
                .orElseThrow(() -> new DireccionNoEncontradaException("Persona", personaId));
    }

    @Override
    @Transactional
    public DireccionResponseDTO addDireccionToPersona(Integer personaId, DireccionRequestDTO direccionRequestDTO) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        if (persona.getDireccion() != null) {
            throw new PersonaYaCuentaConDireccionException(personaId);
        }

        DistritoEntity distrito = distritoRepository.findById(direccionRequestDTO.getDistritoId())
                .orElseThrow(() -> new DistritoNoEncontradoException(direccionRequestDTO.getDistritoId()));

        DireccionEntity direccion = DireccionMapper.toEntity(direccionRequestDTO, distrito);
        persona.setDireccion(direccion);

        // Gracias a @Transactional y CascadeType.ALL, JPA guardará la dirección y actualizará la persona.

        return DireccionMapper.toDTO(persona.getDireccion());
    }

    @Override
    @Transactional
    public DireccionResponseDTO updateDireccion(Integer personaId, DireccionRequestDTO dto) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        DireccionEntity direccion = Optional.ofNullable(persona.getDireccion())
                .orElseThrow(() -> new DireccionNoEncontradaException("Persona", personaId));

        DistritoEntity distrito = distritoRepository.findById(dto.getDistritoId())
                .orElseThrow(() -> new DistritoNoEncontradoException(dto.getDistritoId()));

        direccion.setDetalle(dto.getDetalle());
        direccion.setDistrito(distrito);

        // Gracias a @Transactional, JPA detectará los cambios y hará el UPDATE.

        return DireccionMapper.toDTO(direccion);
    }

    @Override
    @Transactional
    public void deleteDireccion(Integer personaId) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        // Gracias a orphanRemoval=true, esto eliminará la DireccionEntity de la base de datos.
        persona.setDireccion(null);
    }
}
