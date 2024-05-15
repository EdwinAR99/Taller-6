package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Respuesta {

   private int idRespuesta;
   private String descripcion;
   private Persona objPersona;
   private Pregunta objPregunta;

}
