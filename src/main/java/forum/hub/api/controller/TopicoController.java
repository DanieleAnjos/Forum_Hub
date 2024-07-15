package forum.hub.api.controller;

import forum.hub.api.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping("cadastrar")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopicos dados, UriComponentsBuilder uriBuilder) {
        Topico topico = new Topico(dados);
        repository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(DadosDetalhamentoTopico.fromTopico(topico));
    }

    @GetMapping("/topicos/list")
    public ResponseEntity<Page<DadosListagemTopico>> listarTopico(
            @PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {
        Page<Topico> topicosPage = repository.findAll(pageable);
        Page<DadosListagemTopico> dadosListagem = topicosPage.map(DadosListagemTopico::fromTopico);
        return ResponseEntity.ok(dadosListagem);
    }


    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> ResponseEntity.ok(DadosDetalhamentoTopico.fromTopico(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosCadastroTopicos dados) {
        return repository.findById(id)
                .map(topico -> {
                    topico.atualizarInformacoes(dados);
                    return ResponseEntity.ok(DadosDetalhamentoTopico.fromTopico(topico));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}