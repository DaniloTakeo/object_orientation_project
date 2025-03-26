package model.pessoa;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.curso.Curso;
import model.pagamento.Pagamento;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Aluno extends Pessoa {
	
	private String matricula;
    private List<Curso> listaDeCursos;
    private List<Pagamento> pagamentos;

    public void inscreverNoCurso(Curso curso) {
        if (listaDeCursos == null) {
            listaDeCursos = new ArrayList<>();
        }
        listaDeCursos.add(curso);
    }

    public List<Pagamento> obterPagamentos() {
        return pagamentos;
    }

    public List<Curso> listarCursos() {
        return listaDeCursos;
    }
  
}