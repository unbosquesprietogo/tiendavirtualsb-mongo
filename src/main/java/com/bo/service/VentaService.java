package com.bo.service;


import com.bo.collection.DetalleVenta;
import com.bo.collection.Venta;
import com.bo.model.VentaResponse;
import com.bo.repository.DetalleVentaRepository;
import com.bo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;


	public boolean insertarVentaConDetalles(Venta venta, List<DetalleVenta> detalles) {
		try {
			Venta ventaGuardada = ventaRepository.save(venta);

			for (DetalleVenta detalle : detalles) {
				detalle.setVenta(ventaGuardada);
				detalleVentaRepository.save(detalle);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public VentaResponse consultarVentaConDetalles(Long idVenta) {
		Venta venta = ventaRepository.findById(idVenta).orElse(null);
		if (venta != null) {
			List<DetalleVenta> detalles = detalleVentaRepository.findByVentaId(idVenta);
			return new VentaResponse(venta, detalles);
		}
		return null;
	}
}
