package com.bo.repository;


import com.bo.collection.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProovedorRepository extends MongoRepository<Proveedor, String> {

}