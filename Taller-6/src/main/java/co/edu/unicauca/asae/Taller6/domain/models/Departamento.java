package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.*;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Departamento {

   private int idDepartamento;
   private String nombreDep;
   private String descripcion;
   private List<Docente> listaDocentes;


   public void addDocente(Docente docente) {this.listaDocentes.add(docente);}
}
