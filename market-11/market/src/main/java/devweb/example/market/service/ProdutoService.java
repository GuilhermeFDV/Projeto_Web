package devweb.example.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import devweb.example.market.domain.Produto;

@Service
@Entity
public class ProdutoService {
    private static List<Produto> produtos;

    static{
        produtos = new ArrayList<>(List.of(new Produto(1L,"pimenta","pimenta",10,60),new Produto(2l, "oregano", "tempero", 10, 60)));
    }

    public List<Produto> listAll(){
        return produtos;
    }

    public Produto findById(long id){
        return produtos.stream()
            .filter(produto ->produto.getId().equals(id))
            .findFirst()
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Produto não encontrado"));
    }

    public Produto save (Produto produto){
        produto.setId(ThreadLocalRandom.current().nextLong(3,1000000000));
        produtos.add(produto);
        return produto;

    }

    public void delete(long id) {
        produtos.remove(findById(id));
    }

    public void replace(Produto produto) {
        delete(produto.getId());
        produtos.add(produto);
    }
}
