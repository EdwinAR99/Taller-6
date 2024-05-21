package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTOResponse;

import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest.PreguntaDTORequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class CuestionarioDTOResponse {

   private int idCuestionario;
   private String titulo;
   private String descripcion;
   private List<PreguntaDTORequest> listaPreguntas;

   public CuestionarioDTOResponse() {}

}
