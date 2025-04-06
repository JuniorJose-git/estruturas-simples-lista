public class ListaSimples implements IEstruturaSimples {

    private Object [] lista;
    private int tamanho;

    public ListaSimples(int tamanho) {
        this.lista = new Object [tamanho];
        this.tamanho = tamanho;
    }

    @Override
    public void inserirElemento(Object elemento) {

        for (int i = 0; i < this.tamanho; i++) {
            if (lista[i] == null) {
                lista[i] = elemento;
                System.out.println("O elemento " + elemento + " foi inserido");
                return;
            }
        }

        System.out.println("Todas posições estão preenchidas");
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) throws Exception {
        checarIntervaloIndice(indice);

        lista[indice] = elemento;

        System.out.println("O elemento " + elemento + " foi inserido no índice " + indice);

    }

    @Override
    public void inserirSequencia(Object elementos) {

    }

    @Override
    public boolean removerElemento() {

        return false;
    }

    @Override
    public Object removerIndice(int indice) {
        return null;
    }

    @Override
    public void removerSequencia(Object elementos) {

    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {

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
        checarIntervaloIndice(indice);

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

    }

    @Override
    public int quantidadeElementos() {
        return 0;
    }

    @Override
    public void dobrarCapacidade() {

    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {

    }

    @Override
    public void limpar() {

    }

    @Override
    public void exibir() {
        System.out.print("[ ");

        for (int i = 0; i < this.tamanho - 1; i++) {

            if (this.lista[i] != null && lista[i].getClass() == String.class) {
                System.out.print("\"" + lista[i] + "\", ");
            } else {
                System.out.print(lista[i] + ", ");
            }
        }

        System.out.print(lista[this.tamanho - 1] + " ]");
    }

    @Override
    public Object obterPrimeiroElemento() {
        return null;
    }

    @Override
    public Object obterUltimoElemento() {
        return null;
    }

    public boolean checarIntervaloIndice(int indice) throws Exception {
        if (indice >= 0 && indice < tamanho) {
            return true;
        }

        throw new Exception("Índice fora dos limites ou invalido");
    }

    private boolean checarValorNuloIndice(int indice) throws Exception {

        if (lista[indice] == null) {
            throw new Exception("Elemento no indice " + indice + " é null");
        }

        return false;
    }
}
