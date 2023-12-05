package devweb.example.market.repository;

import java.util.List;

import devweb.example.market.domain.Fornecedor;

public interface FornecedorRepository {  
    public List<Fornecedor> listAll();
}