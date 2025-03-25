package model.pessoa;

import lombok.Data;

@Data
public abstract class Pessoa {
	
    protected String nome;
    protected String email;
    protected String senha;
}