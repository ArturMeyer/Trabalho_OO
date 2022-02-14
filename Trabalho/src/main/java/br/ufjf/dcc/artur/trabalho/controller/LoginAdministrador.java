/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.ufjf.dcc.artur.trabalho.view.Janela;
import br.ufjf.dcc.artur.trabalho.view.JanelaPrincipal;
import br.ufjf.dcc.artur.trabalho.controller.ArquivoController;
import br.ufjf.dcc.artur.trabalho.controller.JSON;
import br.ufjf.dcc.artur.trabalho.model.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import jdk.internal.agent.Agent;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class LoginAdministrador implements ActionListener {

    private Janela janela;

    public LoginAdministrador(Janela janela) {
        this.janela = janela;
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

            if (admList != null) {

                for (Administrador el : admList) {
                    if (el.getNome().equals(janela.getNomeLogin().getText().trim())) {
                        if (el.getSenha().equals(janela.getSenhaLogin().getText())) {
                            JOptionPane.showMessageDialog(janela, "Login relizado com sucesso!", "Concluído", 1);
                            JanelaPrincipal jP = new JanelaPrincipal(el);
                            jP.mostrar();
                            janela.setVisible(false);
                            return;
                        }
                    }
                }
            }
            
            JOptionPane.showMessageDialog(janela, "Nome e/ou senha inválidos!", "Erro", 0);

        } catch (Exception ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(janela, "Não foi possível concluir o login", "Erro", 2);
        }
    }

}
