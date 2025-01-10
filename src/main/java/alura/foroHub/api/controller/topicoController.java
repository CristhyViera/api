package alura.foroHub.api.controller;

import alura.foroHub.api.dto.DatosUpdateTopicosDto;
import alura.foroHub.api.dto.ListadoTopicosDto;
import alura.foroHub.api.dto.TopicosDto;
import alura.foroHub.api.model.Topicos;
import alura.foroHub.api.repository.TopicosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class topicoController{

    @Autowired
    private TopicosRepository topicosRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid TopicosDto topicosDto){
        topicosRepository.save(new Topicos(topicosDto));

    }
    //Retorna una lista de los topicos
    @GetMapping
    public Page<ListadoTopicosDto> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion){
        return topicosRepository.findByStatusTrue(paginacion).map(ListadoTopicosDto::new);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosUpdateTopicosDto datosUpdateTopicosDto){
        Topicos topicos = topicosRepository.getReferenceById(datosUpdateTopicosDto.Id());
        topicos.actualizarDatosTopicos(datosUpdateTopicosDto);
    }
//Delete lógico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topicos topicos = topicosRepository.getReferenceById(id);
        topicos.desactivarTopico();
    }
}
