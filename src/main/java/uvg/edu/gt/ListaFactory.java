package uvg.edu.gt;

class ListaFactory {
    public String getLista(String expresion,int opcion){
        switch (opcion) {
            case 1:
                System.out.println("ListaSimple");
                return ListaSimple.infixToPostfix(expresion);
            case 2:
                System.out.println("ListaDoblementeEnlazada");
                return ListaDoblementeEnlazada.infixToPostfix(expresion);
        }
        return null;
    }
}
