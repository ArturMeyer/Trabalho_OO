/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

/**
 *
 * @author T-Gamer
 */
public class Investimento extends TransacaoFinanceira {

    public Investimento(String nome, float valor, float juros, int tipoJuros) {
        super(nome, valor, juros, tipoJuros);
    }

    public float valorFuturo(int meses) {
        if (this.getTipoJuros() == 2) {
            return (float) (this.getValor() * (Math.pow((double) (1 + this.getJuros()), meses)) - this.getValor());
        } else if (this.getTipoJuros() == 1) {
            return (this.getValor() * this.getJuros()) * meses;
        }
        return 0;
    }

    @Override
    public float getTrasacao(int meses) {
        return this.valorFuturo(meses);
    }

}
