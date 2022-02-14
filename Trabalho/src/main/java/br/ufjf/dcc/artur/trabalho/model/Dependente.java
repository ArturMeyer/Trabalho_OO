/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Dependente implements UsuarioGastos{

    private String nome;
    private String codigo;
    private float mesada;
    private List<GastoRendaMensal> gastos = new ArrayList<>();

    public Dependente(String nome, String codigo, float Mesada, List<GastoRendaMensal> Gastos) {
        this.nome = nome;
        this.codigo = codigo;
        this.mesada = Mesada;
        this.gastos = Gastos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getMesada() {
        return mesada;
    }

    public void setMesada(float Mesada) {
        this.mesada = Mesada;
    }

    public List<GastoRendaMensal> getGastos() {
        return gastos;
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

    public float getGastoTotal() {
        float total = 0;
        try {
            total = this.getMesada();
            for (GastoRendaMensal elemento : this.gastos) {
                total += elemento.getValor();
            }
            return total;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void setGastos(List<GastoRendaMensal> gastos) {
        this.gastos = gastos;
    }

}
