package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DepartamentoDTORequest;

@Mapper(componentModel = "spring", uses = {DocenteMapperInfrastructureDomain.class})
public interface DepartamentoMapperInfraestructureDomain {

    @Mapping(target = "listaDocentes", ignore = true)
    DepartamentoDTORequest departamentoToDepartamentoDTORequest(Departamento departamento);

    @Mapping(target = "listaDocentes", ignore = true)
    List<DepartamentoDTORequest> departamentoToPreguntaDTORequests(List<Departamento> departamentos);

    @Mapping(target = "listaDocentes", ignore = true)
    Departamento departamentoDTORequestToDepartamento(DepartamentoDTORequest departamentoDTORequest);
    
    
}
