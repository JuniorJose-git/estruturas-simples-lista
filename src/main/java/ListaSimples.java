import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class ListaSimples implements IEstruturaSimples {

    private Object [] lista;
    private int tamanho;

    public ListaSimples(int tamanho) {
        this.lista = new Object [tamanho];
        this.tamanho = tamanho;
    }

    // irá inserir o elemento desejado no lugar do primeiro elemento nulo que encontrar
    @Override
    public void inserirElemento(Object elemento) throws Exception {

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] == null) {
                lista[i] = elemento;
                //System.out.println("O elemento " + elemento + " foi inserido");
                return;
            }
        }

        throw new Exception("Todas posições estão preenchidas");
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) throws Exception {

        if (!checarIntervaloIndice(indice)) {
            throw new Exception("Índice fora dos limites ou invalido");
        }

        lista[indice] = elemento;

        //System.out.println("O elemento " + elemento + " foi inserido no índice " + indice);

    }

    // ira inserir um array de elementos na primeira sequencia de elementos nulos do mesmo tamanho do array que encontrar
    @Override
    public void inserirSequencia(Object[] elementos) {

        int i = 0;
        while ((i + elementos.length) < tamanho + 1) {
            if (lista[i] != null) {
                i++;
                continue;
            }

//            if (i + elementos.length > tamanho) {
//                return;
//            }

            for (int j = i; ( j < i + elementos.length); j++) {
//                System.out.println(lista[j] + " " + i + " vezes " + elementos.length);
//                System.out.println(i + elementos.length);

                if (!Objects.equals(lista[j], null)) {
                    i = j;
                    break;
                } else if (j == (i + elementos.length - 1)) {

                    for (int k = 0; k < elementos.length; k++) {
                        lista[i + k] = elementos[k];
                    }

                    return;
                }
            }
            i++;
        }
    }


    // Irá remover o primeiro elemento não nulo que encotrar
    @Override
    public boolean removerElemento() {

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] != null) {
                lista[i] = null;
                return true;
            }
        }

        return false;

    }

    @Override
    public Object removerIndice(int indice) throws Exception {

        Object elemento = buscarElementoIndice(indice);

        lista[indice] = null;

        return elemento;
    }


    // ira remover da lista os elementos que forem iguais os do array de parametro e estiverem na mesma sequencia
    @Override
    public void removerSequencia(Object[] elementos) {

        for (int i = 0; i < tamanho; i++) {

            if (lista[i] != elementos[0]) {
                continue;
            }

            for (int j = i; j < i + elementos.length; j++) {

                if (!Objects.equals(lista[j], elementos[j - i])) {
                    break;
                }

                if (j == (i + elementos.length - 1)) {

                    for (int k = i; k <= j; k++) {
                        lista[k] = null;
                    }
                    return;
                }
            }

        }

    }

    @Override
    public void removerTodasOcorrencias(Object elemento) throws Exception {

        if (!buscarElemento(elemento)) {
            throw new Exception("O elemento não existe na lista");
        }

        while (buscarElemento(elemento)) {
            for (int i = 0; i < tamanho; i++) {
                if (lista[i] == elemento) {
                    lista[i] = null;
                }
            }
        }
    }

    @Override
    public boolean estaCheia() {

        boolean retorno = true;

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] == null) {
                retorno = false;
                break;
            }
        }

        return retorno;
    }

    @Override
    public boolean estaVazia() {
        boolean retorno = true;

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] != null) {
                retorno = false;
                break;
            }
        }

        return retorno;
    }

    @Override
    public boolean buscarElemento(Object elemento) {

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) throws Exception {

        if (!checarIntervaloIndice(indice)) {
            throw new Exception("Índice fora dos limites ou invalido");
        }

        if (lista[indice] == null) {
            throw new Exception("Elemento no indice " + indice + " é null");
        }

        return lista[indice];
    }

    @Override
    public void ordenarCrescente() {
        Object aux;

        for (int i = 0; i < tamanho - 1; i++) {

            for (int j = i + 1; j < tamanho; j++) {

//                System.out.println("indice externo " + i + " = " + lista[i] + " : indice interno " + j + " = " + lista[j]);

                // se o elemento externo for nulo e o interno não, troca o mesmo
                if ((lista[i] == null) && lista[j] != null) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                    continue;
                }
                // troca os elementos se o externo não for inteiro e o interno for.
                if (!(lista[i] instanceof Integer) && (lista[j] instanceof Integer)) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                    continue;
                }

                // troca os valores dos elmentos se forem inteiros e se o elemento da varredura interna for maior que o elemento externo

                if (lista[j] instanceof Integer && lista[i] instanceof Integer && (Integer) lista[j] < (Integer) lista[i]) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }
        }

    }

    @Override
    public void ordenarDecrescente() {

        Object aux;

        for (int i = 0; i < tamanho - 1; i++) {

            for (int j = i + 1; j < tamanho; j++) {

//                System.out.println("indice externo " + i + " = " + lista[i] + " : indice interno " + j + " = " + lista[j]);

                // se o elemento externo for nulo e o interno não, troca o mesmo
                if ((lista[i] == null) && lista[j] != null) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                    continue;
                }
                // troca os elementos se o externo não for inteiro e o interno for.
                if (!(lista[i] instanceof Integer) && (lista[j] instanceof Integer)) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                    continue;
                }

                // troca os valores dos elmentos se forem inteiros e se o elemento da varredura interna for maior que o elemento externo

                if (lista[j] instanceof Integer && lista[i] instanceof Integer && (Integer) lista[j] > (Integer) lista[i]) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }
        }
    }

    @Override
    public int quantidadeElementos() {

        int quantidade = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null) {
                quantidade++;
            }
        }

        return quantidade;
    }

    @Override
    public void dobrarCapacidade() {
        Object [] novaLista = new Object[tamanho * 2];

        for (int i = 0; i < tamanho; i++) {
            novaLista[i] = lista[i];
        }
        tamanho = tamanho * 2;
        this.lista = novaLista;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) throws Exception {
        if (!buscarElemento(elementoAntigo)) {
            throw new Exception("não foi encontrado o elemento na lista");
        }

        for (int i = 0; i < tamanho; i++) {
            if (lista[i] == elementoAntigo) {
                lista[i] = elementoNovo;
            }
        }
    }

    @Override
    public void limpar() {
        this.lista = new Object[this.tamanho];
    }

    @Override
    public void exibir() {
        System.out.print("[ ");

        for (int i = 0; i < this.tamanho - 1; i++) {

//            if (this.lista[i] != null && lista[i].getClass() == String.class) {
//                System.out.print("\"" + lista[i] + "\", ");
//            } else {
//                System.out.print(lista[i] + ", ");
//            }

            System.out.print(lista[i] + ", ");

        }

        System.out.println(lista[this.tamanho - 1] + " ]");
    }

    @Override
    public Object obterPrimeiroElemento() throws Exception {

        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null) {
                return lista[i];
            }
        }

        throw new Exception ("Não há elementos na lista");
    }

    @Override
    public Object obterUltimoElemento() throws Exception {

        for (int i = tamanho - 1; i >= 0; i--) {
            if (lista[i] != null) {
                return lista[i];
            }
        }

        throw new Exception ("Não há elementos na lista");
    }

    public boolean checarIntervaloIndice(int indice) {

        if (indice >= 0 && indice < tamanho) {
            return true;
        }

        return false;
    }

    private boolean checarValorNuloIndice(int indice) {

        return lista[indice] == null;
    }

    public String[] ordenaString (String [] array) {


        for (int i = 0; i < array.length; i++) {

            if (array[i] == null) {
                break;
            }

            for (int j = i + 1; j < array.length; j++) {


                if (array[j] == null) {
                    break;
                }


                int tamanho = 0;

                if (array[i].length() < array[j].length()) {
                    tamanho = array[i].length();
                } else {
                    tamanho = array[j].length();
                }

                int sum1 = 0;
                int sum2 = 0;

                for (int k = 0; k < tamanho; k++) {
                    sum1 += (int) array[i].charAt(k);
                    sum2 += (int) array[j].charAt(k);
                }

                String aux;
                if (sum1 > sum2) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }

        return array;
    }
}
