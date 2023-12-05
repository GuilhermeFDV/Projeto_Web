package devweb.example.market.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Produto {
    private Long id;
    private String name;
    private String descricao;
    private int preco_kg;
    private int estoque;
}

/*many-to-one com fornecedor
 * many-to-many com cliente
 */