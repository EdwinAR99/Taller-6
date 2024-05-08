package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPreguntaRepository extends CrudRepository<PreguntaEntity, Integer> {

}
