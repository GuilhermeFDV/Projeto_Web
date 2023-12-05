package devweb.example.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import devweb.example.market.domain.Fornecedor;

@Service
public class FornecedorService {
    private static List<Fornecedor> fornecedores;

    static{
        fornecedores = new ArrayList<>(List.of(new Fornecedor(1L,"Temperos&Cia"),new Fornecedor(2L, "Lider distribuidora")));
    }

    public List<Fornecedor> listAll(){
        return fornecedores;
    }

    public Fornecedor findById(long id){
        return fornecedores.stream()
            .filter(fornecedor ->fornecedor.getId().equals(id))
            .findFirst()
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Fornecedor não encontrado"));
    }

    public Fornecedor save (Fornecedor fornecedor){
        fornecedor.setId(ThreadLocalRandom.current().nextLong(3,1000000000));
        fornecedores.add(fornecedor);
        return fornecedor;

    }

    public void delete(long id) {
        fornecedores.remove(findById(id));
    }

    public void replace(Fornecedor fornecedor) {
        delete(fornecedor.getId());
        fornecedores.add(fornecedor);
    }
}
