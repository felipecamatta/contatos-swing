package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ConsultarContatosPresenter;
import br.ufes.contatos.frontend.presenter.ManterContatoPresenter;

import javax.swing.*;

public class RemoverContatoPresenter extends ManterContatosState {

    public RemoverContatoPresenter(JFrame view, Contato contato, ManterContatoPresenter principal) {
        super(view, principal);
        this.excluir(contato);
        JOptionPane.showMessageDialog(view, "Contato de " + contato.getNome() + " excluido com sucesso!", "Excluir Contato", 0);
        principal.setEstado(new ConsultarContatosPresenter(principal));
        this.fechar();
    }

    @Override
    public void excluir(Contato contato) {
        this.getContatoService().deleteContato(contato);
    }

    @Override
    public void fechar() {
        this.getView().dispose();
    }

}
