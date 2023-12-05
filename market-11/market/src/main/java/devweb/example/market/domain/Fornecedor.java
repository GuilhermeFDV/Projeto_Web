package devweb.example.market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fornecedor {
    private Long id;
    private String F_name;
}

/*one-to-many com produto */