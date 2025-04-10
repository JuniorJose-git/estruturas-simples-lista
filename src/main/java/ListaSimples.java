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

    @Override
    public void inserirSequencia(Object elementos) {

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

        System.out.println("A lista está vazia");
        return false;

    }

    @Override
    public Object removerIndice(int indice) throws Exception {

        Object elemento = buscarElementoIndice(indice);

        lista[indice] = null;

        return elemento;
    }

    @Override
    public void removerSequencia(Object elementos) {

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

    }

    @Override
    public void ordenarDecrescente() {

        // quebra se for outro tipo de objeto se não Interger

        Integer elementoExterno = null;
        Integer elementoInterno = null;

        for (int i = 0; i < tamanho; i++) {

            // fazer  tratamentos se objeto for de outros tipos

            if (lista[i] != null) {
                elementoExterno = parseInt(lista[i].toString());
            } else {
                elementoExterno = null;
            }

            for (int j = i; j < tamanho; j++) {

                if (lista[j] != null) {
                    elementoInterno = parseInt(lista[j].toString());
                } else {
                    elementoInterno = null;
                }

                System.out.println(elementoExterno + " - " + elementoInterno);

                if (elementoExterno == null && elementoInterno != null) {

                    lista[i] = elementoInterno;
                    break;
                }

                // troca os valores dos elmentos, como foi criado duas variveis, representando respectivamente o elemento no loop exerto e interno,
                // não se teve necessidade de criar uma variável auxiliar

                if (elementoInterno != null && elementoInterno > elementoExterno) {
                    lista[j] = lista[i];
                    lista[i] = elementoInterno;
                }

            }
            System.out.println("--------------------------");

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
}
