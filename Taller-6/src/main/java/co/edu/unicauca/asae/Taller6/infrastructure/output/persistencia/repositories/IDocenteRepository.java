package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDocenteRepository extends CrudRepository<DocenteEntity, Integer> {

}
