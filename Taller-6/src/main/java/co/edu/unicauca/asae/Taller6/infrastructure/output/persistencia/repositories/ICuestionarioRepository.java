package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.CuestionarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {

}
