package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.gateway;

import co.edu.unicauca.asae.Taller6.application.output.managementGateway.CuestionarioManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.domain.models.Pregunta;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TipoPreguntaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.ICuestionarioRepository;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.ITipoPreguntaRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioManagementGatewayImplAdapter implements CuestionarioManagementGatewayIntPort {

   private final ICuestionarioRepository cuestionarioRepository;
   private final ModelMapper cuestionarioMapper;

   private final ITipoPreguntaRepository tipoPreguntaRepository;

   public CuestionarioManagementGatewayImplAdapter(
           ICuestionarioRepository cuestionarioRepository,
           @Qualifier("createCuestionarioMapper") ModelMapper cuestionarioMapper, 
           ITipoPreguntaRepository tipoPreguntaRepository) {
      this.cuestionarioMapper = cuestionarioMapper;
      this.cuestionarioRepository = cuestionarioRepository;
      this.tipoPreguntaRepository = tipoPreguntaRepository;
   }

   @Override
   public boolean existeCuestionarioPorTitulo(String titulo) {
      return this.cuestionarioRepository.existsByTituloIgnoreCase(titulo);
   }

   @Override
   public Cuestionario guardar(Cuestionario objCuestionario) {
      CuestionarioEntity objCuestionarioEntity = this.cuestionarioMapper.map(objCuestionario, CuestionarioEntity.class);
      for (int i = 0; i < objCuestionarioEntity.getListaPreguntas().size();i++){
         objCuestionarioEntity.getListaPreguntas().get(i).setObjCuestionario(objCuestionarioEntity);
         Optional<TipoPreguntaEntity> tipoPregunta = this.tipoPreguntaRepository.findById(objCuestionario.getListaPreguntas().get(i).getObjTipoPregunta().getIdTipoPregunta());
         objCuestionarioEntity.getListaPreguntas().get(i).setObjTipoPregunta(tipoPregunta.get());
      }
      CuestionarioEntity objCuestionarioSave = this.cuestionarioRepository.save(objCuestionarioEntity);
      Cuestionario objCuestionarioResponse = this.cuestionarioMapper.map(objCuestionarioSave, Cuestionario.class);
      return objCuestionarioResponse;
   }

   @Override
   public List<Cuestionario> listar() {
      Iterable<CuestionarioEntity> lista = this.cuestionarioRepository.findAll();
      List<Cuestionario> listObtenida = this.cuestionarioMapper.map(lista, new TypeToken<List<Cuestionario>>(){
         }.getType());

      return listObtenida;
   }

   @Override
   public List<Cuestionario> listarPorTitulo(String patron) {
      Iterable<CuestionarioEntity> lista = this.cuestionarioRepository.findByTituloContainingIgnoreCaseOrderByDesc(patron);
      List<Cuestionario> listObtenida = this.cuestionarioMapper.map(lista, new TypeToken<List<Cuestionario>>(){
      }.getType());

      return listObtenida;
   }
}
