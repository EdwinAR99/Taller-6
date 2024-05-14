package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class TipoPreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPregunta;

    @Column(nullable = false, unique = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE} , mappedBy = "objTipoPreguntaEntity")
    private List<PreguntaEntity> listaPreguntas;

    public TipoPreguntaEntity() {
        this.listaPreguntas = new ArrayList<PreguntaEntity>();
    }

    public void addPregunta(PreguntaEntity preguntaEntity){
        this.listaPreguntas.add(preguntaEntity);
    }

}
