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
        System.out.println("--------------------");
        System.out.println(lista.obterUltimoElemento());

        lista.editarElemento("asd",2);

        lista.inserirElemento(4);
        lista.inserirElemento(5);
        lista.inserirElemento(8);
        lista.removerIndice(1);

        lista.exibir();
        lista.ordenarDecrescente();
        lista.exibir();
    }
}
