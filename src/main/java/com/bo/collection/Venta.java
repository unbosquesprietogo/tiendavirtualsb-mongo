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
@Document(collection = "ventas")
public class Venta {

	@Id
	private String id;
	private String cedulaCliente;
	private String cedulaUsuario;
	private Double ivaVenta;
	private Double totalVenta;
	private Double valorVenta;


}

