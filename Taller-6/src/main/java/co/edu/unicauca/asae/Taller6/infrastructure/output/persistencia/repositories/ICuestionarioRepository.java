package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories;

import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.CuestionarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {

   @Query("SELECT c FROM CuestionarioEntity c WHERE LOWER(c.titulo) LIKE LOWER(CONCAT('%', :patron, '%')) ORDER BY c.idCuestionario DESC")
   List<CuestionarioEntity> findByTituloContainingIgnoreCaseOrderByDesc(@Param("patron") String patron);

   @Query("SELECT COUNT(c) > 0 FROM CuestionarioEntity c WHERE LOWER(c.titulo) = LOWER(:titulo)")
   boolean existsByTituloIgnoreCase(@Param("titulo") String titulo);

}
