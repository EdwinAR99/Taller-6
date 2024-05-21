package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Cuestionario {

   private int idCuestionario;
   private String titulo;
   private String descripcion;
   private List<Pregunta> listaPreguntas;
}
