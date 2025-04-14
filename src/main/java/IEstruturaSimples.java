public interface IEstruturaSimples {

    void inserirElemento(Integer elemento) throws Exception;
    void inserirElementoIndice(Integer elemento, int indice) throws Exception;
    void inserirSequencia(Integer [] elementos) throws Exception;
    boolean removerElemento();
    Integer removerIndice(int indice) throws Exception;
    void removerSequencia(Integer[] elementos) throws Exception;
    void removerTodasOcorrencias(Integer elemento) throws Exception;
    boolean estaCheia();
    boolean estaVazia();
    boolean buscarElemento(Integer elemento);
    Integer buscarElementoIndice(int indice) throws Exception;
    void ordenarCrescente();
    void ordenarDecrescente();
    int quantidadeElementos();
    void dobrarCapacidade();
    void editarElemento(Integer elementoAntigo, Integer elementoNovo) throws Exception;
    void limpar();
    void exibir();
    Integer obterPrimeiroElemento() throws Exception;
    Integer obterUltimoElemento() throws Exception;
}