package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.ContactoDTO;

public interface ContactoService {

    ContactoDTO findContactoByPersonaId(Integer personaId);

    ContactoDTO addContactoToPersona(Integer personaId, ContactoDTO contactoDTO);

    ContactoDTO updateContacto(Integer personaId, ContactoDTO contactoDTO);

    void deleteContacto(Integer personaId);


}
