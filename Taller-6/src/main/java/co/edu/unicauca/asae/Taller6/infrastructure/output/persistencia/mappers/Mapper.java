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

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.domain.models.Persona;
import co.edu.unicauca.asae.Taller6.domain.models.Pregunta;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.domain.models.Telefono;
import co.edu.unicauca.asae.Taller6.domain.models.TipoPregunta;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DepartamentoEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PersonaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.RespuestaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TelefonoEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TipoPreguntaEntity;

@Configuration
public class Mapper {

  @Bean
  @Qualifier("createDocenteMapper")
  public ModelMapper createDocenteMapper() {
    /*
     * ModelMapper objMapper = new ModelMapper();
     * TypeMap<DocenteEntity, Docente> docenteMap =
     * objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
     * docenteMap.addMapping(DocenteEntity::getObjTelefonoEntity,Docente::
     * setObjTelefono).implicitMappings();
     * docenteMap.addMapping(DocenteEntity::getListaDepartamentos,Docente::
     * setListaDepartamentos).implicitMappings();
     * return objMapper;
     */
    ModelMapper objMapper = new ModelMapper();

    // Mapear DocenteEntity a Docente
    TypeMap<DocenteEntity, Docente> docenteMap = objMapper.createTypeMap(DocenteEntity.class, Docente.class);

    // Mapear propiedades de DocenteEntity a Docente
    docenteMap.addMappings(mapper -> {
      mapper.map(DocenteEntity::getCorreo, Docente::setCorreo);
      mapper.map(DocenteEntity::getVinculacion, Docente::setVinculacion);
      mapper.map(DocenteEntity::getObjTelefono, Docente::setObjTelefono);
      mapper.map(DocenteEntity::getListaDepartamentos, Docente::setListaDepartamentos);
      mapper.map(DocenteEntity::getListaRespuestas, Docente::setListaRespuestas);
    });

    // Configurar el mapeo de las propiedades heredadas de PersonaEntity a Persona
    objMapper.typeMap(PersonaEntity.class, Persona.class).addMappings(mapper -> {
      mapper.map(PersonaEntity::getIdPersona, Persona::setIdPersona);
      mapper.map(PersonaEntity::getTipoIdentificacion, Persona::setTipoIdentificacion);
      mapper.map(PersonaEntity::getNumeroIdentificacion, Persona::setNumeroIdentificacion);
      mapper.map(PersonaEntity::getNombres, Persona::setNombres);
      mapper.map(PersonaEntity::getApellidos, Persona::setApellidos);
    });

    // Configurar el mapeo para los subobjetos
    objMapper.createTypeMap(TelefonoEntity.class, Telefono.class);
    objMapper.createTypeMap(DepartamentoEntity.class, Departamento.class);
    objMapper.createTypeMap(RespuestaEntity.class, Respuesta.class);

    return objMapper;

  }

  @Bean
  @Qualifier("DepartamentoMapper")
  public ModelMapper DepartamentoMapper() {
    ModelMapper objMapper = new ModelMapper();
    TypeMap<DepartamentoEntity, Departamento> departamentoMap = objMapper.emptyTypeMap(DepartamentoEntity.class,
        Departamento.class);
    return objMapper;
  }

  @Bean
  @Qualifier("createCuestionarioMapper")
  public ModelMapper crearCuestionarioMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.getConfiguration()
     .setAmbiguityIgnored(true);

    // Mapeo de Cuestionario a CuestionarioEntity
    modelMapper.typeMap(Cuestionario.class, CuestionarioEntity.class)
        .addMappings(mapper -> mapper.map(Cuestionario::getListaPreguntas, CuestionarioEntity::setListaPreguntas));

    // Mapeo de CuestionarioEntity a Cuestionario
    modelMapper.typeMap(CuestionarioEntity.class, Cuestionario.class)
        .addMappings(mapper -> mapper.map(CuestionarioEntity::getListaPreguntas, Cuestionario::setListaPreguntas));

    // Mapeo de Pregunta a PreguntaEntity y viceversa
    modelMapper.typeMap(Pregunta.class, PreguntaEntity.class)
        .addMappings(mapper -> {
          mapper.skip(PreguntaEntity::setObjCuestionario);
          mapper.skip(PreguntaEntity::setListaRespuestas);
        });

    modelMapper.typeMap(PreguntaEntity.class, Pregunta.class)
        .addMappings(mapper -> {
          mapper.skip(Pregunta::setObjCuestionario);
          mapper.skip(Pregunta::setListaRespuestas);
        });

    // Mapeo de TipoPregunta a TipoPreguntaEntity y viceversa
    modelMapper.typeMap(TipoPregunta.class, TipoPreguntaEntity.class)
        .addMappings(mapper -> mapper.skip(TipoPreguntaEntity::setListaPreguntas));

    modelMapper.typeMap(TipoPreguntaEntity.class, TipoPregunta.class)
        .addMappings(mapper -> mapper.skip(TipoPregunta::setListaPreguntas));

    return modelMapper;
  }

}
