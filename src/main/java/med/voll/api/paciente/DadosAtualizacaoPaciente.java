package med.voll.api.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        String cpf,
        DadosEndereco endereco,
        Boolean ativo) {

}
