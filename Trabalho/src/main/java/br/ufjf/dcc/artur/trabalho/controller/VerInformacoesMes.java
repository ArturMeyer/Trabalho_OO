/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.view.JanelaCalculos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class VerInformacoesMes implements MouseListener{
    
    private JanelaCalculos janelaSaldoFuturo;

    public VerInformacoesMes(JanelaCalculos janelaSaldoFuturo) {
        this.janelaSaldoFuturo = janelaSaldoFuturo;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            
            int indice = janelaSaldoFuturo.getTabelaMeses().getSelectedRow();
            
            janelaSaldoFuturo.getMeses().get(indice).verDados();
            
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    
}
