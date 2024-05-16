package com.bo.repository;


import com.bo.collection.DetalleVenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends MongoRepository<DetalleVenta, String> {

    List<DetalleVenta> findByVentaId(long idVenta);
}