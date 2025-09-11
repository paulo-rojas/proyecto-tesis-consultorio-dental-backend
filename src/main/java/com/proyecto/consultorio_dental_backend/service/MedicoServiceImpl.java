package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.MedicoRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseSimpleDTO;
import com.proyecto.consultorio_dental_backend.entity.MedicoEntity;
import com.proyecto.consultorio_dental_backend.exception.DniInvalidoException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.mapper.MedicoMapper;
import com.proyecto.consultorio_dental_backend.repository.MedicoRepository;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService{

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoResponseSimpleDTO findResponseSimpleById(Integer id) {
        return medicoRepository.findById(id)
                .map(MedicoMapper::toSimpleDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(id));
    }

    @Override
    public MedicoResponseGeneralDTO findResponseGeneralById(Integer id) {
        return medicoRepository.findById(id)
                .map(MedicoMapper::toGeneralDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(id));
    }

    @Override
    public MedicoResponseSimpleDTO findByDni(String dni) {

        if (!CommonUtils.isValidDni(dni)){
            throw new DniInvalidoException(dni);
        }

        return medicoRepository.findByDni(dni)
                .map(MedicoMapper::toSimpleDTO)
                .orElseThrow();
    }

    @Override
    public List<MedicoResponseSimpleDTO> findByNombreCompletoLike(String nombreCompleto) {
        return medicoRepository.findByNombreCompletoLike("%"+nombreCompleto+"%")
                .stream()
                .map(MedicoMapper::toSimpleDTO)
                .toList();
    }

    @Override
    public List<MedicoResponseSimpleDTO> findByEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidad("%"+especialidad+"%")
                .stream()
                .map(MedicoMapper::toSimpleDTO)
                .toList();
    }

    @Override
    public List<MedicoResponseSimpleDTO> findAll() {
        return  medicoRepository.findAll()
                .stream()
                .map(MedicoMapper::toSimpleDTO)
                .toList();
    }

    @Override
    @Transactional
    public MedicoResponseSimpleDTO save(MedicoRequestDTO medico) {
        if (medicoRepository.existsByDni(medico.getDni())){
            throw new RuntimeException("Médico ya tiene una cuenta registrada");
        }

        MedicoEntity medicoEntity = MedicoMapper.toEntity(medico);
        medicoRepository.save(medicoEntity);
        return MedicoMapper.toSimpleDTO(medicoEntity);

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void updateEspecialidad(Integer medicoId, String especialidad) {

    }

    @Override
    public void updateCodigoColegiatura(Integer medicoId, String codigoColegiatura) {

    }
}
