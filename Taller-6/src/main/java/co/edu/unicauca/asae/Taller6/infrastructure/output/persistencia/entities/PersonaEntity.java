package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PersonaEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idPersona;

   @Column(nullable = false)
   private String tipoIdentificacion;

   @Column(unique = true, nullable = false)
   private String numeroIdentificacion;

   @Column(nullable = false)
   private String nombres;

   @Column(nullable = false)
   private String apellidos;

   public PersonaEntity(String numeroIdentificacion, String nombres, String apellidos, String tipoIdentificacion) {
      this.numeroIdentificacion = numeroIdentificacion;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.tipoIdentificacion = tipoIdentificacion;
   }
}
