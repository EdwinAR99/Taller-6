package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.Taller6.domain.models.Telefono;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.TelefonoDTORequest;

@Mapper(componentModel = "spring", uses = {DocenteMapperInfrastructureDomain.class})
public interface TelefonoMapperInfraestructureDomain {

    @Mapping(target = "objDocente", ignore = true)
    TelefonoDTORequest telefonoToDepartamentoDTORequest(Telefono telefono);

    @Mapping(target = "objDocente", ignore = true)
    List<TelefonoDTORequest> telefonoToPreguntaDTORequests(List<Telefono> telefonos);

    @Mapping(target = "objDocente", ignore = true)
    Telefono telefonoDTORequestToTelefono (Telefono telefonoDTORequest);
}
