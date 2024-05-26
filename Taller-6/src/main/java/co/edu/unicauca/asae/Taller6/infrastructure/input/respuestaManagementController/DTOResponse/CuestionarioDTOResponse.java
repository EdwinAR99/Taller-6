package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTOResponse {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
}
