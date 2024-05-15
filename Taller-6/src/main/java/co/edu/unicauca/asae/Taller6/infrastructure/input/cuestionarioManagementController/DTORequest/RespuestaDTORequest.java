package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PersonaEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class RespuestaDTORequest {

    @NotEmpty(message = "{respuesta.descripcion.empty}")
    private String descripcion;

    private PersonaEntity objPersona;
    
    private PreguntaDTORequest objPregunta;


}
