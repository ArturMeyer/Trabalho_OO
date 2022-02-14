/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class ArquivoController {

    private final static String caminhoArquivo = "dados.txt";

    public static String lerArquivo() throws FileNotFoundException, IOException {

        StringBuilder textoArquivo = new StringBuilder();

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        Scanner scannerArquivo = new Scanner(arquivo);

        while (scannerArquivo.hasNextLine()) {
            textoArquivo.append(scannerArquivo.nextLine()).append("\n");
        }

        return textoArquivo.toString();
    }

    public static void escreverArquivo(String texto) throws IOException {

        File arquivo = new File(caminhoArquivo);

        FileWriter arquivoEscrita = new FileWriter(arquivo, false);

        BufferedWriter bufferArquivo = new BufferedWriter(arquivoEscrita);

        bufferArquivo.write(texto);

        bufferArquivo.close();
        arquivoEscrita.close();

    }

}
