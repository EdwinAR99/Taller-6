package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.CuestionarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {

   List<CuestionarioEntity> findByTituloContainingIgnoreCaseOrderByIdDesc(String titulo);

   @Query("SELECT COUNT(c) > 0 FROM Cuestionario c WHERE LOWER(c.titulo) = LOWER(:titulo)")
   boolean existsByTitulo(@Param("titulo") String titulo);

}
