package biblioteca;

public class SituacaoExtraviado implements SituacaoExemplar {

    private SituacaoExtraviado() {};
    private static SituacaoExtraviado instance = new SituacaoExtraviado();
    public static SituacaoExtraviado getInstance() {
        return instance;
    }

    public String getNomeSituacao() {
        return "Extraviado";
    }

}
