package com.example.practica_agenciaviajes_eduardo.Domain;

public class Reserva {
    private String destino;
    private String medioTransporte;
    private double precio;

    public Reserva(String destino, String medioTransporte, double precio) {
        this.destino = destino;
        this.medioTransporte = medioTransporte;
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "destino='" + destino + '\'' +
                ", medioTransporte='" + medioTransporte + '\'' +
                ", precio=" + precio +
                '}';
    }
}
