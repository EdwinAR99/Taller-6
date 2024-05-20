package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class DocenteEntity extends PersonaEntity {

   @Column(unique = true)
   private String correo;

   @Column
   private String vinculacion;

   @OneToOne(mappedBy = "objDocenteEntity",cascade = {CascadeType.ALL})
   private TelefonoEntity objTelefonoEntity;

   @ManyToMany(
      fetch = FetchType.EAGER, 
      cascade = {CascadeType.PERSIST})
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
   private List<DepartamentoEntity> listaDepartamentos;

   @OneToMany(
      fetch = FetchType.EAGER, 
      cascade = {CascadeType.ALL}, mappedBy = "objPersona")
   private List<RespuestaEntity> listaRespuestas;

   public DocenteEntity() {
      this.listaDepartamentos = new ArrayList<DepartamentoEntity>();
      this.listaRespuestas = new ArrayList<RespuestaEntity>();
   }

   public DocenteEntity(String tipoIdentificacion,
                        String numeroIdentificacion,
                        String nombres,
                        String apellidos,
                        String correo,
                        String vinculacion) {
      super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
      this.correo = correo;
      this.vinculacion = vinculacion;
      this.listaDepartamentos = new ArrayList<DepartamentoEntity>();
      this.listaRespuestas = new ArrayList<RespuestaEntity>();
   }

   public void addDepartamento(DepartamentoEntity dpto) {
      this.listaDepartamentos.add(dpto);
   }

   public void addRespuesta(RespuestaEntity objRespuestaEntity) {
      this.listaRespuestas.add(objRespuestaEntity);
   }
}
