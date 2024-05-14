package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor
public class Cuestionario {

   private int idCuestionario;
   private String titulo;
   private String descripcion;
   private List<Pregunta> listaPreguntas;

   public Cuestionario() {this.listaPreguntas = new ArrayList<Pregunta>();}

   public void addPregunta(Pregunta pregunta) {this.listaPreguntas.add(pregunta);}

}
