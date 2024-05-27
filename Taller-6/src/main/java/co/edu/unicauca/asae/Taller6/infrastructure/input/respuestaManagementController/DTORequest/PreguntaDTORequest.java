package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORequest {

    private int idPregunta;

    private CuestionarioDTORequest objCuestionario;

}
