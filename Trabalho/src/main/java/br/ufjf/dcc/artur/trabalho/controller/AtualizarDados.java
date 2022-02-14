/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class AtualizarDados implements ActionListener {

    private JanelaPrincipal janela;

    public AtualizarDados(JanelaPrincipal janelaPrincipal) {
        this.janela = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            List<Administrador> admList = null;

            if (JSON.toAdminitradores(ArquivoController.lerArquivo()) != null) {
                admList = JSON.toAdminitradores(ArquivoController.lerArquivo());
            } else {
                admList = new ArrayList<>();
            }

            if (janela.getTxtNome().getText().equals("") || janela.getTxtSenha().getText().equals("")) {
                throw new Exception();
            }

            for (Administrador el : admList) {
                if (el.getNome().equals(janela.getAdm().getNome())) {
                    janela.getAdm().setNome(janela.getTxtNome().getText());
                    janela.getAdm().setSenha(janela.getTxtSenha().getText());
                    janela.getAdm().setSaldo(Float.parseFloat(janela.getTxtSaldo().getText()));
                    admList.set(admList.indexOf(el), janela.getAdm());
                }
            }

            ArquivoController.escreverArquivo(JSON.toJson(admList));

            JOptionPane.showMessageDialog(janela, "Informações foram salvas!", "Concluído", 1);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(janela, "Não foi possível salvar as informações!", "Erro", 0);
        }

    }

}
