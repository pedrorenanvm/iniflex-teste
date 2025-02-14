package github.pedrorenanvm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static github.pedrorenanvm.Pessoa.converterStringParaLocalDate;

public class Main {

    public static List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Maria", converterStringParaLocalDate("18/10/2000"), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", converterStringParaLocalDate("12/05/1990"), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", converterStringParaLocalDate("02/05/1961"), new BigDecimal("9836"), "Coodenador"),
            new Funcionario("Miguel", converterStringParaLocalDate("14/10/1998"), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", converterStringParaLocalDate("05/01/1995"), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", converterStringParaLocalDate("19/11/1999"), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", converterStringParaLocalDate("31/03/1993"), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", converterStringParaLocalDate("08/07/1994"), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", converterStringParaLocalDate("24/05/2003"), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", converterStringParaLocalDate("02/09/1996"), new BigDecimal("2799.93"), "Gerente")
    ));

    public static void main(String[] args) {

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.


        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.removeIf(funcionario -> funcionario.equals(funcionario.getNome() == "João"));

        //3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        //• informação de data deve ser exibido no formato dd/mm/aaaa;
        //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        imprimirFuncionairosDaLista();

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        System.out.println("");
        System.out.println("Funcionarios após o aumento de 10%: ");
        aumentarSalarioEmPorcentagem(10.0);
        imprimirFuncionairosDaLista();


        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        agruparFuncionariosPorMap();

        //3.6 – Imprimir os funcionários, agrupados por função.
        imprimirFuncionariosPorFuncaoMap();


    }
    public static void imprimirFuncionairosDaLista ( ) {
        funcionarios.forEach(System.out::println); // mesmo que usar funcionario -> System.out.println(funcionario
    }

    public static void aumentarSalarioEmPorcentagem (Double percentual){
        funcionarios.forEach( f -> f.aumentarSalario(percentual));
    }

    public static Map<String, List<Funcionario>> agruparFuncionariosPorMap() {
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy( funcionario -> funcionario.getFuncao()));

        return funcionariosPorFuncao;
    }

    public static void imprimirFuncionariosPorFuncaoMap (){
        agruparFuncionariosPorMap().forEach((funcao, lista ) -> {
            System.out.println("\nFunção: "+funcao);
            lista.forEach(System.out::println); // mesmo que fazer funcionario -> System.out.println(funcionario)
        });
    }

}