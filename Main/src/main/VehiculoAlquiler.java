/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author sophi
 */
public class VehiculoAlquiler {

  
    private String placa;
    private String marca;
    private double precioDia;
    private int dias;
    private boolean seguroCompleto;
    private boolean gps;

    private double subtotal;
    private int puntos;

   
    public VehiculoAlquiler(String placa, String marca, double precioDia, int dias,
                            boolean seguroCompleto, boolean gps) {

        this.placa = placa;
        this.marca = marca;
        this.precioDia = precioDia;
        this.dias = dias;
        this.seguroCompleto = seguroCompleto;
        this.gps = gps;

        calcular();
    }

   
    private void calcular() {

        double base = precioDia * dias;
        puntos = 0;

      
        if (dias > 7) {
            base = base * 0.85;
            puntos = puntos + 5;
        }

       
        if (seguroCompleto == true) {
            base = base + (5000 * dias);
            puntos = puntos + 2;
        }

    
        if (gps == true) {
            base = base + (2000 * dias);
        }

        subtotal = base;
    }

   
    public String getPlaca() {
        return placa;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getPuntos() {
        return puntos;
    }
}
   

  
     