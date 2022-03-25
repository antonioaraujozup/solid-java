package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteSalarial {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteSalarial(List<ValidacaoReajuste> validacoes){
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        this.validacoes.forEach(v -> v.validar(funcionario,aumento));
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal novoSalario = salarioAtual.add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }

}
