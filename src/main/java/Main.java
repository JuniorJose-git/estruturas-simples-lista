public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples lista = new ListaSimples(10);

        lista.inserirElemento(1);
        lista.inserirElemento(2);
        lista.inserirElemento("asdasdasd");
        lista.inserirElemento(3);
        lista.inserirElemento(4);
        Double teste = 10.2;

        lista.inserirElementoIndice(teste,9);
        lista.exibir();
        lista.ordenarDecrescente();
        lista.exibir();
    }
}
