/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import br.ufjf.dcc.artur.trabalho.controller.ArquivoController;
import br.ufjf.dcc.artur.trabalho.controller.JSON;
import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.controller.NovoAdministrador;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.List;
import br.ufjf.dcc.artur.trabalho.controller.LoginAdministrador;
import br.ufjf.dcc.artur.trabalho.controller.LoginDependente;
import br.ufjf.dcc.artur.trabalho.controller.LoginFuncionario;
import javax.swing.JMenuBar;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Janela extends JFrame {

    private JTabbedPane tabPainel;

    private JTextField nomeLogin;
    private JTextField senhaLogin;
    private JTextField nomeCadastro;
    private JTextField senhaCadastro;
    private JTextField codigoDependente;
    private JTextField codigoFuncionario;

    public Janela() {
        super("Organizador Financeiro");
    }

    public void mostrar() {
        
        this.setSize(700, 150);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(500, 500);

        tabPainel = new JTabbedPane();
        
        this.add(tabPainel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.mostrarLogin();

        this.mostrarCadastro();

        this.mostrarDependenteLogin();

        this.mostrarFuncionarioLogin();

    }

    public void mostrarLogin() {

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new GridLayout(0, 1));

        tabPainel.add("Login", painelLogin);

        JLabel nome = new JLabel("Nome: ");
        JLabel senha = new JLabel("Senha: ");
        nomeLogin = new JTextField(20);
        senhaLogin = new JTextField(20);

        JPanel painelNome = new JPanel();
        painelNome.setLayout(new GridLayout(0, 2));
        JPanel painelSenha = new JPanel();
        painelSenha.setLayout(new GridLayout(0, 2));

        painelNome.add(nome);
        painelNome.add(nomeLogin);
        painelLogin.add(painelNome);

        painelSenha.add(senha);
        painelSenha.add(senhaLogin);
        painelLogin.add(painelSenha);

        JPanel painelBotao = new JPanel();
        painelBotao.setLayout(new GridLayout(1, 0));

        JButton botaoLogin = new JButton("Entrar");
        
        botaoLogin.addActionListener(new LoginAdministrador(this));

        painelLogin.add(painelBotao);

        painelBotao.add(botaoLogin);

    }

    public void mostrarCadastro() {

        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(0, 1));

        tabPainel.add("Cadastro", painelCadastro);

        JLabel nome = new JLabel("Nome: ");
        JLabel senha = new JLabel("Senha: ");
        nomeCadastro = new JTextField(20);
        senhaCadastro = new JTextField(20);

        JPanel painelNome = new JPanel();
        painelNome.setLayout(new GridLayout(0, 2));
        JPanel painelSenha = new JPanel();
        painelSenha.setLayout(new GridLayout(0, 2));

        painelNome.add(nome);
        painelNome.add(nomeCadastro);
        painelCadastro.add(painelNome);

        painelSenha.add(senha);
        painelSenha.add(senhaCadastro);
        painelCadastro.add(painelSenha);

        JButton botaoCadastro = new JButton("Cadastrar");
        
        botaoCadastro.addActionListener(new NovoAdministrador(this));

        painelCadastro.add(botaoCadastro);

    }

    public void mostrarFuncionarioLogin() {

        JPanel painelFuncionario = new JPanel();
        painelFuncionario.setLayout(new GridLayout(0, 1));
        painelFuncionario.setMaximumSize(new Dimension(300, 300));

        tabPainel.add("Funcionário", painelFuncionario);

        JLabel codigo = new JLabel("Código: ");
        codigoFuncionario = new JTextField(50);

        JPanel painelCodigo = new JPanel();
        painelCodigo.setLayout(new GridLayout(0, 2));
        JPanel painelSenha = new JPanel();
        painelSenha.setLayout(new GridLayout(0, 2));

        painelCodigo.add(codigo);
        painelCodigo.add(codigoFuncionario);
        painelFuncionario.add(painelCodigo);

        JPanel painelBotao = new JPanel();
        painelBotao.setLayout(new GridLayout(1, 0));

        JButton botaoCadastro = new JButton("Entrar");
        botaoCadastro.addActionListener(new LoginFuncionario(this));

        painelFuncionario.add(painelBotao);

        painelBotao.add(botaoCadastro);

    }

    public void mostrarDependenteLogin() {

        JPanel painelDependente = new JPanel();
        painelDependente.setLayout(new GridLayout(0, 1));

        tabPainel.add("Depedente", painelDependente);

        JLabel codigo = new JLabel("Código: ");
        codigoDependente = new JTextField(20);

        JPanel painelCodigo = new JPanel();
        painelCodigo.setLayout(new GridLayout(0, 2));
        JPanel painelSenha = new JPanel();
        painelSenha.setLayout(new GridLayout(0, 2));

        painelCodigo.add(codigo);
        painelCodigo.add(codigoDependente);
        painelDependente.add(painelCodigo);

        JPanel painelBotao = new JPanel();
        painelBotao.setLayout(new GridLayout(1, 0));

        JButton botaoCadastro = new JButton("Entrar");
        botaoCadastro.addActionListener(new LoginDependente(this));
        
        painelDependente.add(painelBotao);

        painelBotao.add(botaoCadastro);

    }

    public static void main(String[] args) {
        Janela janela = new Janela();

        janela.mostrar();

    }

    public JTabbedPane getTabPainel() {
        return tabPainel;
    }

    public JTextField getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin.setText(nomeLogin);
    }

    public JTextField getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(JTextField senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public JTextField getNomeCadastro() {
        return nomeCadastro;
    }

    public void setNomeCadastro(String nomeCadastro) {
        this.nomeCadastro.setText(nomeCadastro);
    }

    public JTextField getSenhaCadastro() {
        return senhaCadastro;
    }

    public void setSenhaCadastro(String senhaCadastro) {
        this.senhaCadastro.setText(senhaCadastro);
    }

    public JTextField getCodigoDependente() {
        return codigoDependente;
    }

    public void setCodigoDependente(String codigoDependente) {
        this.codigoDependente.setText(codigoDependente);
    }

    public JTextField getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario.setText(codigoFuncionario);
    }

}
