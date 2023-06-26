package com.tarea;

public class Empleado extends Persona{
    private long empleadoId;
    private Double sueldo;
    private boolean activo;

    public Empleado(){

    }

    public Empleado(int personaId, String entidad, String nombre, String apellido, long empleadoId, Double sueldo, boolean activo){
        super(personaId,entidad,nombre,apellido);
        this.empleadoId = empleadoId;
        this.sueldo = sueldo;
        this.activo = activo;
    }
    public long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("empleadoId=").append(empleadoId);
        sb.append(", sueldo=").append(sueldo);
        sb.append(", activo=").append(activo);
        sb.append(", personaId=").append(personaId);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
