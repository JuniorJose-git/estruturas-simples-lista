public interface IEstruturaSimples {

    void inserirElemento(Object elemento);
    void inserirElementoIndice(Object elemento, int indice) throws Exception;
    void inserirSequencia(Object elementos);
    boolean removerElemento();
    Object removerIndice(int indice) throws Exception;
    void removerSequencia(Object elementos);
    void removerTodasOcorrencias(Object elemento) throws Exception;
    boolean estaCheia();
    boolean estaVazia();
    boolean buscarElemento(Object elemento);
    Object buscarElementoIndice(int indice) throws Exception;
    void ordenarCrescente();
    void ordenarDecrescente();
    int quantidadeElementos();
    void dobrarCapacidade();
    void editarElemento(Object elementoAntigo, Object elementoNovo) throws Exception;
    void limpar();
    void exibir();
    Object obterPrimeiroElemento() throws Exception;
    Object obterUltimoElemento() throws Exception;
}