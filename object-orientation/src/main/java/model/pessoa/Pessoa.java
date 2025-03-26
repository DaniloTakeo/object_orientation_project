package model.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {
	
    protected String nome;
    protected String email;
    protected String senha;
    
}