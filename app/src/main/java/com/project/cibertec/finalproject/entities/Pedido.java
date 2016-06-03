package com.project.cibertec.finalproject.entities;

import java.util.ArrayList;

public class Pedido {

    private int idPedido;
    private int idCliente;
    private String nombreCliente;
    private int cantidadProductos;
    private double totalPedido;
    private ArrayList<PedidoDetalle> lineas;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public ArrayList<PedidoDetalle> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<PedidoDetalle> lineas) {
        this.lineas = lineas;
    }
}
