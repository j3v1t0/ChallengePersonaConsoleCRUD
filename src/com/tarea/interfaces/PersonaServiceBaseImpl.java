package com.tarea.interfaces;

import com.tarea.Cliente;
import com.tarea.Persona;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonaServiceBaseImpl implements PersonaService{
    protected static List<Persona> personas = new ArrayList<>();

    protected boolean existePersonaId(int personaId) {
        for (Persona persona : personas) {
            if (persona.getPersonaId() == personaId) {
                return true;
            }
        }
        return false;
    }
}
