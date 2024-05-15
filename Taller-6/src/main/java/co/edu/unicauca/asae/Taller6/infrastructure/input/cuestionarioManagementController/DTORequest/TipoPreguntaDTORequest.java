package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class TipoPreguntaDTORequest {

    private int idTipoPregunta;
    @NotEmpty(message = "{tipopregunta.nombre.empty}")
    private String nombre;
    @NotEmpty(message = "{tipopregunta.descripcion.empty}")
    private String descripcion;
    
    private List<PreguntaDTORequest> listaPreguntas;
}
