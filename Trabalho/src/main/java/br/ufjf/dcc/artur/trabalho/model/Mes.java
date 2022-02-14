/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.model;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class Mes {

    private int numero;
    private float saldo;
    private List<String> dados;

    public Mes(int numero) {
        this.numero = numero;
        dados = new ArrayList<>();
    }

    public void verDados() {
        JFrame frmDados = new JFrame("Mês " + (numero + 1));
        
        JPanel pnl = new JPanel();

        List<JLabel> lblList = new ArrayList<>();
        
        pnl.setLayout(new GridLayout(dados.size(), 0));

        for (String el : dados) {
            
            JLabel lbl = new JLabel(el);
            lbl.setBorder(BorderFactory.createBevelBorder(1));
            pnl.add(lbl);
        }
        
        frmDados.add(pnl);
        frmDados.pack();
        frmDados.setVisible(true);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<String> getDados() {
        return dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
