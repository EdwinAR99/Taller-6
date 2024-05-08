package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column(nullable = false)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPreguntaEntity objTipoPreguntaEntity;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private CuestionarioEntity objCuestionarioEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "objPreguntaEntity")
    private List<RespuestaEntity> listaRespuestas;

    public PreguntaEntity() {
        this.listaRespuestas = new ArrayList<RespuestaEntity>();
    }

    public void addRespuesta(RespuestaEntity respuestaEntity){
        this.listaRespuestas.add(respuestaEntity);
    }

}
