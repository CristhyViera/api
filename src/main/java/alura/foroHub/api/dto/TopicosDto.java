package alura.foroHub.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicosDto(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
