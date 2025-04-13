public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples lista = new ListaSimples(11);

        lista.inserirElemento(1);
        lista.inserirElemento(2);
        lista.inserirElemento("asdasdasd");
        lista.inserirElemento(3);
        lista.inserirElemento(4);
        lista.inserirElemento(4);
//
//        Double teste = 10.2;
//
//        lista.inserirElementoIndice(teste,6);
//        lista.inserirElementoIndice(teste,4);
//
//        lista.dobrarCapacidade();
//        lista.inserirElementoIndice(teste,9);
//
//        lista.exibir();
//        lista.ordenarDecrescente();
//        lista.exibir();
//
//        lista.inserirElemento(10);
//        lista.inserirElemento(10);
        lista.inserirElemento(10);
        lista.inserirElemento(1);
        lista.inserirElemento(3);
        lista.inserirElemento(3);
        lista.inserirElemento(4);
//
//        lista.inserirElemento(10);lista.inserirElemento(10);
//        lista.inserirElemento(10);


        lista.removerSequencia(new Object[]{10,1,2,3,4});
        lista.exibir();
    }
}
