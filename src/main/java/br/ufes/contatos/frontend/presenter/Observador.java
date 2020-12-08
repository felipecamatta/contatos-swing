/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public abstract class Observador {
    
    private List<Observado> observados;

    public Observador() {
        this.observados = new ArrayList<>();
    }
    
    public void addObservado(Observado o){
        this.observados.add(o);
        
    }
    
    public abstract void atualizar();
    
}
