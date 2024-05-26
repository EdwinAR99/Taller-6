package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOResponse {
    private int idPregunta;
    private String enunciado;
    private CuestionarioDTOResponse objCuestionario;
}
