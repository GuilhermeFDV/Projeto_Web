package devweb.example.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import devweb.example.market.domain.Cliente;


@Service
public class ClienteService {
    private static List<Cliente> clientes;

    static{
        clientes = new ArrayList<>(List.of(new Cliente(1L,"Guilherme Falcão","Av.Luis Eduardo",21,"77999999999"),new Cliente(2L, "Marcos Prado","Av.Olivia Flores",36,"77 999999998")));
    }

    public List<Cliente> listAll(){
        return clientes;
    }

    public Cliente findById(long id){
        return clientes.stream()
            .filter(cliente ->cliente.getId().equals(id))
            .findFirst()
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente não encontrado"));
    }

    public Cliente save (Cliente cliente){
        cliente.setId(ThreadLocalRandom.current().nextLong(3,1000000000));
        clientes.add(cliente);
        return cliente;

    }

    public void delete(long id) {
        clientes.remove(findById(id));
    }

    public void replace(Cliente cliente) {
        delete(cliente.getId());
        clientes.add(cliente);
    }
}
