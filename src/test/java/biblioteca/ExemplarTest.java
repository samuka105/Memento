package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExemplarTest {

    Exemplar exemplar;

    @BeforeEach
    void setUp() {
        exemplar = new Exemplar("Dom Casmurro");
    }

    @Test
    void deveComecarSemSituacao() {
        assertNull(exemplar.getSituacao());
        assertEquals(0, exemplar.getSituacoes().size());
    }

    @Test
    void deveArmazenarSituacoes() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmprestado.getInstance());

        assertEquals(Arrays.asList(SituacaoDisponivel.getInstance(), SituacaoEmprestado.getInstance()),
                exemplar.getSituacoes());
    }

    @Test
    void deveGuardarSituacaoAtual() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoReservado.getInstance());

        assertEquals("Reservado", exemplar.getSituacao().getNomeSituacao());
    }

    @Test
    void deveRetornarSituacaoInicial() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmprestado.getInstance());
        exemplar.setSituacao(SituacaoExtraviado.getInstance());
        exemplar.restauraSituacao(0);

        assertEquals(SituacaoDisponivel.getInstance(), exemplar.getSituacao());
    }

    @Test
    void deveRetornarSituacaoAnterior() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmprestado.getInstance());
        // bibliotecario marcou extraviado por engano, o livro estava so emprestado
        exemplar.setSituacao(SituacaoExtraviado.getInstance());
        exemplar.restauraSituacao(1);

        assertEquals("Emprestado", exemplar.getSituacao().getNomeSituacao());
    }

    @Test
    void restaurarNaoDeveAdicionarNoHistorico() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmReparo.getInstance());
        exemplar.restauraSituacao(0);

        assertEquals(2, exemplar.getSituacoes().size());
    }

    @Test
    void deveContinuarRegistrandoDepoisDeRestaurar() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmReparo.getInstance());
        exemplar.restauraSituacao(0);
        exemplar.setSituacao(SituacaoEmprestado.getInstance());

        assertEquals(3, exemplar.getSituacoes().size());
        assertEquals(SituacaoEmprestado.getInstance(), exemplar.getSituacao());
    }

    @Test
    void deveRetornarExcecaoQuandoSemSituacoes() {
        try {
            exemplar.restauraSituacao(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaIndiceNegativo() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());

        assertThrows(IllegalArgumentException.class, () -> exemplar.restauraSituacao(-1));
    }

    @Test
    void deveRetornarExcecaoParaIndiceMaiorQueOHistorico() {
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        exemplar.setSituacao(SituacaoEmprestado.getInstance());

        assertThrows(IllegalArgumentException.class, () -> exemplar.restauraSituacao(2));
    }

    @Test
    void cadaExemplarDeveTerSeuProprioHistorico() {
        Exemplar outro = new Exemplar("O Cortiço");
        exemplar.setSituacao(SituacaoDisponivel.getInstance());
        outro.setSituacao(SituacaoEmReparo.getInstance());

        assertEquals(1, exemplar.getSituacoes().size());
        assertEquals("Em reparo", outro.getSituacao().getNomeSituacao());
    }
}
