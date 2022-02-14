/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

import java.util.List;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public interface UsuarioGastos {
    
    public void adicionarGasto(String nome, float valor, int duracao);
    
    public void removerGasto(String nome);
    
    public GastoRendaMensal getGasto(String nome);
    
    public float getGastoTotal();
    
     public List<GastoRendaMensal> getGastos();
    
}
