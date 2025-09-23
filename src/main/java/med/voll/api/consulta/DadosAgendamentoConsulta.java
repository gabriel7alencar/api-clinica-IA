package med.voll.api.consulta;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;


public record DadosAgendamentoConsulta (
        @NotNull
        int id,
        @NotBlank
        String nome,
        @CPF
        int cpf,
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull 
        @Valid 
        DadosEndereco endereco,
        @NotNull
        String especialidade
) {  

}