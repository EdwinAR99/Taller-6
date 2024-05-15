package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;

@Configuration
public class DocenteMapper {

  @Bean
  public ModelMapper createDocenteMapper() {
    ModelMapper objMapper = new ModelMapper();
        TypeMap<DocenteEntity, Docente> docenteMap = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        docenteMap.addMapping(DocenteEntity::getObjTelefonoEntity,Docente::setObjTelefono).implicitMappings();
        return objMapper;
  }
}
