package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor
public class TipoPregunta {

   private int idTipoPregunta;
   private String nombre;
   private String descripcion;
   private List<Pregunta> listaPreguntas;

   public TipoPregunta() {this.listaPreguntas = new ArrayList<Pregunta>();}

   public void addPregunta(Pregunta pregunta) {this.listaPreguntas.add(pregunta);}

}
