package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoIntegrador {

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
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    registrarUsuario(scanner, nombres, ids, roles, ciudades, contactos, correos, contrasenas);
                    break;
                case "2":
                    iniciarSesion(scanner, nombres, correos, contrasenas, roles);
                    break;
                case "3":
                    mostrarContacto();
                    break;
                case "4":
                    System.out.println(" Que pases un Excelente Día ¡Hasta luego!");
                    break;
                default:
                    System.out.println(" Opción no válida.");
            }

        } while (!opcion.equals("4"));

        scanner.close();
    }

    // Menu Principal de registro

    public static void mostrarMenu() {
        System.out.println("\n ** BIENVENID@S AL PROGRESO Y GESTIÓN PARA EL DESARROLLO LOCAL **");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Contáctenos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Registro de usuario

    public static void registrarUsuario(Scanner scanner,
            ArrayList<String> nombres, ArrayList<String> ids, ArrayList<String> roles,
            ArrayList<String> ciudades, ArrayList<String> contactos,
            ArrayList<String> correos, ArrayList<String> contrasenas) {

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        // Validar ID como número
        String id = "";
        boolean idValido = false;
        while (!idValido) {
            System.out.print("Número de identificación: ");
            id = scanner.nextLine();
            try {
                Integer.parseInt(id);
                idValido = true;
            } catch (NumberFormatException e) {
                System.out.println("El ID debe ser numérico.");
            }
        }

        String rol = "";
        while (!rol.equalsIgnoreCase("estudiante") && !rol.equalsIgnoreCase("profesor")) {
            System.out.print("Rol (Estudiante o Profesor): ");
            rol = scanner.nextLine();
        }

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        // Validar número de contacto como numérico

        String contacto = "";
        boolean contactoValido = false;
        while (!contactoValido) {
            System.out.print("Número de contacto: ");
            contacto = scanner.nextLine();
            try {
                Long.parseLong(contacto);
                contactoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("El número de contacto debe ser válido.");
            }
        }

        // Validar correo

        String correo = "";
        boolean correoValido = false;
        while (!correoValido) {
            System.out.print("Correo electrónico: ");
            correo = scanner.nextLine();
            if (correo.contains("@") && correo.indexOf("@") > 0 &&
                    correo.lastIndexOf(".") > correo.indexOf("@")) {
                correoValido = true;
            } else {
                System.out.println("El correo debe contener '@' y un dominio válido.");
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

        System.out.println(" Registro exitoso.");
    }

    // iniciar sesion

    public static void iniciarSesion(Scanner scanner,
            ArrayList<String> nombres, ArrayList<String> correos,
            ArrayList<String> contrasenas, ArrayList<String> roles) {

        System.out.print("Correo electrónico: ");
        String correoLogin = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasenaLogin = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < correos.size(); i++) {
            if (correos.get(i).equalsIgnoreCase(correoLogin) &&
                    contrasenas.get(i).equals(contrasenaLogin)) {

                System.out.println("Bienvenid@ " + roles.get(i) + " " + nombres.get(i) + "!");
                String rol = roles.get(i).toLowerCase();

                if (rol.equals("estudiante")) {
                    menuEstudiante(scanner);
                } else if (rol.equals("profesor")) {
                    menuProfesor(scanner);
                }

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(" Correo o contraseña incorrectos.");
        }
    }

    // Menu del estudiante

    public static void menuEstudiante(Scanner scanner) {
        String opcion;
        do {
            System.out.println("\n** Menú Estudiante **");
            System.out.println("1. Solicitar subsidio de estudio");
            System.out.println("2. Clases virtuales");
            System.out.println("3. Biblioteca virtual");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {

                // ingreso del valor del curso y menú de nivel economico
                case "1": {
                    System.out.println("\nIngrese el valor del curso que desea en COP:  ");

                    double precioOriginal = 0;

                    // try-catch sirve para manejar errores, evitar que se rompa el ciclo y muestre
                    // un mensaje.
                    try {
                        precioOriginal = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Ingresar número valido.");
                        break;
                    }

                    System.out.println("\nSeleccione su nivel económico: ");
                    System.out.println("1. vulnerable. ");
                    System.out.println("2. pobreza moderada. ");
                    System.out.println("3. Pobreza extrema. ");
                    System.out.println("Ingrese una opción (1-3): ");
                    String nivel = scanner.nextLine();

                    double subsidio = 0.0;
                    String descripcion = "";

                    // switch anidado de calculo para subsidio
                    switch (nivel) {
                        case "1":
                            subsidio = 0.50;
                            descripcion = "Vulnerable";
                            break;
                        case "2":
                            subsidio = 0.80;
                            descripcion = "Pobreza moderada";
                            break;
                        case "3":
                            subsidio = 1.00;
                            descripcion = "Pobreza extrema";
                            break;
                        default:
                            System.out.println("Opción no valida.");
                            continue;
                    }

                    double montoSubsidio = precioOriginal * subsidio;
                    double montoPagar = precioOriginal - montoSubsidio;

                    System.out.println("\nDetalles de Subsidio Estudiantil:  ");
                    System.out.println("Nivel económico: " + descripcion);
                    System.out.println("Subsidio aplicado: " + (int) (subsidio * 100) + "%");
                    System.out.println("Monto del curso: $" + String.format("%,.0f", precioOriginal));
                    System.out.println("Valor del subsidio: $" + String.format("%,.0f", montoSubsidio));
                    System.out.println("Monto que debes pagar: $" + String.format("%,.0f", montoPagar));
                    System.out.println("Tu solicitud ha sido registrada.");
                    break;
                }

                case "2":
                    System.out.println("Accediendo a la plataforma de clases virtuales...");
                    break;
                case "3":
                    System.out.println("Accediendo a la biblioteca virtual...");
                    break;
                case "4":
                    System.out.println("Feliz Día ¡Hasta Luego!.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("4"));
    }

    // Menu del profesor

    public static void menuProfesor(Scanner scanner) {
        String opcion;
        do {
            System.out.println("\n** Menú Profesor **");
            System.out.println("1. Clases virtuales");
            System.out.println("2. Biblioteca virtual");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Accediendo a la plataforma de clases virtuales...");
                    break;
                case "2":
                    System.out.println("Accediendo a la biblioteca virtual...");
                    break;
                case "3":
                    System.out.println("Feliz Día ¡Hasta Luego!.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("3"));
    }

    public static void mostrarContacto() {
        System.out.println("Contáctenos");
        System.out.println("Correo: soporte@example.com");
        System.out.println("Teléfono: +57 300 000 0000");
        System.out.println("Dirección: Calle Ficticia #123, Ciudad Imaginaria");
    }

}