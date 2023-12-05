package devweb.example.market.repository;

import java.util.List;

import devweb.example.market.domain.Produto;

public interface ProdutoRepository {
    public List<Produto> listAll();
}
