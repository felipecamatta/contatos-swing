package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.presenter.state.ManterContatosState;
import br.ufes.contatos.frontend.presenter.state.IncluirContatoPresenter;
import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.view.ManterContatoView;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ManterContatoPresenter {

    private ManterContatoView view;
    private ContatoCollection contatos;
    private ManterContatosState estado;

    public ManterContatoPresenter() {
        this.view = new ManterContatoView();
        this.estado = null;

        this.view.setState(JFrame.ICONIFIED);

        this.view.setLocationRelativeTo(this.view.getParent());
        this.view.setExtendedState(MAXIMIZED_BOTH);

        this.view.setVisible(true);

        this.view.getItemIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado != null) {
                    estado.fechar();
                }
                estado = incluir();

            }
        });

        this.view.getItemConsultar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado != null) {
                    estado.fechar();
                }
                estado = consultar();

            }
        });
    }

    public ContatoCollection getContatos() {
        return contatos;
    }

    public void setContatos(ContatoCollection contatos) {
        this.contatos = contatos;
    }

    public ManterContatoView getView() {
        return view;
    }

    public ManterContatosState getEstado() {
        return estado;
    }

    public void setEstado(ManterContatosState estado) {
        this.estado = estado;
    }

    private ManterContatosState consultar() {
        return new ConsultarContatosPresenter(this);
    }

    private ManterContatosState incluir() {
        return new IncluirContatoPresenter(this);
    }

}
