package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.gateway;

import co.edu.unicauca.asae.Taller6.application.output.managementGateway.DocenteManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IDocenteRepository;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocenteManagementGatewayImplAdapter
  implements DocenteManagementGatewayIntPort {

  private final IDocenteRepository objDocenteRepository;
  private final ModelMapper docenteModelMapper;

  public DocenteManagementGatewayImplAdapter(
    @Qualifier("createDocenteMapper") ModelMapper docenteModelMapper,
    IDocenteRepository objDocenteRepository
   
  ) {
    this.objDocenteRepository = objDocenteRepository;
    this.docenteModelMapper = docenteModelMapper;
  }

  @Override
  public boolean existDocenteForNumberId(String numeroIdentificacion) {
    return (
      this.objDocenteRepository.existDocenteForNumberId(numeroIdentificacion) ==
      1
    );
  }

  @Override
  public Docente saveDocente(Docente objDocente) {
    DocenteEntity objDocenteEntity =
      this.docenteModelMapper.map(objDocente, DocenteEntity.class);
    DocenteEntity objDocenteEntityR =
      this.objDocenteRepository.save(objDocenteEntity);
    Docente objDocenteResponse =
      this.docenteModelMapper.map(objDocenteEntityR, Docente.class);
    return objDocenteResponse;
  }

  @Override
  public Docente getDocente(Integer id) {
    Optional<DocenteEntity> objDocenteEntityR =
      this.objDocenteRepository.findById(id);
    Docente objDocenteEntityResponse =
      this.docenteModelMapper.map(objDocenteEntityR, Docente.class);
    return objDocenteEntityResponse;
  }

  @Override
  public boolean existDocenteForEmail(String correo) {
    return this.objDocenteRepository.existDocenteForEmail(correo) == 1;
  }
}
