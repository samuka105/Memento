package biblioteca;

public class SituacaoEmReparo implements SituacaoExemplar {

    private SituacaoEmReparo() {};
    private static SituacaoEmReparo instance = new SituacaoEmReparo();
    public static SituacaoEmReparo getInstance() {
        return instance;
    }

    public String getNomeSituacao() {
        return "Em reparo";
    }

}
