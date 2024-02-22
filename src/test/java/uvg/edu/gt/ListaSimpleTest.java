package uvg.edu.gt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ListaSimpleTest {

    @Test
    public void testInfixToPostfix() {
        // Caso de prueba 1: Verificar la conversión de infix a postfix con una expresión simple
        String infixExpression1 = "a+b*c";
        String expectedPostfix1 = "a b c * +";

        // Caso de prueba 2: Verificar la conversión de infix a postfix con paréntesis
        String infixExpression2 = "(a+b)*c";
        String expectedPostfix2 = "a b + c *";

    }
}