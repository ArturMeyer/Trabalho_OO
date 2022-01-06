package br.ufjf.dcc.artur.trabalho;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Administrador {

    private String nome;
    private String senha;
    private float saldo;
    private List<GastoRendaMensal> gastos = new ArrayList<>();
    private List<GastoRendaMensal> rendas = new ArrayList<>();
    private List<Financiamento> financiamentos = new ArrayList<>();
    private Map<String, Dependente> dependentes = new HashMap<>();
    private Map<String, Funcionario> funcionarios = new HashMap<>();

    public Administrador(String nome, String senha, float saldo) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionarFinanciamento(String nome, float valor, int duracao, float juros, int tipoJuros, boolean negativo) {
        for (Financiamento elemento : this.financiamentos) {
            if (elemento.getNome().equals(nome)) {
                System.out.println("Nome já está em uso");
                return;
            }
        }
        Financiamento novoFinanciamento = new Financiamento(nome, valor, duracao, juros, tipoJuros, negativo);
        this.financiamentos.add(novoFinanciamento);
    }

    public void removerFinanciamento(String nome) {
        if (this.financiamentos.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        for (Financiamento elemento : this.financiamentos) {
            if (elemento.getNome().equals(nome)) {
                this.financiamentos.remove(elemento);
                return;
            }
        }
        System.out.println("Elemento não encontrado!");
    }

    public Financiamento getFinanciamento(String nome) {
        for (Financiamento elemento : this.financiamentos) {
            if (elemento.getNome().equals(nome)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public void adicionarRenda(String nome, float valor, int duracao) {
        for (GastoRendaMensal elemento : this.rendas) {
            if (elemento.getNome().equals(nome)) {
                System.out.println("Nome já está em uso");
                return;
            }
        }
        GastoRendaMensal novaRenda = new GastoRendaMensal(nome, valor, duracao);
        this.rendas.add(novaRenda);
    }

    public void removerRenda(String nome) {
        if (this.rendas.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        for (GastoRendaMensal elemento : this.gastos) {
            if (elemento.getNome().equals(nome)) {
                this.gastos.remove(elemento);
                return;
            }
        }
        System.out.println("Elemento não encontrado!");
    }

    public GastoRendaMensal getRenda(String nome) {
        for (GastoRendaMensal elemento : this.gastos) {
            if (elemento.getNome().equals(nome)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public void adicionarGasto(String nome, float valor, int duracao) {
        for (GastoRendaMensal elemento : this.gastos) {
            if (elemento.getNome().equals(nome)) {
                System.out.println("Nome já está em uso");
                return;
            }
        }
        GastoRendaMensal novaRenda = new GastoRendaMensal(nome, valor, duracao);
        this.gastos.add(novaRenda);
    }

    public void removerGasto(String nome) {
        if (this.gastos.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        for (GastoRendaMensal elemento : this.gastos) {
            if (elemento.getNome().equals(nome)) {
                this.gastos.remove(elemento);
                return;
            }
        }
        System.out.println("Elemento não encontrado!");
    }

    public GastoRendaMensal getGasto(String nome) {
        for (GastoRendaMensal elemento : this.gastos) {
            if (elemento.getNome().equals(nome)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public String adicionarFuncionario(String nome, float salario, int duracao) {
        Integer chave = 0;
        do {
            chave = (int) (Math.random() * 10000);
        } while (this.funcionarios.containsKey(chave.toString()));

        Funcionario novoFuncionario = new Funcionario(nome, chave.toString(), salario, duracao);
        this.funcionarios.put(chave.toString(), novoFuncionario);
        return chave.toString();
    }

    public void removerFuncionario(String nome) {
        if (this.funcionarios.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        for (String elemento : this.funcionarios.keySet()) {
            if (elemento.equals(nome)) {
                this.funcionarios.remove(elemento);
                return;
            }
        }
        System.out.println("Elemento não encontrado!");
    }

    public Funcionario getFuncionario(String nome) {
        for (Funcionario elemento : this.funcionarios.values()) {
            if (elemento.getNome().equals(nome)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public Funcionario getFuncionarioCodigo(String codigo) {
        for (Funcionario elemento : this.funcionarios.values()) {
            if (elemento.getCodigo().equals(codigo)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public String adicionarDependente(String nome, float mesada, List<GastoRendaMensal> gastos) {
        Integer chave = 0;
        do {
            chave = (int) (Math.random() * 10000 + 9999);
        } while (this.dependentes.containsKey(chave.toString()));

        Dependente novoDependente = new Dependente(nome, chave.toString(), mesada, gastos);
        this.dependentes.put(chave.toString(), novoDependente);
        return chave.toString();
    }

    public void removerDependentes(String nome) {
        if (this.dependentes.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        for (String elemento : this.dependentes.keySet()) {
            if (elemento.equals(nome)) {
                this.dependentes.remove(elemento);
                return;
            }
        }
        System.out.println("Elemento não encontrado!");
    }

    public Dependente getDependente(String nome) {
        for (String elemento : this.dependentes.keySet()) {
            if (elemento.equals(nome)) {
                return this.dependentes.get(elemento);
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public Dependente getDependenteCodigo(String codigo) {
        for (Dependente elemento : this.dependentes.values()) {
            if (elemento.getCodigo().equals(codigo)) {
                return elemento;
            }
        }
        System.out.println("Elemento não encontrado!");
        return null;
    }

    public float calcularSaldoFuturo(int meses) {

        float saldoFuturo = this.saldo;

        for (int i = 1; i <= meses; i++) {
            System.out.println("___________________________________________________________________");
            System.out.println("Mês " + i);
            for (Funcionario elemento : this.funcionarios.values()) {
                System.out.println("Tipo: Funcionário(a)"
                        + " | Nome: " + elemento.getNome()
                        + " | Código: " + elemento.getCodigo()
                        + " | Salário: R$ " + elemento.getSalario() + "\n");
                saldoFuturo = saldoFuturo - elemento.getSalario();
            }

            for (GastoRendaMensal elemento : this.rendas) {
                if (elemento.getDuracao() >= i) {
                    System.out.println("Tipo: Renda"
                            + " | Nome: " + elemento.getNome()
                            + " | Parcela: R$ " + elemento.getValor() + "\n");
                    saldoFuturo = saldoFuturo + elemento.getValor();
                }
            }

            for (GastoRendaMensal elemento : this.gastos) {
                if (elemento.getDuracao() >= i) {
                    System.out.println("Tipo: Gasto"
                            + " | Nome: " + elemento.getNome()
                            + " | Parcela: R$ " + elemento.getValor() + "\n");
                    saldoFuturo = saldoFuturo - elemento.getValor();
                }
            }

            for (Financiamento elemento : this.financiamentos) {
                if (elemento.getDuracao() >= i) {
                    System.out.println("Tipo: Financiamento"
                            + " | Nome: " + elemento.getNome()
                            + " | Valor: R$ " + elemento.getValor()
                            + " | Parcela: R$ " + elemento.getValorParcelas() + "\n");
                    if (elemento.isNegativo()) {
                        saldoFuturo = saldoFuturo - elemento.getValorParcelas();
                    } else {
                        saldoFuturo = saldoFuturo + elemento.getValorParcelas();
                    }
                }
            }

            for (Dependente elemento : this.dependentes.values()) {
                System.out.println("Tipo: Dependente"
                        + " | Nome: " + elemento.getNome()
                        + " | Código: " + elemento.getCodigo()
                        + " | Mesada: R$ " + elemento.getMesada() + "\n");
                saldoFuturo = saldoFuturo - elemento.getMesada();
            }

            for (Dependente elemento : this.dependentes.values()) {
                for (GastoRendaMensal gasto : elemento.getGastos()) {
                    if (gasto.getDuracao() >= i) {
                        System.out.println("Tipo: Gasto"
                                + " | Nome: " + gasto.getNome()
                                + " | Parcela: R$ " + gasto.getValor() + "\n");
                        saldoFuturo = saldoFuturo - gasto.getValor();
                    }
                }
            }
            System.out.println("Total: R$ " + saldoFuturo);
        }
        return saldoFuturo;
    }
    
    public float calcularTempoParaMeta(float meta) {

        float saldoFuturo = this.saldo;
        int meses = 1;
        while (saldoFuturo < meta) {
            System.out.println("___________________________________________________________________");
            System.out.println("Mês " + meses);
            for (Funcionario elemento : this.funcionarios.values()) {
                saldoFuturo = saldoFuturo - elemento.getSalario();
            }

            for (GastoRendaMensal elemento : this.rendas) {
                if (elemento.getDuracao() >= meses) {
                    saldoFuturo = saldoFuturo + elemento.getValor();
                }
            }

            for (GastoRendaMensal elemento : this.gastos) {
                if (elemento.getDuracao() >= meses) {
                    saldoFuturo = saldoFuturo - elemento.getValor();
                }
            }

            for (Financiamento elemento : this.financiamentos) {
                if (elemento.getDuracao() >= meses) {
                    if (elemento.isNegativo()) {
                        saldoFuturo = saldoFuturo - elemento.getValorParcelas();
                    } else {
                        saldoFuturo = saldoFuturo + elemento.getValorParcelas();
                    }
                }
            }

            for (Dependente elemento : this.dependentes.values()) {
                saldoFuturo = saldoFuturo - elemento.getMesada();
            }

            for (Dependente elemento : this.dependentes.values()) {
                for (GastoRendaMensal gasto : elemento.getGastos()) {
                    if (gasto.getDuracao() >= meses) {
                        saldoFuturo = saldoFuturo - gasto.getValor();
                    }
                }
            }
            System.out.println("Total: R$ " + saldoFuturo);
            meses++;
        }
        return saldoFuturo;
    }
}
