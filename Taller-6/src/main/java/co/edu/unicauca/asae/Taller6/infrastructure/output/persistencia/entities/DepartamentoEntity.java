package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class DepartamentoEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idDepartamento;

   @Column(nullable = false, unique = false)
   private String nombreDep;

   @Column(nullable = false)
   private String descripcion;

   @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idDepartamento"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
   private List<DocenteEntity> listaDocentes;

   public DepartamentoEntity() {
      this.listaDocentes = new ArrayList<DocenteEntity>();
   }

   public void addDocente(DocenteEntity docente) {this.listaDocentes.add(docente);}
}
