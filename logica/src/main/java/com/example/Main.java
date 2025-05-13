package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String opcion;

        do {
            // Menú principal
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Contáctenos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            // Opción de registro

            switch (opcion) {
                case "1":

                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Número de identificación: ");
                    String id = scanner.nextLine();

                    String rol = "";
                    while (!rol.equalsIgnoreCase("estudiante") && !rol.equalsIgnoreCase("profesor")) {
                        System.out.print("Rol (Estudiante o Profesor): ");
                        rol = scanner.nextLine();
                    }

                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();

                    System.out.print("Número de contacto: ");
                    String contacto = scanner.nextLine();

                    System.out.print("Correo electrónico: ");
                    String correo = scanner.nextLine();

                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();

                    // Crear un nuevo usuario y añadirlo a la lista
                    usuarios.add(new Usuario(nombre, id, rol, ciudad, contacto, correo, contrasena));
                    System.out.println("Registro completado.");
                    break;

                // Opción de inicio de sesión

                case "2":

                    System.out.print("Correo electrónico: ");
                    String correoLogin = scanner.nextLine();

                    System.out.print("Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();

                    boolean acceso = false;
                    for (Usuario u : usuarios) {
                        if (u.getCorreo().equalsIgnoreCase(correoLogin) &&
                                u.getContrasena().equals(contrasenaLogin)) {
                            System.out.println(" Bienvenid@, " + u.getNombre());
                            acceso = true;
                            break;
                        }
                    }

                    if (!acceso) {
                        System.out.println(" Correo o contraseña incorrectos.");
                    }
                    break;

                // Opción de contacto

                case "3":

                    System.out.println("\n Contáctenos");
                    System.out.println("Correo: soporte@example.com");
                    System.out.println("Teléfono: +57 300 000 0000");
                    System.out.println("Dirección: Calle Ficticia #123, Ciudad Imaginaria");
                    break;

                // Opción para salir

                case "4":

                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    // Si el usuario selecciona una opción no válida
                    System.out.println(" Opción no válida.");
            }

        } while (!opcion.equals("4"));

        scanner.close();
    }
}
