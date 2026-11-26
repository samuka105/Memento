package biblioteca;

public class SituacaoDisponivel implements SituacaoExemplar {

    private SituacaoDisponivel() {};
    private static SituacaoDisponivel instance = new SituacaoDisponivel();
    public static SituacaoDisponivel getInstance() {
        return instance;
    }

    public String getNomeSituacao() {
        return "Disponível";
    }

}
