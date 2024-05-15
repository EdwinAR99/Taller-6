package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTOResponse;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class CuestionarioDTOResponse {

   private int idCuestionario;
   private String titulo;
   private String descripcion;
   private List<PreguntaEntity> listaPreguntas;

   public CuestionarioDTOResponse() {}

}
