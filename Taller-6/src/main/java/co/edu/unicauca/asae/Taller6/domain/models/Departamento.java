package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class Departamento {

   private int idDepartamento;
   private String nombreDep;
   private String descripcion;
   private List<Docente> listaDocentes;

}
