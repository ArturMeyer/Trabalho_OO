/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.model.Dependente;
import br.ufjf.dcc.artur.trabalho.model.Financiamento;
import br.ufjf.dcc.artur.trabalho.model.Funcionario;
import br.ufjf.dcc.artur.trabalho.model.GastoRendaMensal;
import br.ufjf.dcc.artur.trabalho.model.Investimento;
import br.ufjf.dcc.artur.trabalho.model.Mes;
import br.ufjf.dcc.artur.trabalho.view.JanelaCalculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class CalcularMeta implements ActionListener {

    private JanelaCalculos janelaSaldoFuturo;

    public CalcularMeta(JanelaCalculos janelaSaldoFuturo) {
        this.janelaSaldoFuturo = janelaSaldoFuturo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            DefaultTableModel tblModel = (DefaultTableModel) this.janelaSaldoFuturo.getTabelaMeses().getModel();
            tblModel.setRowCount(0);

            Administrador adm = this.janelaSaldoFuturo.getJanelaPrincipal().getAdm();

            this.janelaSaldoFuturo.getMeses().clear();

            float saldoFuturo = adm.getSaldo();

            int meta = Integer.parseInt(this.janelaSaldoFuturo.getTxtMeta().getText());

            if (meta < janelaSaldoFuturo.getJanelaPrincipal().getAdm().getSaldo()) {
                JOptionPane.showMessageDialog(janelaSaldoFuturo, "Você deve colocar uma meta maior do que o saldo", "Erro", 0);
                throw new Exception();
            }

            int i = 1;

            while (saldoFuturo < meta) {
                if (i == 5000) {
                    JOptionPane.showMessageDialog(janelaSaldoFuturo, "Meta muito difícil de se alcançar!", "Erro", 0);
                    break;
                }
                Mes mes = new Mes(i - 1);

                if (adm.getFuncionarios() != null) {
                    for (Funcionario elemento : adm.getFuncionarios().values()) {
                        mes.getDados().add("Tipo: Funcionário(a)"
                                + " | Nome: " + elemento.getNome()
                                + " | Código: " + elemento.getCodigo()
                                + " | Salário: R$ " + elemento.getSalario());
                        saldoFuturo = saldoFuturo - elemento.getSalario();
                    }
                }

                if (adm.getRendas() != null) {
                    for (GastoRendaMensal elemento : adm.getRendas()) {
                        if (elemento.getDuracao() >= i) {
                            mes.getDados().add("Tipo: Renda"
                                    + " | Nome: " + elemento.getNome()
                                    + " | Parcela: R$ " + elemento.getValor());
                            saldoFuturo = saldoFuturo + elemento.getValor();
                        }
                    }
                }

                if (adm.getGastos() != null) {
                    for (GastoRendaMensal elemento : adm.getGastos()) {
                        if (elemento.getDuracao() >= i) {
                            mes.getDados().add("Tipo: Gasto"
                                    + " | Nome: " + elemento.getNome()
                                    + " | Parcela: R$ " + elemento.getValor());
                            saldoFuturo = saldoFuturo - elemento.getValor();
                        }
                    }
                }

                if (adm.getFinanciamentos() != null) {
                    for (Financiamento elemento : adm.getFinanciamentos()) {
                        if (elemento.getDuracao() >= i) {
                            mes.getDados().add("Tipo: Financiamento"
                                    + " | Nome: " + elemento.getNome()
                                    + " | Valor: R$ " + elemento.getValor()
                                    + " | Parcela: R$ " + elemento.getValorParcelas());

                            saldoFuturo = saldoFuturo + elemento.getTrasacao(0);

                        }
                    }
                }

                if (adm.getInvestimentos() != null) {
                    for (Investimento elemento : adm.getInvestimentos()) {

                        mes.getDados().add("Tipo: Investimento"
                                + " | Nome: " + elemento.getNome()
                                + " | Valor Inicial: R$ " + elemento.getValor()
                                + " | Valor Futuro: R$ " + elemento.valorFuturo(i));

                        saldoFuturo = saldoFuturo + elemento.getTrasacao(i);
                    }
                }

                if (adm.getDependentes() != null) {
                    for (Dependente elemento : adm.getDependentes().values()) {
                        mes.getDados().add("Tipo: Dependente"
                                + " | Nome: " + elemento.getNome()
                                + " | Código: " + elemento.getCodigo()
                                + " | Mesada: R$ " + elemento.getMesada());
                        saldoFuturo = saldoFuturo - elemento.getMesada();
                    }

                    for (Dependente elemento : adm.getDependentes().values()) {
                        if (elemento.getGastos() != null) {
                            for (GastoRendaMensal gasto : elemento.getGastos()) {
                                if (gasto.getDuracao() >= i) {
                                    mes.getDados().add("Tipo: Gasto"
                                            + " | Nome: " + gasto.getNome()
                                            + " | Parcela: R$ " + gasto.getValor());
                                    saldoFuturo = saldoFuturo - gasto.getValor();
                                }
                            }
                        }
                    }
                    mes.getDados().add("Total: R$ " + saldoFuturo);
                    mes.setSaldo(saldoFuturo);
                    this.janelaSaldoFuturo.getMeses().put(i - 1, mes);
                    adicionaMesTabela(mes);
                    i++;
                }
            }

            this.janelaSaldoFuturo.getTabelaMeses().revalidate();

        } catch (Exception erro) {
            System.out.println(erro);
            JOptionPane.showMessageDialog(janelaSaldoFuturo, "Dado inválido", "Erro", 0);
        }
    }

    public void adicionaMesTabela(Mes mes) {
        DefaultTableModel tblModel = (DefaultTableModel) this.janelaSaldoFuturo.getTabelaMeses().getModel();

        String[] dados = {Integer.toString(mes.getNumero() + 1), "R$ " + Float.toString(mes.getSaldo())};

        tblModel.addRow(dados);

    }

}
