package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        DadosEndereco endereco,
        Boolean ativo) {
}
