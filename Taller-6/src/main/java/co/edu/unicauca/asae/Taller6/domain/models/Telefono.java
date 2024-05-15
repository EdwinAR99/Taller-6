package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Telefono {

   private int idTelefono;
   private String tipoTelefono;
   private String numero;
   private Docente objDocente;

}
