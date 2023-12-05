package devweb.example.market.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cliente {
    private Long id;
    private String C_nome;
    private String C_endereco;
    private int idade;
    private String telefone;
}

/*many-to-many com produto */