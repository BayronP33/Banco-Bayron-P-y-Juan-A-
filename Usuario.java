/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

public class Usuario {
    private String nombre;
    private int edad;
    private String tipo; // "Nativo Mayor", "Menor de Edad", "Extranjero"
    private double saldo; // Nuevo atributo para el saldo

    // Constructor
    public Usuario(String nombre, int edad, String tipo, double saldoInicial) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        if (!tipo.equals("Nativo Mayor") && !tipo.equals("Menor de Edad") && !tipo.equals("Extranjero")) {
            throw new IllegalArgumentException("Tipo de usuario inválido.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.saldo = saldoInicial;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    // Métodos setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        if (!tipo.equals("Nativo Mayor") && !tipo.equals("Menor de Edad") && !tipo.equals("Extranjero")) {
            throw new IllegalArgumentException("Tipo de usuario inválido.");
        }
        this.tipo = tipo;
    }

    // Métodos para manejar el saldo
    public void incrementarSaldo(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a incrementar no puede ser negativo.");
        }
        this.saldo += monto;
    }

    public boolean disminuirSaldo(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a disminuir no puede ser negativo.");
        }
        if (monto > saldo) {
            return false; // Fondos insuficientes
        }
        this.saldo -= monto;
        return true;
    }

    public void eliminarUsuario() {
        System.out.println("Usuario eliminado: " + nombre);
    }

    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
