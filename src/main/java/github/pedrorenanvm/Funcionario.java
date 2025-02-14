package github.pedrorenanvm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;


    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdade(){
        return LocalDate.now().getYear() - getDataNascimento().getYear();
    }
    public String formartarSalario(BigDecimal valor){
        DecimalFormat formato = new DecimalFormat("#,###.00");
        return formato.format(valor);
    }

    public void aumentarSalario(double percentual){
        this.salario = this.salario.multiply(BigDecimal.valueOf(1 + percentual / 100));
        // consigo receber o valor do aumento, e multiplicar pelo valor do salario resultando no novo salario do funcionario
    }

    public BigDecimal calcularSalariosMinimosPorFuncionario(){
        return this.getSalario().divide(new BigDecimal("1212.00"),2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "nome: " + super.getNome() +
                ", data de nascimento: " + converterLocalDateParaString(super.getDataNascimento()) +
                ", salário: " + this.formartarSalario(salario) +
                ", funcao='" + funcao;
    }
}
