package devweb.example.market.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devweb.example.market.domain.Cliente;
import devweb.example.market.service.ClienteService;
import devweb.example.market.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("clientes")
@Log4j2
@RequiredArgsConstructor

public class ClienteController {
    private final DateUtil dateUtil;
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(clienteService.listAll(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(clienteService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return new  ResponseEntity<>(clienteService.save(cliente),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Cliente cliente){
        clienteService.replace(cliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
