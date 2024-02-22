package uvg.edu.gt;

public class ExpresionFactory {
    public String getExpresion(String expresion,int opcion){
        switch (opcion) {
            case 1:
                System.out.println("ArrayList");
                return LeerExpresionesArrayList.infixToPostfix(expresion);
            case 2:
                System.out.println("Vector");
                return LeerExpresionVector.infixToPostfix(expresion);
        }
        return null;
    }
}
