package model.pagamento;

import java.math.BigDecimal;

import lombok.Data;

@Data
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