/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter;

/**
 *
 * @author gabriel
 */
public abstract class Observado {
    
    private Observador observador;

    public Observado() {
    }
    
    public void update(){
        this.observador.atualizar();
    }
}
