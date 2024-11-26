/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Banco banco;

    // Constructor
    public Menu(Banco banco) {
        this.banco = banco;
    }

    // Mostrar el menú principal
    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Operaciones Bancarias");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Eliminar Usuario o Tipo de Cuenta");
            System.out.println("4. Administrador");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuOperacionesBancarias();
                    break;
                case 2:
                    menuCrearUsuario();
                    break;
                case 3:
                    menuEliminarUsuario();
                    break;
                case 4:
                    menuAdministrador();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    // Submenú de operaciones bancarias
    private void menuOperacionesBancarias() {
        System.out.println("\nOperaciones Bancarias:");
        System.out.println("1. Realizar consignacion");
        System.out.println("2. Realizar retiro");
        System.out.println("3. Transferir fondos");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el nombre del usuario: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el monto a consignar: ");
                double montoConsignacion = scanner.nextDouble();
                banco.realizarConsignacion(nombre, montoConsignacion);
                break;
            case 2:
                System.out.print("Ingrese el monto a retirar: ");
                double montoRetiro = scanner.nextDouble();
                banco.realizarRetiro(nombre, montoRetiro);
                break;
            case 3:
                System.out.print("Ingrese el nombre del destinatario: ");
                String destinatario = scanner.next();
                System.out.print("Ingrese el monto a transferir: ");
                double montoTransferencia = scanner.nextDouble();
                banco.transferirFondos(nombre, destinatario, montoTransferencia);
                break;
            default:
                System.out.println("Opcion invalida.");
                break;
        }
    }

    // Submenú para crear un usuario
    private void menuCrearUsuario() {
        System.out.println("\nCrear Usuario:");
        System.out.print("Ingrese el nombre: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        System.out.println("Seleccione el tipo de identificacion:");
        System.out.println("1. C.C");
        System.out.println("2. T.I");
        System.out.println("3. C.E");
        System.out.print("Seleccione una opcion: ");
        int tipoOpcion = scanner.nextInt();

        String tipo;
        switch (tipoOpcion) {
            case 1:
                tipo = "Nativo Mayor";
                break;
            case 2:
                tipo = "Menor de Edad";
                break;
            case 3:
                tipo = "Extranjero";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Usuario nuevoUsuario = new Usuario(nombre, edad, tipo, saldoInicial);
        banco.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario creado exitosamente.");
    }

    // Submenú para eliminar un usuario o tipo de cuenta
    private void menuEliminarUsuario() {
        System.out.println("\nEliminar Usuario o Tipo de Cuenta:");
        System.out.println("1. Eliminar usuario");
        System.out.println("2. Eliminar tipo de cuenta");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del usuario a eliminar: ");
                String nombre = scanner.next();
                banco.eliminarUsuario(nombre);
                break;
            case 2:
                System.out.print("Ingrese el tipo de cuenta a eliminar: ");
                String tipo = scanner.next();
                banco.deltip(tipo);
                break;
            default:
                System.out.println("Opción invalida.");
                break;
        }
    }

    // Submenú de administración
    private void menuAdministrador() {
        System.out.print("Ingrese el nombre del administrador: ");
        scanner.nextLine(); // Limpiar buffer
        String nombreAdministrador = scanner.nextLine();

        if (!nombreAdministrador.equalsIgnoreCase("STEVE")) {
            System.out.println("Cuenta no registrada como Administrador.");
            return; // Salir del método
        }
        System.out.println("\nAdministrador:");
        System.out.println("1. Listar usuarios");
        System.out.println("2. Buscar usuario por nombre");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
                case 1:
                    banco.listuusa();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    scanner.nextLine(); // Limpiar buffer
                    String nombre = scanner.nextLine();
                    banco.buscarident(nombre);
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
        }
    }
}