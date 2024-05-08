package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;


import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DepartamentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoRepository extends CrudRepository<DepartamentoEntity, Integer> {
}
