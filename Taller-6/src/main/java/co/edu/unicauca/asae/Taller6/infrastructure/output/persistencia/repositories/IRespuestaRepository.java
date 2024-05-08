package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.RespuestaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IRespuestaRepository extends CrudRepository<RespuestaEntity, Integer> {

}
