package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class CuestionarioEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objCuestionarioEntity")
    private List<PreguntaEntity> listaPreguntas;

    public CuestionarioEntity() {
        this.listaPreguntas = new ArrayList<PreguntaEntity>();
    }

    public void addPregunta(PreguntaEntity preguntaEntity){
        this.listaPreguntas.add(preguntaEntity);
    }

}
