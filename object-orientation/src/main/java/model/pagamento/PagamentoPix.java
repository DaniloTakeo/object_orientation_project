package model.pagamento;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PagamentoPix extends Pagamento implements PagamentoService {
    private int tempoExpiracao;
    
    @Override
    public boolean pagar(BigDecimal valor) {
        return super.pagar(valor);
    }
    
    @Override
    public PagamentoStatus consultarStatus(Pagamento pagamento) {
        return pagamento.consultarStatus();
    }
    
    public String gerarQrCode() {
        return "QR_CODE_123456";
    }
    
    public boolean validarExpiracao() {
        return tempoExpiracao > 0;
    }
}