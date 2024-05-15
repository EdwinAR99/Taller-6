package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;

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
  
  @Bean
  @Qualifier("createCuestionarioMapper")
  public ModelMapper crearCuestionarioMapper() {
     return new ModelMapper();
  }
  
}
