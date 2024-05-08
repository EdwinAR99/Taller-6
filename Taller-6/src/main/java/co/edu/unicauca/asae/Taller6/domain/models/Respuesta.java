package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Respuesta {

   private int idRespuesta;
   private String descripcion;
   private Persona objPersona;
   private Pregunta objPregunta;

}
