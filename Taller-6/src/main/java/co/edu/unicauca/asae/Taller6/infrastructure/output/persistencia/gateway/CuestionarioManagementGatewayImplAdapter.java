package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.gateway;

import co.edu.unicauca.asae.Taller6.application.output.managementGateway.CuestionarioManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.mappers.CuestionarioMapper;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.ICuestionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuestionarioManagementGatewayImplAdapter implements CuestionarioManagementGatewayIntPort {

   private final ICuestionarioRepository cuestionarioRepository;
   private final CuestionarioMapper cuestionarioMapper;

   public CuestionarioManagementGatewayImplAdapter(
           ICuestionarioRepository cuestionarioRepository,
           CuestionarioMapper cuestionarioMapper) {
      this.cuestionarioMapper = cuestionarioMapper;
      this.cuestionarioRepository = cuestionarioRepository;
   }

   @Override
   public boolean existeCuestionarioPorId(int id) {
      return false;
   }

   @Override
   public Cuestionario guardar(Cuestionario objCuestionario) {
      return null;
   }

   @Override
   public List<Cuestionario> listar() {
      return List.of();
   }
}
