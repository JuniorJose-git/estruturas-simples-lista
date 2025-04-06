public class ListaSimples implements IEstruturaSimples{

    private Object [] lista;
    private int tamanho;

    public ListaSimples(int tamanho) {
        this.lista = new Object [tamanho];
        this.tamanho = tamanho;
    }

    @Override
    public void inserirElemento(Object elemento) {

    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {

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

    }

    @Override
    public Object obterPrimeiroElemento() {
        return null;
    }

    @Override
    public Object obterUltimoElemento() {
        return null;
    }
}
