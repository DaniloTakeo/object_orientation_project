package model.curso;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modulo {
    private String titulo;
    private List<Aula> aulas;

     public void adicionarAula(Aula aula) {
        if(aulas == null){
            aulas = new ArrayList<>();
        }
        aulas.add(aula);
    }
}