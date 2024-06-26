package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTORequest {

    private String descripcion;
    private PersonaDTORequest objPersona;
    private PreguntaDTORequest objPregunta;
}
