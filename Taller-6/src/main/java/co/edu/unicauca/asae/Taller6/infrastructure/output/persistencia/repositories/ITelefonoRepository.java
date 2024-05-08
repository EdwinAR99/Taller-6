package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TelefonoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITelefonoRepository extends CrudRepository<TelefonoEntity, Integer> {
}
