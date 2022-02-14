/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public abstract class TransacaoFinanceira {

    private String nome;
    private float valor;
    private float juros;
    private int tipoJuros;
    

    public TransacaoFinanceira(String nome, float valor, float juros, int tipoJuros) {
        this.nome = nome;
        this.valor = valor;
        this.juros = juros / 100;
        this.tipoJuros = tipoJuros;
    }
    
    public abstract float getTrasacao(int meses);
    
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

}
