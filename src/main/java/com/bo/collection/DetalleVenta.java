package com.bo.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "detalleVentas")
public class DetalleVenta {

    @Id
    private Long id;
    private Integer cantidadProducto;
    private String idProducto;
    private Venta venta;
    private Double valorTotal;
    private Double valorVenta;
    private Double valorIva;

}
