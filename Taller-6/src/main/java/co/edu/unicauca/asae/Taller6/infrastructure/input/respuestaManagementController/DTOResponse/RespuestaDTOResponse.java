package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTOResponse {

    private int idRespuesta;
    private String descripcion;
    private PersonaDTOResponse objPersona;
    private PreguntaDTOResponse objPregunta;

    public RespuestaDTOResponse() {
    }
}
