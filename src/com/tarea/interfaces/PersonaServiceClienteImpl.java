package com.tarea.interfaces;

import com.tarea.Cliente;
import com.tarea.Empleado;
import com.tarea.Persona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PersonaServiceClienteImpl extends PersonaServiceBaseImpl {
    @Override
    public Cliente crearPersona() {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        try {
            System.out.println("--------Registro del Clientes---------");
            System.out.println("--------------------------------------");
            System.out.println("ID del registro: ");
            int registroId = scanner.nextInt();
            while (existePersonaId(registroId)) {
                System.out.println("El ID de persona ingresado ya existe. Ingrese un ID de persona válido: ");
                registroId = scanner.nextInt();
            }
            cliente.setPersonaId(registroId);
            cliente.setEntidad("Cliente");
            System.out.println("ID del cliente: ");
            long clienteId = scanner.nextLong();
            while (existeClienteId(clienteId)) {
                System.out.println("El ID de cliente ingresado ya existe. Ingrese un ID de cliente válido: ");
                clienteId = scanner.nextLong();
            }
            cliente.setIdCliente(clienteId);
            System.out.println("Nombre: ");
            String nombreCliente = scanner.next();
            cliente.setNombre(nombreCliente);
            System.out.println("Apellido: ");
            String apellidoCliente = scanner.next();
            cliente.setApellido(apellidoCliente);
            System.out.println("Numero de Socio: ");
            int referencia = scanner.nextInt();
            while (existeRefencia(referencia)) {
                System.out.println("El Numero de socio del cliente ingresado ya existe. Ingrese otro numero de socio válido: ");
                referencia = scanner.nextInt();
            }
            cliente.setReferencia(referencia);
            System.out.println("Activo (true/false): ");
            boolean activo = scanner.nextBoolean();
            cliente.setActivo(activo);
            System.out.println(cliente);
            personas.add(cliente);
        } catch (Exception e) {
            System.out.println("Error en el tipo de datos: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public void mostrarListado() {
        System.out.println("Listado de Clientes: ");
        if (personas.isEmpty()) {
            System.out.println("La lista de clientes está vacía.");
        } else {
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if (persona instanceof Cliente) {
                    System.out.println((i + 1) + " - " + persona);
                }
            }
        }
    }

    @Override
    public Object removerPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el cliente a remover");
        int objetoId = scanner.nextInt();
        int removerCliente = objetoId - 1;
        try {
            Iterator<Persona> iterator = personas.iterator();
            while (iterator.hasNext()) {
                Persona persona = iterator.next();
                if (persona instanceof Cliente && ((Cliente) persona).getIdCliente() == objetoId) {
                    iterator.remove();
                    System.out.println("Cliente removido.");
                    return personas;
                }
            }
            System.out.println("No se encontró ningún cliente con el ID especificado.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La lista de clientes está vacía. No se puede remover ningún cliente.");
        }

        return personas;
    }

    @Override
    public void actualizarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el ID del Cliente a actualizar: ");
        int empleadoId = scanner.nextInt();

        boolean clienteEncontrado = false;

        for (Persona persona : personas) {
            if (persona instanceof Empleado && ((Empleado) persona).getEmpleadoId() == empleadoId) {
                Cliente cliente = (Cliente) persona;

                System.out.println("Seleccione el campo que desea actualizar: ");
                System.out.println("1 - Nombre");
                System.out.println("2 - Apellido");
                System.out.println("3 - Referencia");
                System.out.println("4 - Activo");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Nombre: ");
                        String nuevoNombre = scanner.next();
                        cliente.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado correctamente.");
                        break;
                    case 2:
                        System.out.println("Apellido: ");
                        String nuevoApellido = scanner.next();
                        cliente.setApellido(nuevoApellido);
                        System.out.println("Apellido actualizado correctamente.");
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo sueldo: ");
                        int nuevoReferencia = scanner.nextInt();
                        cliente.setReferencia(nuevoReferencia);
                        System.out.println("Sueldo actualizado correctamente.");
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo estado de activo (true/false): ");
                        boolean nuevoActivo = scanner.nextBoolean();
                        cliente.setActivo(nuevoActivo);
                        System.out.println("Estado de activo actualizado correctamente.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se encontró ningún empleado con el ID especificado.");
        }
    }

    private boolean existeClienteId(long clienteId) {
        for (Persona persona : personas) {
            if (persona instanceof Cliente && ((Cliente) persona).getIdCliente() == clienteId) {
                return true;
            }
        }
        return false;
    }

    private boolean existeRefencia(int referencia) {
        for (Persona persona : personas) {
            if (persona instanceof Cliente && ((Cliente) persona).getReferencia() == referencia) {
                return true;
            }
        }
        return false;
    }
}
