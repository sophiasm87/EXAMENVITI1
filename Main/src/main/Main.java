/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


/**
 *
 * @author sophi
 */
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
           // datos del cliente 

        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Cédula:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        String categoria = JOptionPane.showInputDialog("Categoría (VIP o Regular):");

          // numero del mes 
          
        int mes = 0;
        boolean mesValido = false;

        while (mesValido == false) {
            mes = Integer.parseInt(JOptionPane.showInputDialog("Número de mes (1-12):"));

            if (mes >= 1) {
                if (mes <= 12) {
                    mesValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Mes inválido. Debe ser del 1 al 12.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mes inválido. Debe ser del 1 al 12.");
            }
        }

        Cliente cliente = new Cliente(nombre, cedula, telefono, categoria, mes);

        double total = 0;
        int puntos = 0;
        int cantidadVehiculos = 0;
        
// aca puse el ciclo del vehiculo

        String opcion = "Si";

        while (esSi(opcion)) {

           //informacion del carro basicamente, placa, marca y el precio 
           
            String placa = JOptionPane.showInputDialog("Placa del vehículo:");
            String marca = JOptionPane.showInputDialog("Marca del vehículo:");
            double precioDia = Double.parseDouble(JOptionPane.showInputDialog("Precio base por día:"));

            int dias = 0;
            boolean diasValidos = false;

            while (diasValidos == false) {
                dias = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de días (mayor a 0):"));
                if (dias > 0) {
                    diasValidos = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Días inválidos. Debe ser mayor a 0.");
                }
            }

            boolean seguro = esSi(JOptionPane.showInputDialog("¿Incluye seguro completo? (Si/No):"));
            boolean gps = esSi(JOptionPane.showInputDialog("¿Incluye GPS? (Si/No):"));

              // aca es el objeto del vehiculo 
              
            VehiculoAlquiler v = new VehiculoAlquiler(placa, marca, precioDia, dias, seguro, gps);

            JOptionPane.showMessageDialog(null,
                    ">> Subtotal vehículo " + v.getPlaca() + ": " + (long) v.getSubtotal()
                    + " | Puntos ganados: " + v.getPuntos());

            total += v.getSubtotal();
            puntos += v.getPuntos();
            cantidadVehiculos++;

            opcion = JOptionPane.showInputDialog("¿Desea ingresar otro vehículo? (Si/No):");
        }

        double totalAntesVIP = total;
        int puntosAntesVIP = puntos;

        if (cliente.esVIP()) {
            total = total * 0.95;
            puntos = puntos * 2;
        }
                //resumen final jijiji

        String resumen = "";
        resumen += "==================================================\n";
        resumen += "RESUMEN FINAL DE ALQUILERES\n";
        resumen += "==================================================\n\n";

        resumen += "Cliente: " + cliente.getNombre() + "\n";
        resumen += "Cédula: " + cliente.getCedula() + "\n";
        resumen += "Categoría: " + cliente.getCategoria() + "\n";
        resumen += "Mes de registro: " + cliente.getMesNombre() + "\n\n";

        resumen += "--------------------------------------------------\n\n";

        resumen += "Cantidad de vehículos procesados: " + cantidadVehiculos + "\n";
        resumen += "Subtotal antes de descuento VIP: " + (long) totalAntesVIP + "\n";
        resumen += "Puntos antes de bono VIP: " + puntosAntesVIP + "\n\n";

        if (cliente.esVIP()) {
            resumen += "*** APLICANDO BENEFICIOS VIP (5% Descuento / Puntos x2) ***\n\n";
        }

        resumen += "TOTAL A PAGAR: " + (long) total + "\n";
        resumen += "PUNTOS DE LEALTAD TOTALES: " + puntos + "\n\n";

        resumen += "==================================================";

        JOptionPane.showMessageDialog(null, resumen);
    }

    private static boolean esSi(String texto) {

        if (texto == null) {
            return false;
        }

        texto = texto.trim();

        if (texto.equals("Si")) {
            return true;
        } else {
            if (texto.equals("SI")) {
                return true;
            } else {
                if (texto.equals("si")) {
                    return true;
                } else {
                    if (texto.equals("Sí")) {
                        return true;
                    } else {
                        if (texto.equals("sí")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }
}
