package com.bo.controller;

import com.bo.collection.Producto;
import com.bo.collection.Proveedor;
import com.bo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/insertar")
    public ResponseEntity<String> insertarProveedor(@RequestBody Proveedor proveedor) {
        proveedorService.insertProveedor(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado exitosamente");
    }

    @GetMapping("/consultar")
    public List<Proveedor> consultarProveedores() {
        return proveedorService.consultarProveedores();
    }
}
