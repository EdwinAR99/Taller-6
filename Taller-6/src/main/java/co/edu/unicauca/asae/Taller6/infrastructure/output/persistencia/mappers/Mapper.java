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

    ModelMapper objMapper = new ModelMapper();

    objMapper.getConfiguration()
        .setAmbiguityIgnored(true);
    // Mapear DocenteEntity a Docente
    objMapper.createTypeMap(DocenteEntity.class, Docente.class)
        .addMappings(mapper -> {
          mapper.map(DocenteEntity::getObjTelefono, Docente::setObjTelefono);
          mapper.map(DocenteEntity::getListaDepartamentos, Docente::setListaDepartamentos);
        });

    objMapper.createTypeMap(Docente.class, DocenteEntity.class)
        .addMappings(mapper -> {
          mapper.map(Docente::getObjTelefono, DocenteEntity::setObjTelefono);
          mapper.map(Docente::getListaDepartamentos, DocenteEntity::setListaDepartamentos);
        });
    /*
     * // Configurar el mapeo de las propiedades heredadas de PersonaEntity a
     * Persona
     * objMapper.typeMap(PersonaEntity.class, Persona.class).addMappings(mapper -> {
     * mapper.map(PersonaEntity::getIdPersona, Persona::setIdPersona);
     * mapper.map(PersonaEntity::getTipoIdentificacion,
     * Persona::setTipoIdentificacion);
     * mapper.map(PersonaEntity::getNumeroIdentificacion,
     * Persona::setNumeroIdentificacion);
     * mapper.map(PersonaEntity::getNombres, Persona::setNombres);
     * mapper.map(PersonaEntity::getApellidos, Persona::setApellidos);
     * });
     * 
     * objMapper.typeMap(Persona.class, PersonaEntity.class).addMappings(mapper -> {
     * mapper.map(Persona::getIdPersona, PersonaEntity::setIdPersona);
     * mapper.map(Persona::getTipoIdentificacion,
     * PersonaEntity::setTipoIdentificacion);
     * mapper.map(Persona::getNumeroIdentificacion,
     * PersonaEntity::setNumeroIdentificacion);
     * mapper.map(Persona::getNombres, PersonaEntity::setNombres);
     * mapper.map(Persona::getApellidos, PersonaEntity::setApellidos);
     * });
     */
    // mapper telefono
    objMapper.createTypeMap(TelefonoEntity.class, Telefono.class)
        .addMappings(mapper -> mapper.skip(Telefono::setObjDocente));

    objMapper.createTypeMap(Telefono.class, TelefonoEntity.class)
        .addMappings(mapper -> mapper.skip(TelefonoEntity::setObjDocente));

    // mapper departamento
    objMapper.createTypeMap(DepartamentoEntity.class, Departamento.class)
        .addMappings(mapper -> mapper.skip(Departamento::setListaDocentes));

    objMapper.createTypeMap(Departamento.class, DepartamentoEntity.class)
        .addMappings(mapper -> mapper.skip(DepartamentoEntity::setListaDocentes));

    objMapper.createTypeMap(RespuestaEntity.class, Respuesta.class);

    return objMapper;

  }

  @Bean
  @Qualifier("createRespuestaMapper")
  public ModelMapper crearRespuestaMapper() {

    ModelMapper modelMapper = new ModelMapper();

    modelMapper.getConfiguration()
        .setAmbiguityIgnored(true);

    // Mapear Respuesta a RespuestaEntity y viceversa
    modelMapper.typeMap(Respuesta.class, RespuestaEntity.class)
        .addMappings(mapper -> {
          mapper.map(Respuesta::getObjPersona, RespuestaEntity::setObjPersona);
          mapper.map(Respuesta::getObjPregunta, RespuestaEntity::setObjPregunta);
        });

    modelMapper.typeMap(RespuestaEntity.class, Respuesta.class)
        .addMappings(mapper -> {
          mapper.map(RespuestaEntity::getObjPersona, Respuesta::setObjPersona);
          mapper.map(RespuestaEntity::getObjPregunta, Respuesta::setObjPregunta);
        });

    // Mapear Docente a DocenteEntity y viceversa
    modelMapper.typeMap(Docente.class, DocenteEntity.class)
        .addMappings(mapper -> {
          mapper.skip(Docente::getObjTelefono, DocenteEntity::setObjTelefono);
          mapper.skip(Docente::getListaDepartamentos, DocenteEntity::setListaDepartamentos);
          mapper.skip(Docente::getListaRespuestas, DocenteEntity::setListaRespuestas);
        });

    modelMapper.typeMap(DocenteEntity.class, Docente.class)
        .addMappings(mapper -> {
          mapper.skip(DocenteEntity::getObjTelefono, Docente::setObjTelefono);
          mapper.skip(DocenteEntity::getListaDepartamentos, Docente::setListaDepartamentos);
          mapper.skip(DocenteEntity::getListaRespuestas, Docente::setListaRespuestas);
        });

    // Mapear Pregunta a PreguntaEntity y viceversa
    modelMapper.typeMap(Pregunta.class, PreguntaEntity.class)
        .addMappings(mapper -> {
          mapper.map(Pregunta::getObjCuestionario, PreguntaEntity::setObjCuestionario);
          mapper.skip(Pregunta::getObjTipoPregunta, PreguntaEntity::setObjTipoPregunta);
          mapper.skip(Pregunta::getListaRespuestas, PreguntaEntity::setListaRespuestas);
        });

    modelMapper.typeMap(PreguntaEntity.class, Pregunta.class)
        .addMappings(mapper -> {
          mapper.map(PreguntaEntity::getObjCuestionario, Pregunta::setObjCuestionario);
          mapper.skip(PreguntaEntity::getObjTipoPregunta, Pregunta::setObjTipoPregunta);
          mapper.skip(PreguntaEntity::getListaRespuestas, Pregunta::setListaRespuestas);
        });

    // Mapear Cuestionario a CuestionarioEntity y viceversa
    modelMapper.typeMap(Cuestionario.class, CuestionarioEntity.class)
        .addMappings(mapper -> {
          mapper.skip(Cuestionario::getListaPreguntas, CuestionarioEntity::setListaPreguntas);
        });

    modelMapper.typeMap(CuestionarioEntity.class, Cuestionario.class)
        .addMappings(mapper -> {
          mapper.skip(CuestionarioEntity::getListaPreguntas, Cuestionario::setListaPreguntas);
        });
    return modelMapper;
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
