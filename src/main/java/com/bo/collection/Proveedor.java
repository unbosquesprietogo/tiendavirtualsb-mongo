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
@Document(collection = "proovedores")
public class Proveedor {

	@Id
	private String id;
	private String nit;
	private String ciudad;
	private String direccion;
	private String nombre;
	private String telefono;

}
