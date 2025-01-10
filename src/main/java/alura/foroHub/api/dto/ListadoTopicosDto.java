package alura.foroHub.api.dto;

import alura.foroHub.api.model.Topicos;
import jakarta.validation.constraints.NotBlank;

public record ListadoTopicosDto(

                                Long id,
                                @NotBlank
                                String titulo,
                                @NotBlank
                                String mensaje,
                                @NotBlank
                                String autor,
                                @NotBlank
                                String curso) {

    public ListadoTopicosDto(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensaje(), topicos.getAutor(), topicos.getCurso());
    }
}
