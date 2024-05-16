package com.bo.service;

import com.bo.collection.Proveedor;
import com.bo.repository.ProovedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorService {

	@Autowired
	private ProovedorRepository proveedorRepository;

	public void insertProveedor(Proveedor prov) {
		proveedorRepository.save(prov);
	}

	public List<Proveedor> consultarProveedores() {
		return proveedorRepository.findAll();

	}
}
