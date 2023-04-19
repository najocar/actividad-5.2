import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Suma dos números")
    void testSuma(){
        assertEquals(4, miCalculadora.suma(2,2));
        assertEquals(2, miCalculadora.suma(-1,3));
        assertEquals(0, miCalculadora.suma(2,-2));
        assertEquals(-4, miCalculadora.suma(-2,-2));
    }

    @Test
    @DisplayName("Resta")
    void testResta(){
        assertEquals(0, miCalculadora.resta(2,2));
        assertEquals(-4, miCalculadora.resta(-1,3));
        assertEquals(3, miCalculadora.resta(5,2));
        assertEquals(0, miCalculadora.resta(-2,-2));
    }

    @Test
    @DisplayName("Potencia")
    void testPotencia(){
        assertEquals(4, miCalculadora.potencia(2,2));
        assertEquals(1, miCalculadora.potencia(-1,2));
        assertEquals(0.25, miCalculadora.potencia(2,-2));
        assertEquals(0.25, miCalculadora.potencia(-2,-2));
    }

    @Test
    @DisplayName("Raiz Cuadrada")
    void testRaiz(){
        assertEquals(5, miCalculadora.raizCuadrada(25));
        assertEquals(11, miCalculadora.raizCuadrada(121));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
    }
}