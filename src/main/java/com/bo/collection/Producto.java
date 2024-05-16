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
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;
    private String idProducto;
    private Double ivaCompra;
    private String nombre;
    private Double precioCompra;
    private Double precioVenta;
    private String nitprov;


    // Getters and setters
}
