package com.bo.controller;

import com.bo.collection.DetalleVenta;
import com.bo.collection.Venta;
import com.bo.model.VentaResponse;
import com.bo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/insertar")
    public boolean insertarVentaConDetalles(@RequestBody Venta venta, @RequestBody List<DetalleVenta> detalles) {
        return ventaService.insertarVentaConDetalles(venta, detalles);
    }

    @GetMapping("/consultar/{idVenta}")
    public VentaResponse consultarVentaConDetalles(@PathVariable Long idVenta) {
        return ventaService.consultarVentaConDetalles(idVenta);
    }
}
