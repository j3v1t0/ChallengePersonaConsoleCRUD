package com.tarea;

public class Cliente extends Persona{

    private long idCliente;
    private int referencia;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(int personaId, String entidad, String nombre, String apellido, long idCliente, int referencia, boolean activo) {
        super(personaId,entidad,nombre,apellido);
        this.idCliente = idCliente;
        this.referencia = referencia;
        this.activo = activo;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", referencia=").append(referencia);
        sb.append(", activo=").append(activo);
        sb.append(", personaId=").append(personaId);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
