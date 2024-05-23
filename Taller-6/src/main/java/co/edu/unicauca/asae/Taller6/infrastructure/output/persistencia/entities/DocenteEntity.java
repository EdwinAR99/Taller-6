package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocenteEntity extends PersonaEntity {

   @Column(unique = true)
   private String correo;

   @Column
   private String vinculacion;

   @OneToOne(mappedBy = "objDocente",cascade = {CascadeType.PERSIST})
   private TelefonoEntity objTelefono;

   @ManyToMany(
      fetch = FetchType.EAGER, 
      cascade = {CascadeType.MERGE})
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
   private List<DepartamentoEntity> listaDepartamentos;

   @OneToMany(
      fetch = FetchType.LAZY, 
      cascade = {CascadeType.PERSIST}, mappedBy = "objPersona")
   private List<RespuestaEntity> listaRespuestas;

   public DocenteEntity(String tipoIdentificacion,
                        String numeroIdentificacion,
                        String nombres,
                        String apellidos,
                        String correo,
                        String vinculacion) {
      super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
      this.correo = correo;
      this.vinculacion = vinculacion;
   }

   public void addDepartamento(DepartamentoEntity dpto) {
      this.listaDepartamentos.add(dpto);
   }

   public void addRespuesta(RespuestaEntity objRespuestaEntity) {
      this.listaRespuestas.add(objRespuestaEntity);
   }
}
