package co.edu.unicauca.asae.Taller6.domain.models;

import lombok.*;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Docente extends Persona{

   private String correo;
   private String vinculacion;
   private Telefono objTelefono;
   private List<Departamento> listaDepartamentos;
   private List<Respuesta> listaRespuestas;

   /*public Docente() {
      this.listaDepartamentos = new ArrayList<Departamento>();
      this.listaRespuestas = new ArrayList<Respuesta>();
   }

   public Docente(String tipoIdentificacion,
                  String numeroIdentificacion,
                  String nombres,
                  String apellidos,
                  String correo,
                  String vinculacion) {
      super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
      this.correo = correo;
      this.vinculacion = vinculacion;
      this.listaDepartamentos = new ArrayList<Departamento>();
      this.listaRespuestas = new ArrayList<Respuesta>();
   }*/

   public void addDepartamento(Departamento departamento) {this.listaDepartamentos.add(departamento);}

   
   //public void addRespuesta(Respuesta respuesta) {this.listaRespuestas.add(respuesta);}

}
