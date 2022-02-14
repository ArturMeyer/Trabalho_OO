/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import com.google.gson.Gson;
import br.ufjf.dcc.artur.trabalho.model.Administrador;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class JSON {

    public static String toJson(Administrador adm) {
        Gson gson = new Gson();
        return gson.toJson(adm);
    }
    
    public static String toJson(List<Administrador> adm) {
        Gson gson = new Gson();
        return gson.toJson(adm);
    }

    public static Administrador toAdministrador(String json) {
        Gson gson = new Gson();
        Administrador contato = gson.fromJson(json, Administrador.class);
        return contato;
    }

    public static List<Administrador> toAdminitradores(String json) {
        Gson gson = new Gson();
        Type tipoAdministrador = new TypeToken<ArrayList<Administrador>>(){}.getType();
        List<Administrador> administradores = gson.fromJson(json, tipoAdministrador);
        return administradores;
    }

}
