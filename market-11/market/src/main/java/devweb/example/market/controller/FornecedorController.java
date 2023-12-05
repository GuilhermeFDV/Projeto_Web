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

import devweb.example.market.domain.Fornecedor;
import devweb.example.market.service.FornecedorService;
import devweb.example.market.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("fornecedores")
@Log4j2
@RequiredArgsConstructor
public class FornecedorController {
    private final DateUtil dateUtil;
    private final FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(fornecedorService.listAll(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable long id){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(fornecedorService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody Fornecedor fornecedor){
        return new  ResponseEntity<>(fornecedorService.save(fornecedor),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        fornecedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Fornecedor fornecedor){
        fornecedorService.replace(fornecedor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
