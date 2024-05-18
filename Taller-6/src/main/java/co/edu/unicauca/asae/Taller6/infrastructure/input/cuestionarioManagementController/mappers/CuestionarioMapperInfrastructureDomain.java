package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.mappers;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest.CuestionarioDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTOResponse.CuestionarioDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfrastructureDomain {

   @Mapping(target = "idCuestionario", ignore = true)
   Cuestionario requestToCuestionario(CuestionarioDTORequest request);

   CuestionarioDTOResponse cuestionarioToResponse(Cuestionario objCuestionario);

   List<CuestionarioDTOResponse> cuestionariosToResponses(List<Cuestionario> cuestionarios);

}
