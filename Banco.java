/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarios = new ArrayList<>();

    // Constructor
    public Banco() {
        // Inicialización si es necesario
    }

    // Métodos para realizar operaciones bancarias
    public void realizarConsignacion(String nombre, double monto) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        usuario.incrementarSaldo(monto); // Aumenta el saldo
        System.out.println("Consignación de " + monto + " realizada. Nuevo saldo: " + usuario.getSaldo());
    }

    public void realizarRetiro(String nombre, double monto) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (!usuario.disminuirSaldo(monto)) {
            System.out.println("Fondos insuficientes. Saldo actual: " + usuario.getSaldo());
            return;
        }
        System.out.println("Retiro de " + monto + " realizado. Nuevo saldo: " + usuario.getSaldo());
    }


    public void transferirFondos(String origen, String destino, double monto) {
        Usuario usuarioOrigen = buscarUsuarioPorNombre(origen);
        Usuario usuarioDestino = buscarUsuarioPorNombre(destino);

        if (usuarioOrigen == null || usuarioDestino == null) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }

        if (!usuarioOrigen.disminuirSaldo(monto)) {
            System.out.println("Fondos insuficientes para realizar la transferencia.");
            return;
        }

        usuarioDestino.incrementarSaldo(monto);
        System.out.println("Transferencia de " + monto + " realizada de " + origen + " a " + destino + ".");
        System.out.println("Nuevo saldo de " + origen + ": " + usuarioOrigen.getSaldo());
        System.out.println("Nuevo saldo de " + destino + ": " + usuarioDestino.getSaldo());
    }

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado: " + usuario.getNombre());
    }

    public void eliminarUsuario(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + nombre);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void deltip(String tipo) {
        System.out.println("Eliminando usuarios del tipo: " + tipo);
        usuarios.removeIf(usuario -> usuario.getTipo().equalsIgnoreCase(tipo));
    }

    public void listuusa() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println("Lista de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void buscarident(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método auxiliar para buscar usuario por nombre
    private Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }
}