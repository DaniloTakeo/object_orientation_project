package model.curso;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Modulo {
	
    private String titulo;
    private List<Aula> aulas = new ArrayList<>();

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }
}