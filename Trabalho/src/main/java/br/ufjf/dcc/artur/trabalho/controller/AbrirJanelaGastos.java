/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.view.JanelaGastos;
import br.ufjf.dcc.artur.trabalho.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class AbrirJanelaGastos implements ActionListener{
    
    private JanelaPrincipal janela;

    public AbrirJanelaGastos(JanelaPrincipal janela) {
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JanelaGastos janelaGastos = new JanelaGastos(this.janela, "Adicionar Gasto");
        janelaGastos.mostrar();
    }
    
}
