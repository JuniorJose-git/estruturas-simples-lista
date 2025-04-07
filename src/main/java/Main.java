public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples listaSimples = new ListaSimples(3);

        listaSimples.inserirElemento(1);

        listaSimples.inserirElemento(2);

        listaSimples.inserirElemento("asd");

        listaSimples.inserirElementoIndice(1,1);

        listaSimples.removerElemento();

        System.out.println(listaSimples.quantidadeElementos());

        listaSimples.dobrarCapacidade();

        listaSimples.exibir();
    }
}
