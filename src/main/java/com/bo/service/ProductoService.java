package com.bo.service;

import com.bo.collection.Producto;
import com.bo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public boolean insertarProducto(Producto producto) {
        try {
            productoRepository.save(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();

    }
}
