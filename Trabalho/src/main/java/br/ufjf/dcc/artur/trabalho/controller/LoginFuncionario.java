/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.model.Dependente;
import br.ufjf.dcc.artur.trabalho.model.Funcionario;
import br.ufjf.dcc.artur.trabalho.view.Janela;
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
public class LoginFuncionario implements ActionListener{
    
    private Janela janela;

    public LoginFuncionario(Janela janela) {
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
                    for (Funcionario func : el.getFuncionarios().values()) {
                        if (func.getCodigo().equals(janela.getCodigoFuncionario().getText())) {
                            JOptionPane.showMessageDialog(janela, "Login relizado com sucesso!", "Concluído", 1);
                            JanelaPrincipal jP = new JanelaPrincipal(el, func);
                            jP.mostrar();
                            janela.setVisible(false);
                            return;
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(janela, "Código inválido!", "Erro", 0);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(janela, "Não foi possível concluir o cadastro", "Erro", 2);
        }
        
    }
    
}
