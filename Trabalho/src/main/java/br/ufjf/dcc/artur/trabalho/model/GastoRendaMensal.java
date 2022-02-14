/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class GastoRendaMensal {
    
    private String nome;
    private float valor;
    private int duracao;
    
    public GastoRendaMensal(String nome, float valor, int duracao) {
        this.nome = nome;
        this.valor = valor;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
