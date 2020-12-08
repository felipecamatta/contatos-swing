package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.presenter.ManterPresenter;
import br.ufes.contatos.frontend.service.ContatoService;

public abstract class ManterContatosState {

    protected ContatoService contatoService;
    protected ManterPresenter presenter;

    public ManterContatosState(ManterPresenter presenter) {
        this.presenter = presenter;
        this.contatoService = new ContatoService();
    }

    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fechar() {
        this.presenter.getView().dispose();
    }

}
