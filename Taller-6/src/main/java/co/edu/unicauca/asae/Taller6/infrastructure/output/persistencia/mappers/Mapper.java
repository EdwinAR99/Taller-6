package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DepartamentoEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TipoPreguntaEntity;

@Configuration
public class Mapper {

  
  @Bean
  @Qualifier("createDocenteMapper")
  public ModelMapper createDocenteMapper() {
    ModelMapper objMapper = new ModelMapper();
        TypeMap<DocenteEntity, Docente> docenteMap = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        docenteMap.addMapping(DocenteEntity::getObjTelefonoEntity,Docente::setObjTelefono).implicitMappings();
        return objMapper;
  }
  
  @Primary
  @Bean
  @Qualifier("DepartamentoMapper")
  public ModelMapper DepartamentoMapper() {
    ModelMapper objMapper = new ModelMapper();
        TypeMap<DepartamentoEntity, Departamento> departamentoMap = objMapper.emptyTypeMap(DepartamentoEntity.class, Departamento.class);
        return objMapper;
  }
  
   /* 
  @Bean
  @Qualifier("createCuestionarioMapper")
  public ModelMapper crearCuestionarioMapper() {
      ModelMapper modelMapper = new ModelMapper();

      // Configuración de mapeo para evitar ciclos infinitos
      modelMapper.getConfiguration()
      .setAmbiguityIgnored(true)
      .setSkipNullEnabled(true);

      // Mapeo para TipoPreguntaEntity a TipoPregunta
      modelMapper.typeMap(TipoPreguntaEntity.class, TipoPregunta.class);

      // Mapeo para PreguntaEntity a Pregunta
      modelMapper.typeMap(PreguntaEntity.class, Pregunta.class)
      .addMappings(mapper -> mapper.map(PreguntaEntity::getObjTipoPregunta, Pregunta::setObjTipoPregunta))
      .addMappings(mapper -> mapper.skip(Pregunta::setObjCuestionario));

      // Mapeo para Pregunta a PreguntaEntity
      modelMapper.typeMap(Pregunta.class, PreguntaEntity.class)
      .addMappings(mapper -> mapper.skip(PreguntaEntity::setObjCuestionario))
      .addMappings(mapper -> mapper.map(Pregunta::getObjTipoPregunta, PreguntaEntity::setObjTipoPregunta));

      // Mapeo para CuestionarioEntity a Cuestionario
      TypeMap<CuestionarioEntity, Cuestionario> cuestionarioMap = modelMapper.createTypeMap(CuestionarioEntity.class, Cuestionario.class);
      cuestionarioMap.addMappings(mapper -> mapper.skip( Cuestionario::setListaPreguntas));

      // Mapeo para Cuestionario a CuestionarioEntity
      TypeMap<Cuestionario, CuestionarioEntity> cuestionarioEntityMap = modelMapper.createTypeMap(Cuestionario.class, CuestionarioEntity.class);
      cuestionarioEntityMap.addMappings(mapper -> mapper.map(Cuestionario::getListaPreguntas, CuestionarioEntity::setListaPreguntas));

        return modelMapper;
  }
  */
}
