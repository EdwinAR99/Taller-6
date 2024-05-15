package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORequest {

    @NotEmpty(message = "{pregunta.enunciado.empty}")
    private String enunciado;
    @NotNull(message = "{pregunta.tipopregunta.empty}")
    private TipoPreguntaDTORequest objTipoPregunta;
    
    private CuestionarioDTORequest objCuestionario;
    @NotNull(message = "{pregunta.respuestas.null}")
    private List<RespuestaDTORequest> listaRespuestas;
}
