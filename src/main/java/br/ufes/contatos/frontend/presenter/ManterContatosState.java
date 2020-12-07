/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.service.ContatoService;
import br.ufes.contatos.frontend.model.Contato;
import javax.swing.JFrame;

/**
 *
 * @author gabriel
 */
public abstract class ManterContatosState {
    
    private JFrame view;
    private ContatoService contatoService;
    private ManterContatoPresenter controlador;

    public ManterContatosState(JFrame view, ManterContatoPresenter principal) {
        this.view = view;
        this.controlador = principal;
        this.contatoService = new ContatoService();
        this.view.setVisible(true);
    }

    public JFrame getView() {
        return view;
    }

    public void setView(JFrame view) {
        this.view = view;
    }

    public ContatoService getContatoService() {
        return contatoService;
    }

    public void setContatoService(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public ManterContatoPresenter getControlador() {
        return controlador;
    }
    
    public abstract void salvar(Contato contato);
    public abstract void excluir(Contato contato);
    public abstract void fechar();
}
