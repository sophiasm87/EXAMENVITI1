/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

   
/**
 *
 * @author sophi
 */


  
    public class Cliente {

        
    private String nombre;
    private String cedula;
    private String telefono;
    private String categoria;
    private int mesNumero;
    private String mesNombre;

    public Cliente(String nombre, String cedula, String telefono, String categoria, int mesNumero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.categoria = categoria;
        this.mesNumero = mesNumero;
        this.mesNombre = convertirMes(mesNumero);
    }

    private String convertirMes(int mes) {
        return switch (mes) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";
            default -> "Mes inválido";
        };
    }

    public boolean esVIP() {
        return categoria.equals("VIP");
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMesNombre() {
        return mesNombre;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre +
                "\nCédula: " + cedula +
                "\nCategoría: " + categoria +
                "\nMes de registro: " + mesNombre;
    }
}

