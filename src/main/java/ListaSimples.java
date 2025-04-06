public class ListaSimples implements IEstruturaSimples{

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
                System.out.println("o elemento " + elemento + " foi inserido");
                return;
            }
        }

        System.out.println("Todas posições estão preenchidas");
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (!checarIntervaloIndice(indice)) {
            return;
        }

        lista[indice] = elemento;

        System.out.println("o elemento " + elemento + " foi inserido no indice " + indice);

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
        return false;
    }

    @Override
    public boolean estaVazia() {
        return false;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        return null;
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

    public boolean checarIntervaloIndice(int indice) {
        if (indice > 0 && indice < tamanho) {
            return true;
        }

        System.out.println("indice fora dos limites ou invalido");

        return false;
    }
}
