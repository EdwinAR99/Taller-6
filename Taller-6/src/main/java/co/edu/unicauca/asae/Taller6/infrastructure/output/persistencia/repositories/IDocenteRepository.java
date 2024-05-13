package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IDocenteRepository
  extends CrudRepository<DocenteEntity, Integer> {
  @Query("SELECT count(*) FROM PersonaEntity d  WHERE d.idPersona=?1")
  Integer existDocenteForNumberId(String idPersona);

  @Query("SELECT count(*) FROM PersonaEntity d  WHERE d.correo=?1")
  Integer existDocenteForEmail(String correo);
}
