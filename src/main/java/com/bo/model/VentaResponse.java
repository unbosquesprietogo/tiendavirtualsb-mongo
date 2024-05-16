package com.bo.model;

import com.bo.collection.DetalleVenta;
import com.bo.collection.Venta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaResponse {

    private Venta venta;
    private List<DetalleVenta> detalleVentas;

}
