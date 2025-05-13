package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas para guardar los datos de los usuarios
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> roles = new ArrayList<>();
        ArrayList<String> ciudades = new ArrayList<>();
        ArrayList<String> contactos = new ArrayList<>();
        ArrayList<String> correos = new ArrayList<>();
        ArrayList<String> contrasenas = new ArrayList<>();

        String opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Contáctenos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    // Registro
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

                    // Validar correo
                    String correo = "";
                    boolean correoValido = false;
                    while (!correoValido) {
                        System.out.print("Correo electrónico: ");
                        correo = scanner.nextLine();
                        if (correo.contains("@") && correo.indexOf('@') > 0 && correo.indexOf('@') < correo.length() - 1) {
                            correoValido = true;
                        } else {
                            System.out.println("⚠️ El correo debe contener '@' y texto antes y después de él.");
                        }
                    }

                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();

                    // Guardar datos
                    nombres.add(nombre);
                    ids.add(id);
                    roles.add(rol);
                    ciudades.add(ciudad);
                    contactos.add(contacto);
                    correos.add(correo);
                    contrasenas.add(contrasena);

                    System.out.println("✅ Registro exitoso.");
                    break;

                case "2":
                    // Inicio de sesión
                    System.out.print("Correo electrónico: ");
                    String correoLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < correos.size(); i++) {
                        if (correos.get(i).equalsIgnoreCase(correoLogin) &&
                            contrasenas.get(i).equals(contrasenaLogin)) {
                            System.out.println("✅ Bienvenido/a, " + nombres.get(i) + "!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("❌ Correo o contraseña incorrectos.");
                    }
                    break;

                case "3":
                    // Contacto
                    System.out.println("\n📞 Contáctenos");
                    System.out.println("Correo: soporte@example.com");
                    System.out.println("Teléfono: +57 300 000 0000");
                    System.out.println("Dirección: Calle Ficticia #123, Ciudad Imaginaria");
                    break;

                case "4":
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }

        } while (!opcion.equals("4"));

        scanner.close();
    }
}
