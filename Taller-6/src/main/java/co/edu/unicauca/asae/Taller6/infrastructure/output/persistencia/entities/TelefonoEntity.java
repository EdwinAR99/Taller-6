package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TelefonoEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idTelefono;

   @Column(nullable = false)
   private String tipoTelefono;

   @Column(nullable = false)
   private String numero;

   @OneToOne(cascade = {CascadeType.MERGE})
   @JoinColumn(name = "idPersona")
   private DocenteEntity objDocenteEntity;

}
