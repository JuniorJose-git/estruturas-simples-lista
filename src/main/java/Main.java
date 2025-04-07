public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples lista = new ListaSimples(3);

        lista.inserirElemento(1);

        lista.inserirElemento(2);

        lista.inserirElemento("asd");

        lista.inserirElementoIndice(1,1);

        lista.removerElemento();

        System.out.println(lista.quantidadeElementos());

        lista.dobrarCapacidade();

        System.out.println(lista.obterPrimeiroElemento());

        lista.exibir();
    }
}
