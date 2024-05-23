package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.gateway;

import co.edu.unicauca.asae.Taller6.application.output.managementGateway.DocenteManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DepartamentoEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.TelefonoEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IDepartamentoRepository;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IDocenteRepository;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocenteManagementGatewayImplAdapter
    implements DocenteManagementGatewayIntPort {

  private final IDocenteRepository objDocenteRepository;
  private final IDepartamentoRepository objDepartamentoRepository;
  private final ModelMapper docenteModelMapper;

  public DocenteManagementGatewayImplAdapter(
      @Qualifier("createDocenteMapper") ModelMapper docenteModelMapper,
      IDocenteRepository objDocenteRepository,
      IDepartamentoRepository objDepartamentoRepository

  ) {
    this.objDocenteRepository = objDocenteRepository;
    this.docenteModelMapper = docenteModelMapper;
    this.objDepartamentoRepository = objDepartamentoRepository;
  }

  @Override
  public boolean existDocenteForNumberId(String numeroIdentificacion) {
    return (this.objDocenteRepository.existDocenteForNumberId(numeroIdentificacion) == 1);
  }

  @Override
  public Docente saveDocente(Docente objDocente) {
    DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);

    // Agregar el departamento

    for (int i = 0; i < objDocenteEntity.getListaDepartamentos().size(); i++) {
      Optional<DepartamentoEntity> dpto1 = this.objDepartamentoRepository
          .findById(objDocenteEntity.getListaDepartamentos().get(i).getIdDepartamento());
      if (dpto1.isPresent()) {
        objDocenteEntity.getListaDepartamentos().get(i).setDescripcion(dpto1.get().getDescripcion());
        objDocenteEntity.getListaDepartamentos().get(i).setNombreDep(dpto1.get().getNombreDep());
      }else{ System.out.println("contador " + i);}
    }

    // agregar docente al telefono
    TelefonoEntity objTelefono = new TelefonoEntity();
    objTelefono = objDocenteEntity.getObjTelefono();
    objTelefono.setObjDocente(objDocenteEntity);
    objDocenteEntity.setObjTelefono(objTelefono);
    DocenteEntity objDocenteEntityR = this.objDocenteRepository.save(objDocenteEntity);
    Docente objDocenteResponse = this.docenteModelMapper.map(objDocenteEntityR, Docente.class);
    return objDocenteResponse;
  }

  @Override
  public Docente getDocente(Integer id) {

    Optional<DocenteEntity> objDocenteEntityR = this.objDocenteRepository.findById(id);
    Docente objDocenteEntityResponse = this.docenteModelMapper.map(objDocenteEntityR, Docente.class);
    return objDocenteEntityResponse;
  }

  @Override
  public boolean existDocenteForEmail(String correo) {
    return this.objDocenteRepository.existDocenteForEmail(correo) == 1;
  }

  @Override
  public Departamento getDepartamento(Integer id) {

    return null;
  }
}
