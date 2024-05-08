package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TipoPreguntaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITipoPreguntaRepository extends CrudRepository<TipoPreguntaEntity, Integer> {
}
