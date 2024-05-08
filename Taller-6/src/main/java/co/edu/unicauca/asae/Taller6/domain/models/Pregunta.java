package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor
public class Pregunta {

   private int idPregunta;
   private String enunciado;
   private TipoPregunta objTipoPregunta;
   private Cuestionario objCuestionario;
   private List<Respuesta> listaRespuestas;

   public Pregunta() {this.listaRespuestas = new ArrayList<Respuesta>();}

   public void addRespuesta(Respuesta respuesta) {this.listaRespuestas.add(respuesta);}

}
