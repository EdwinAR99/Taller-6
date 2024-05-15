package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.*;

@Data @AllArgsConstructor @Getter @Setter
public class Persona {

   private int idPersona;
   private String tipoIdentificacion;
   private String numeroIdentificacion;
   private String nombres;
   private String apellidos;

   public Persona() {}

   /* public Persona(String numeroIdentificacion, String nombres, String apellidos, String tipoIdentificacion) {
      this.numeroIdentificacion = numeroIdentificacion;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.tipoIdentificacion = tipoIdentificacion;
   }*/

}
