package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTORequest {

   @NotEmpty(message = "{cuestionario.titulo.empty}")
   private String titulo;
   @NotNull(message = "{cuestionario.descripcion.null}")
   private String descripcion;
   @NotNull(message = "{cuestionario.preguntas.null}")
   @Size(min = 5, max = 5, message = "{cuestionario.preguntas.size}")
   private List<PreguntaDTORequest> listaPreguntas;

}
