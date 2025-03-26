package model.pagamento;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.curso.Curso;
import model.pessoa.Aluno;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pagamento {
    
	private BigDecimal valor;
    private Aluno aluno;
    private Curso curso;
    private PagamentoStatus status;
    
    public boolean pagar(BigDecimal valor) {
        this.valor = valor;
        this.status = PagamentoStatus.PAGO;
        return true;
    }
    
    public PagamentoStatus consultarStatus() {
        return status;
    }
    
    public void cancelar() {
        this.status = PagamentoStatus.CANCELADO;
    }
    
    public void reembolsar() {
        this.status = PagamentoStatus.PENDENTE;
    }
}