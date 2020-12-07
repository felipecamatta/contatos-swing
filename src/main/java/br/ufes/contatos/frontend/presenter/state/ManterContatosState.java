package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.service.ContatoService;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ManterContatoPresenter;
import javax.swing.JFrame;

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

    public void salvar(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editar(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void excluir(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fechar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
