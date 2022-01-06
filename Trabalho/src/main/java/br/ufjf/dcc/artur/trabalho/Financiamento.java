/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Financiamento {

    private String nome;
    private float valor;
    private int duracao;
    private float juros;
    private int tipoJuros;
    private float valorParcelas;
    private boolean negativo;

    public Financiamento(String nome, float valor, int duracao, float juros, int tipoJuros, boolean negativo) {
        this.nome = nome;
        this.valor = valor;
        this.duracao = duracao;
        this.juros = juros / 100;
        this.tipoJuros = tipoJuros;
        this.negativo = negativo;
        if (this.tipoJuros == 2) {
            this.valorParcelas = (this.juros / (1 - (float) Math.pow((1 + this.juros), -this.duracao))) * this.valor;
        } else if (this.tipoJuros == 1) {
            this.valorParcelas = (this.valor * this.juros + this.valor)/ this.duracao;
        } else if (this.tipoJuros == 0) {
            this.valorParcelas = this.valor/this.duracao;
        }
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

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public int getTipoJuros() {
        return tipoJuros;
    }

    public void setTipoJuros(int tipoJuros) {
        this.tipoJuros = tipoJuros;
    }

    public float getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(float valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public boolean isNegativo() {
        return negativo;
    }

    public void setNegativo(boolean negativo) {
        this.negativo = negativo;
    }
    

}
