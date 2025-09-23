package med.voll.api.consulta;

public record DadosListagemConsulta(Long id, String nome, int cpf, String email, String telefone) {
      
    public DadosListagemConsulta(Consulta consulta) {
        this(consulta.getId(), 
        consulta.getNome(), 
        consulta.getCpf(), 
        consulta.getEmail(), 
        consulta.getTelefone());
    }
    
} 