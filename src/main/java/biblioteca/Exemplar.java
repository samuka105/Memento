package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Exemplar {

    private String titulo;
    private SituacaoExemplar situacao;
    private List<SituacaoExemplar> memento = new ArrayList<SituacaoExemplar>();

    public Exemplar(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public SituacaoExemplar getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoExemplar situacao) {
        this.situacao = situacao;
        this.memento.add(this.situacao);
    }

    public void restauraSituacao(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.situacao = this.memento.get(indice);
    }

    public List<SituacaoExemplar> getSituacoes() {
        return this.memento;
    }
}
