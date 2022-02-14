/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Funcionario {

    private String nome;
    private String codigo;
    private float salario;
    private int duracao;

    public Funcionario(String nome, String codigo, float salario, int duracao) {
        this.nome = nome;
        this.codigo = codigo;
        this.salario = salario;
        this.duracao = duracao;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    

}
