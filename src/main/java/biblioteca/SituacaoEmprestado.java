package biblioteca;

public class SituacaoEmprestado implements SituacaoExemplar {

    private SituacaoEmprestado() {};
    private static SituacaoEmprestado instance = new SituacaoEmprestado();
    public static SituacaoEmprestado getInstance() {
        return instance;
    }

    public String getNomeSituacao() {
        return "Emprestado";
    }

}
