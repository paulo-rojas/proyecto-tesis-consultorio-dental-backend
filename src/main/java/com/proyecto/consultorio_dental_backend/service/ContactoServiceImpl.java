package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.ContactoDTO;
import com.proyecto.consultorio_dental_backend.entity.ContactoEntity;
import com.proyecto.consultorio_dental_backend.entity.PersonaEntity;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoCuentaConContactoException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.mapper.ContactoMapper;
import com.proyecto.consultorio_dental_backend.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    private final PersonaRepository personaRepository;

    public ContactoServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public ContactoDTO findContactoByPersonaId(Integer personaId) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow( () -> new PersonaNoEncontradaException(personaId));

        return Optional.ofNullable(persona.getContacto())
                .map(ContactoMapper::toDTO)
                .orElseThrow( () -> new PersonaNoCuentaConContactoException(personaId));
    }

    @Override
    public ContactoDTO addContactoToPersona(Integer personaId, ContactoDTO contactoDTO) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow( () -> new PersonaNoEncontradaException(personaId));

        ContactoEntity contacto = ContactoMapper.toEntity(contactoDTO);
        persona.setContacto(contacto);
        personaRepository.save(persona);

        return ContactoMapper.toDTO(contacto);
    }

    @Override
    public ContactoDTO updateContacto(Integer personaId, ContactoDTO contactoDTO) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNoEncontradaException(personaId));

        ContactoEntity contactoExistente = Optional.ofNullable(persona.getContacto())
                .orElseThrow(() -> new PersonaNoCuentaConContactoException(personaId));

        contactoExistente.setCorreo(contactoDTO.getCorreo());
        contactoExistente.setTelefono1(contactoDTO.getTelefono1());
        contactoExistente.setTelefono2(contactoDTO.getTelefono2());

        personaRepository.save(persona);
        return ContactoMapper.toDTO(contactoExistente);
    }

    @Override
    public void deleteContacto(Integer personaId) {
        PersonaEntity persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNoEncontradaException(personaId));

        if (persona.getContacto() == null) {
            throw new PersonaNoCuentaConContactoException(personaId);
        }

        persona.setContacto(null);
        personaRepository.save(persona);
    }

}
