public class Main {

    public static void main(String[] args) {

        ListaSimples listaSimples = new ListaSimples(10);

        listaSimples.inserirElemento(1);

        listaSimples.inserirElemento(1);

        listaSimples.inserirElemento("sdfsdfsdfsdfsdf");

        listaSimples.inserirElementoIndice("asd",1);

        System.out.println(listaSimples.buscarElemento("asd"));
        System.out.println(listaSimples.buscarElementoIndice(1));

        listaSimples.removerElemento();

        listaSimples.exibir();
    }
}
