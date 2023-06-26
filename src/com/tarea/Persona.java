package com.tarea;

public class Persona {
    int personaId;
    String entidad;
    String nombre;
    String apellido;

    public Persona(){

    }
    public Persona(int personaId, String entidad, String nombre, String apellido){
        this.personaId =personaId;
        this.entidad = entidad;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("personaId=").append(personaId);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
