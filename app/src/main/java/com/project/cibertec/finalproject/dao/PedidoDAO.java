package com.project.cibertec.finalproject.dao;

import android.database.Cursor;

import com.project.cibertec.finalproject.database.DataBaseSingleton;
import com.project.cibertec.finalproject.entities.Cliente;
import com.project.cibertec.finalproject.entities.Pedido;

import java.util.ArrayList;

/**
 * Created by V825727 on 6/8/2016.
 */
public class PedidoDAO {

    public ArrayList<Pedido> listPedidos() {
        Cursor cursor = null;
        cursor = DataBaseSingleton.getInstance().rawQuery
                ("SELECT p.pedidoId,p.clienteId,c.empresa, Count(p.pedidoId) As cantidadprod  , ROUND(SUM (p.pu*p.cantidad) ,2)as preciototal FROM TB_Pedido  p join  TB_Cliente c on c.clienteId = p.clienteId group by p.pedidoId"
                , null);

        ArrayList<Pedido> lstPedido = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                lstPedido.add(transformCursorToPedido(cursor));
            } while (cursor.moveToNext());
        }

        if (cursor != null && !cursor.isClosed())
            cursor.close();

        return lstPedido;
    }

    public ArrayList<Pedido> listDetailPedido(int pedidoid ) {
        Cursor cursor = null;
        cursor = DataBaseSingleton.getInstance().rawQuery
                ("SELECT p.pedidoId,p.productoId,c.nombre, c.descripcion  , p.pu,p.cantidad  FROM TB_Pedido  p join  TB_Producto c on c.productoId= p.productoId  Where p.pedidoId = ?"
                        , new String[]{String.valueOf(pedidoid)} );
        //SELECT p.pedidoId,p.productoId,c.nombre, c.descripcion  , p.pu,p.cantidad  FROM TB_Pedido  p join  TB_Producto c on c.productoId= p.productoId  Where p.pedidoId = 1
        ArrayList<Pedido> lstPedido = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                lstPedido.add(transformCursorToPedido(cursor));
            } while (cursor.moveToNext());
        }

        if (cursor != null && !cursor.isClosed())
            cursor.close();

        return lstPedido;
    }

    private Pedido transformCursorToPedido(Cursor cursor) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(cursor.getInt(cursor.getColumnIndex("pedidoId")));
        pedido.setIdCliente(cursor.getInt(cursor.getColumnIndex("clienteId")));

        pedido.setCantidadProductos(cursor.getInt(cursor.getColumnIndex("cantidadprod")));
        pedido.setTotalPedido(cursor.getDouble(cursor.getColumnIndex("preciototal")));
       // pedido.setTotalPedido(cursor.getDouble(cursor.getColumnIndex("total")));
        //pedido.setNombreCliente(cursor.getString(cursor.getColumnIndex("nombre")));
        pedido.setEmpresa(cursor.getString(cursor.getColumnIndex("empresa")));
        return pedido;
    }
}
