package model.pagamento;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoCartao extends Pagamento implements PagamentoService {
    private String bandeira;
    
    @Override
    public boolean pagar(BigDecimal valor) {
        return super.pagar(valor);
    }
    
    @Override
    public PagamentoStatus consultarStatus(Pagamento pagamento) {
        return pagamento.consultarStatus();
    }
    
    public boolean validarCartao(String numeroCartao) {
        return numeroCartao.length() == 16;
    }
    
    public boolean autorizar() {
        return true;
    }
}