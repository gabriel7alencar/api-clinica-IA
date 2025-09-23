package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.consulta.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados, UriComponentsBuilder uriBuilder) {
        var consulta = new Consulta(dados);
        repository.save(consulta);
        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadoConsulta(consulta));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemConsulta>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemConsulta::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConsulta dados) {
        var consulta = repository.getReferenceById(dados.id());
        consulta.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadoConsulta(consulta));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelar(@PathVariable Long id) {
        var consulta = repository.getReferenceById(id);
        consulta.cancelar();
        // Resposta: 204 No Content - requisição foi processada e sem conteúdo para retornar
        //exercício teste
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var consulta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadoConsulta(consulta));
    }

    
}