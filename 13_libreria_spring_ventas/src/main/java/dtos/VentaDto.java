package dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaDto {
	
	//en un informe de ventas nos interesa manejar los siguientes campos
	private int idVenta;
	private String usuario;
	
	private String tituloLibro;
	
	//clase de fecha en java 8
	private LocalDate fechaVenta;
	
	

}
