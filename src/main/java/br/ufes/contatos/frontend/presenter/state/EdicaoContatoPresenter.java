package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ManterContatoPresenter;
import br.ufes.contatos.frontend.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EdicaoContatoPresenter extends ManterContatosState {

    public EdicaoContatoPresenter(ManterContatoPresenter principal) {
        super(new ManterContatoView(), principal);

        ManterContatoView view = (ManterContatoView) this.getView();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }

        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();

                salvar(new Contato(nome, telefone));
            }
        });

        view.setVisible(true);
    }
    
    @Override
    public void salvar(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void editar(Contato contato) {
        ManterContatoView view = (ManterContatoView) this.getView();

        this.getContatoService().updateContato(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " atualizado com sucesso!",
                "Atualizado com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void fechar() {
        this.getView().dispose();
    }
    
}
