package sptech.school.continuada2.entity;

import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("1. [ESTRUTURA] - Teste de Estrutura da Classe Personagem")
class PersonagemTest {

    @Test
    @DisplayName("Deve garantir que a classe Personagem tenha métodos getter e setter para todos os atributos")
    void deveGarantirGettersSetters() {
        try {
            Method getId = Personagem.class.getMethod("getId");
            Method setId = Personagem.class.getMethod("setId", Integer.class);

            Method getNome = Personagem.class.getMethod("getNome");
            Method setNome = Personagem.class.getMethod("setNome", String.class);

            Method getUltimate = Personagem.class.getMethod("getUltimate");
            Method setUltimate = Personagem.class.getMethod("setUltimate", String.class);

            Method getFuncaoPrincipal = Personagem.class.getMethod("getFuncaoPrincipal");
            Method setFuncaoPrincipal = Personagem.class.getMethod("setFuncaoPrincipal", String.class);

            Method getRegiao = Personagem.class.getMethod("getRegiao");
            Method setRegiao = Personagem.class.getMethod("setRegiao", Regiao.class);

            assertNotNull(getId, "O método getId() deve existir.");
            assertNotNull(setId, "O método setId() deve existir.");

            assertNotNull(getNome, "O método getNome() deve existir.");
            assertNotNull(setNome, "O método setNome() deve existir.");

            assertNotNull(getUltimate, "O método getUltimate() deve existir.");
            assertNotNull(setUltimate, "O método setUltimate() deve existir.");

            assertNotNull(getFuncaoPrincipal, "O método getFuncaPrincipal() deve existir.");
            assertNotNull(setFuncaoPrincipal, "O método setFuncaoPrincipal() deve existir.");

            assertNotNull(getRegiao, "O método getRegiao() deve existir.");
            assertNotNull(setRegiao, "O método setRegiao() deve existir.");

        } catch (NoSuchMethodException e) {
            fail("A classe Personagem deve conter os métodos getter e setter para todos os atributos.");
        }
    }

    @Test
    @DisplayName("Deve garantir que o atributo 'regiao' tenha uma anotação de relacionamento")
    void deveGarantirAnotacaoDeRelacionamentoEmPersonagem() {
        try {
            Field regiaoField = Personagem.class.getDeclaredField("regiao");
            assertTrue(regiaoField.isAnnotationPresent(ManyToOne.class),
                    "O campo 'regiao' deve ter uma anotação de relacionamento.");
        } catch (NoSuchFieldException e) {
            fail("O atributo 'regiao' deve existir na classe Personagem.");
        }
    }
}