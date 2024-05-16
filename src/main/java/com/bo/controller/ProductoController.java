package com.bo.controller;

import com.bo.collection.Producto;
import com.bo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarProducto(@RequestBody Producto producto) {
        productoService.insertarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado exitosamente");
    }
    @GetMapping("/listar")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }
}
