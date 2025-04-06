public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples listaSimples = new ListaSimples(10);

        listaSimples.inserirElemento(1);

        listaSimples.inserirElemento(2);

        listaSimples.inserirElemento("sdfsdfsdfsdfsdf");

        listaSimples.inserirElementoIndice("asd",1);

        System.out.println(listaSimples.buscarElemento("asdasd"));

        System.out.println(listaSimples.buscarElementoIndice(2));

        listaSimples.removerElemento();

        listaSimples.exibir();
    }
}
