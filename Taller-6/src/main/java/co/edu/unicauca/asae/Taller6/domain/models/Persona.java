package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Persona {

   private int idPersona;
   private String tipoIdentificacion;
   private String numeroIdentificacion;
   private String nombres;
   private String apellidos;

   public Persona(String numeroIdentificacion, String nombres, String apellidos, String tipoIdentificacion) {
      this.numeroIdentificacion = numeroIdentificacion;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.tipoIdentificacion = tipoIdentificacion;
   }

}
