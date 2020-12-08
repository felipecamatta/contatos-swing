package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ConsultarContatosPresenter;
import br.ufes.contatos.frontend.presenter.ManterContatoPresenter;
import br.ufes.contatos.frontend.view.ManterContatoView;

import javax.swing.*;

public class RemoverContatoPresenter extends ManterContatosState {

    public RemoverContatoPresenter(ManterContatoPresenter presenter) {
        super(presenter);
        
        ManterContatoView view = this.presenter.getView();
        
        this.excluir(contato);
        
        JOptionPane.showMessageDialog(view, "Contato de " + contato.getNome() + " excluido com sucesso!", "Excluir Contato", 0);
        presenter.setEstado(new ConsultarContatosPresenter(presenter));
        this.fechar();
    }

    @Override
    public void excluir(Contato contato) {
        this.getContatoService().deleteContato(contato);
    }

    @Override
    public void fechar() {
        this.presenter.getView().dispose();
    }

}
