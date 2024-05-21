package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Pregunta {

   private int idPregunta;
   private String enunciado;
   private TipoPregunta objTipoPregunta;
   private Cuestionario objCuestionario;
   private List<Respuesta> listaRespuestas;

}
