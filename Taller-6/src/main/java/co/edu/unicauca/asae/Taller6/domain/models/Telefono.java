package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Telefono {

   private int idTelefono;
   private String tipoTelefono;
   private String numero;
   private Docente objDocente;

}
