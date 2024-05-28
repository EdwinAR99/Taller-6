package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.Taller6.application.output.managementGateway.RespuestaManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.entities.RespuestaEntity;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.ICuestionarioRepository;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IDocenteRepository;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IPreguntaRepository;
import co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.repositories.IRespuestaRepository;
import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RespuestaMangementGatewayImplAdapter implements RespuestaManagementGatewayIntPort {

    private final IRespuestaRepository respuestaRepository;
    private final ModelMapper respuestaMapper;

    private final IDocenteRepository docenteRepository;
    private final ICuestionarioRepository cuestionarioRepository;
    private final IPreguntaRepository preguntaRepository;

    public RespuestaMangementGatewayImplAdapter(
            IRespuestaRepository respuestaRepository,
            @Qualifier("createRespuestaMapper") ModelMapper respuestaMapper,
            IDocenteRepository docenteRepository, ICuestionarioRepository cuestionarioRepository,
            IPreguntaRepository preguntaRepository) {
        this.respuestaMapper = respuestaMapper;
        this.respuestaRepository = respuestaRepository;
        this.docenteRepository = docenteRepository;
        this.cuestionarioRepository = cuestionarioRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<Respuesta> guardarRespuestas(List<Respuesta> objRespuestas) {
        System.out.println("\u001B[31mProcediendo a guardar respuestas\u001B[0m");
        List<Respuesta> listaRespuestasGuardadas = new ArrayList<>();

        for (Respuesta respuesta : objRespuestas) {
            RespuestaEntity respuestaEntity = this.respuestaMapper.map(respuesta, RespuestaEntity.class);

            Optional<PreguntaEntity> preguntaEntityAux = this.preguntaRepository
                    .findById(respuesta.getObjPregunta().getIdPregunta());
            if (preguntaEntityAux.isEmpty()) {
                throw new EntityNotFoundException(
                        "Pregunta not found with ID: " + respuesta.getObjPregunta().getIdPregunta());
            }
            PreguntaEntity preguntaEntity = preguntaEntityAux.get();
            respuestaEntity.setObjPregunta(preguntaEntity);
            preguntaEntity.getListaRespuestas().add(respuestaEntity);

            Optional<DocenteEntity> docenteEntityAux = this.docenteRepository
                    .findById(respuesta.getObjPersona().getIdPersona());
            if (docenteEntityAux.isEmpty()) {
                throw new EntityNotFoundException(
                        "Docente not found with ID: " + respuesta.getObjPersona().getIdPersona());
            }
            DocenteEntity docenteEntity = docenteEntityAux.get();
            respuestaEntity.setObjPersona(docenteEntity);
            docenteEntity.addRespuesta(respuestaEntity);

            RespuestaEntity RespuestaEntity = this.respuestaRepository.save(respuestaEntity);
            Respuesta savedRespuesta = this.respuestaMapper.map(RespuestaEntity, Respuesta.class);

            listaRespuestasGuardadas.add(savedRespuesta);
        }

        return listaRespuestasGuardadas;
    }

    @Override
    public List<Respuesta> listar() {
        Iterable<RespuestaEntity> lista = this.respuestaRepository.findAll();
        List<Respuesta> listaObtenida = this.respuestaMapper.map(lista, new TypeToken<List<Respuesta>>() {
        }.getType());

        return listaObtenida;
    }

    @Override
    public boolean returnResponseErrorIdDocenteNoExiste(int id) {
        return !this.docenteRepository.existsById(id);
    }

    @Override
    public boolean returnResponseErrorIdCuestionarioNoExiste(int id) {
       return !this.cuestionarioRepository.existsById(id);
    }

    @Override
    public boolean returnResponseErrorIdPreguntaNoExiste(int id) {
        return !this.preguntaRepository.existsById(id);
    }

}
