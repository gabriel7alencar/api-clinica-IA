package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosDetalhadoPaciente(
    Long id,
    String nome,
    String email,
    String cpf,
    String telefone,
    Endereco endereco
) {
    public DadosDetalhadoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
