package med.voll.api.consulta;

import med.voll.api.endereco.Endereco;

public record DadosDetalhadoConsulta(
    Long id,
    String nome,
    int cpf,
    String email,
    String telefone,
    Endereco endereco
) {
    public DadosDetalhadoConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getNome(), consulta.getCpf(), consulta.getEmail(), consulta.getTelefone(), consulta.getEndereco());
    }
    
}