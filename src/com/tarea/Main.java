package com.tarea;

import com.tarea.interfaces.PersonaService;
import com.tarea.interfaces.PersonaServiceClienteImpl;
import com.tarea.interfaces.PersonaServiceEmpleadoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PersonaService service;
        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            Menu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    service = new PersonaServiceEmpleadoImpl();
                    Empleado empleado = (Empleado) service.crearPersona();
                    break;
                case 2:
                    service = new PersonaServiceClienteImpl();
                    Cliente cliente = (Cliente) service.crearPersona();

                    break;
                case 3:
                    service = new PersonaServiceEmpleadoImpl();
                    service.mostrarListado();
                    break;
                case 4:
                    service = new PersonaServiceClienteImpl();
                    service.mostrarListado();
                    break;
                case 5:
                    service = new PersonaServiceEmpleadoImpl();
                    service.removerPersona();
                    break;
                case 6:
                    service = new PersonaServiceClienteImpl();
                    service.removerPersona();
                    break;
                case 7:
                    service = new PersonaServiceEmpleadoImpl();
                    service.actualizarPersona();
                    break;
                case 8:
                    service = new PersonaServiceClienteImpl();
                    service.actualizarPersona();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Elige una opción correcta");
            }
        } while (opcion != 9);
    }

    static void Menu() {
        System.out.println("--------Registro de Datos----------");
        System.out.println("-----------------------------------");
        System.out.println("1 - Empleado");
        System.out.println("2 - Cliente");
        System.out.println("3 - Lista de Empleados");
        System.out.println("4 - Lista de Clientes");
        System.out.println("5 - Remover Empleado");
        System.out.println("6 - Remover Cliente");
        System.out.println("7 - Actualizar Empleado");
        System.out.println("8 - Actualizar Cliente");
        System.out.println("9 - Salir");
        System.out.println("Selecciona una opcion:");
    }
}