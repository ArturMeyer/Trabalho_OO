/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Financiamento extends TransacaoFinanceira {

    private float valorParcelas;
    private int duracao;

    public Financiamento(String nome, float valor, int duracao, float juros, int tipoJuros) {
        super(nome, valor, juros, tipoJuros);
        this.duracao = duracao;
        if (this.getTipoJuros() == 2) {
            this.valorParcelas = (this.getJuros() / (1 - (float) Math.pow((1 + this.getJuros()), -this.duracao))) * this.getValor();
        } else if (this.getTipoJuros() == 1) {
            this.valorParcelas = (this.getValor() * this.getJuros() + this.getValor())/ this.duracao;
        } else if (this.getTipoJuros() == 0) {
            this.valorParcelas = this.getValor()/this.duracao;
        }
    }

    @Override
    public float getTrasacao(int meses) {
        return -this.valorParcelas;
    }

    public float getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(float valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public int getDuracao() {
        return duracao;
    }


}
