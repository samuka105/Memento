package biblioteca;

public class SituacaoReservado implements SituacaoExemplar {

    private SituacaoReservado() {};
    private static SituacaoReservado instance = new SituacaoReservado();
    public static SituacaoReservado getInstance() {
        return instance;
    }

    public String getNomeSituacao() {
        return "Reservado";
    }

}
