package com.tarea.interfaces;

import com.tarea.Empleado;
import com.tarea.Persona;

import java.util.Iterator;
import java.util.Scanner;

public class PersonaServiceEmpleadoImpl extends PersonaServiceBaseImpl {
    @Override
    public Empleado crearPersona() {
        Scanner scanner = new Scanner(System.in);
        Empleado empleado = new Empleado();

        try {
            System.out.println("--------Registro del Empleado---------");
            System.out.println("--------------------------------------");
            System.out.println("ID del registro: ");
            int registroId = scanner.nextInt();
            while (existePersonaId(registroId)) {
                System.out.println("El ID de persona ingresado ya existe. Ingrese un ID de persona válido: ");
                registroId = scanner.nextInt();
            }
            empleado.setPersonaId(registroId);
            empleado.setEntidad("Empleado");
            System.out.println("ID del empleado: ");
            long empleadoId = scanner.nextLong();
            while (existeClienteId(empleadoId)) {
                System.out.println("El ID de empleado ingresado ya existe. Ingrese un ID de empleado válido: ");
                empleadoId = scanner.nextLong();
            }
            empleado.setEmpleadoId(empleadoId);
            System.out.println("Nombre: ");
            String nombreEmpleado = scanner.next();
            empleado.setNombre(nombreEmpleado);
            System.out.println("Apellido: ");
            String apellidoEmpleado = scanner.next();
            empleado.setApellido(apellidoEmpleado);
            System.out.println("Sueldo: ");
            Double sueldo = scanner.nextDouble();
            empleado.setSueldo(sueldo);

            System.out.println("Activo (true/false): ");
            boolean activo = scanner.nextBoolean();
            empleado.setActivo(activo);

            System.out.println(empleado);
            personas.add(empleado);

        } catch (Exception e) {
            System.out.println("Error en el tipo de datos: " + e.getMessage());
        }
        return empleado;
    }

    @Override
    public void mostrarListado() {
        System.out.println("Listado de Empleados: ");
        if (personas.isEmpty()) {
            System.out.println("La lista de empleados está vacía.");
        } else {
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if (persona instanceof Empleado) {
                    System.out.println((i + 1) + " - " + persona);
                }
            }
        }
    }

    @Override
    public Object removerPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el empleado a remover");
        int objetoId = scanner.nextInt();
        int removerEmpleado = objetoId - 1;
        try {
            Iterator<Persona> iterator = personas.iterator();
            while (iterator.hasNext()) {
                Persona persona = iterator.next();
                if (persona instanceof Empleado && ((Empleado) persona).getEmpleadoId() == objetoId) {
                    iterator.remove();
                    System.out.println("Empleado removido.");
                    return personas;
                }
            }
            System.out.println("No se encontró ningún empleado con el ID especificado.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La lista de empleados está vacía. No se puede remover ningún empleado.");
        }

        return personas;
    }

    @Override
    public void actualizarPersona() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite el ID del empleado a actualizar: ");
            int empleadoId = scanner.nextInt();

            boolean empleadoEncontrado = false;

            for (Persona persona : personas) {
                if (persona instanceof Empleado && ((Empleado) persona).getEmpleadoId() == empleadoId) {
                    Empleado empleado = (Empleado) persona;

                    System.out.println("Seleccione el campo que desea actualizar: ");
                    System.out.println("1 - Nombre");
                    System.out.println("2 - Apellido");
                    System.out.println("3 - Sueldo");
                    System.out.println("4 - Activo");

                    int opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombre = scanner.next();
                            empleado.setNombre(nuevoNombre);
                            System.out.println("Nombre actualizado correctamente.");
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo apellido: ");
                            String nuevoApellido = scanner.next();
                            empleado.setApellido(nuevoApellido);
                            System.out.println("Apellido actualizado correctamente.");
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo sueldo: ");
                            double nuevoSueldo = scanner.nextDouble();
                            empleado.setSueldo(nuevoSueldo);
                            System.out.println("Sueldo actualizado correctamente.");
                            break;
                        case 4:
                            System.out.println("Ingrese el nuevo estado de activo (true/false): ");
                            boolean nuevoActivo = scanner.nextBoolean();
                            empleado.setActivo(nuevoActivo);
                            System.out.println("Estado de activo actualizado correctamente.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }

                    empleadoEncontrado = true;
                    break;
                }
            }

            if (!empleadoEncontrado) {
                System.out.println("No se encontró ningún empleado con el ID especificado.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Se esperaba un valor numérico.");
        }
    }


    private boolean existeClienteId(long clienteId) {
        for (Persona persona : personas) {
            if (persona instanceof Empleado && ((Empleado) persona).getEmpleadoId() == clienteId) {
                return true;
            }
        }
        return false;
    }
}
