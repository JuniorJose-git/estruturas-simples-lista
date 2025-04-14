import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Integer [] atualizaArray (Integer [] array, Integer valor) {
        Integer [] retorno = new Integer[array.length + 1];


        for (int i = 0; i < array.length; i++) {
            retorno[i] = array[i];
        }
        retorno[retorno.length - 1 ] = valor;

        return retorno;
    }

    public static void exibirArray (Object [] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");

        }

        System.out.println(array[array.length - 1] + " ]");
    }

    public static boolean continuar() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("deseja continuar? (1) sim (0) não");

            try {
                int continuar = scanner.nextInt();

                switch (continuar) {
                    case 1:
                        return true;
                    case 0:
                        return false;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Opção inválida");
            }

        } while (true);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tamanho;
        int opcao;
        do {
            System.out.println("Digite o tamanho da lista simples de inteiros");

            try {
                tamanho = scanner.nextInt();

                if (tamanho <= 0) {
                    System.out.println("Tamanho inválida");
                    continue;
                }

                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Tamanho inválida");

            }

        } while (true);

        ListaSimples lista = new ListaSimples(tamanho);

        do {
            System.out.println("Escolha uma Operação: ");
            System.out.println("1  - Inserir elemento");
            System.out.println("2  - Inserir elemento por índice");
            System.out.println("3  - Inserir sequência");
            System.out.println("4  - Remover elemento");
            System.out.println("5  - Remover elemento por índice");
            System.out.println("6  - Remover sequência");
            System.out.println("7  - Remover todas ocorrências");
            System.out.println("8  - Verificar se lista está vazia");
            System.out.println("9  - Verficar se lista está cheia");
            System.out.println("10 - Buscar elemento");
            System.out.println("11 - Buscar elemento em um índice");
            System.out.println("12 - Ordenar crescente");
            System.out.println("13 - Ordenar Decrescente");
            System.out.println("14 - Quantidade de elementos");
            System.out.println("15 - Dobrar capacidade");
            System.out.println("16 - Editar elemento");
            System.out.println("17 - Limpar lista");
            System.out.println("18 - Obter primeiro elemento");
            System.out.println("19 - Obter último elemento");
            System.out.println("20 - Exibir lista");
            System.out.println("21 - Sair");

            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Opção inválida");
                continue;
            }

            if (opcao < 1 || opcao > 21) {
                continue;
            }
            int indice;
            int elemento;
            switch (opcao) {
                case 1:
                    System.out.println("irá inserir o elemento desejado no lugar do primeiro elemento nulo que encontrar");

                    do {
                        try {
                            System.out.println("Digite o elemento");
                            elemento = scanner.nextInt();
                            lista.inserirElemento(elemento);
                            System.out.println("O elemento " + elemento + " foi inserido");
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Elemento inválido");
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    break;
                case 2:

                    do {
                        try {
                            System.out.println("Digite o Indice");
                            indice = scanner.nextInt();
                            System.out.println("Digite o valor");
                            lista.inserirElementoIndice(scanner.nextInt(),indice);
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Elemento ou índice inválido");
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    break;
                case 3:
                    System.out.println("ira inserir um array de elementos na primeira sequencia de elementos nulos do mesmo tamanho do array que encontrar");
                    Integer [] aux = new Integer[0];
                    System.out.println("digite o elemento que deseja inserir");
                    do {
                        try {
                            elemento = scanner.nextInt();

                            aux = atualizaArray(aux,elemento);

                            if (continuar()) {
                                System.out.println("Digite o próximo elemento");
                            } else {
                                try {
                                    lista.inserirSequencia(aux);
                                    System.out.print("Elementos: ");
                                    exibirArray(aux);
                                    System.out.print("Lista: ");
                                    lista.exibir();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }

                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Elemento Inválido, digite novamente");
                        }
                    } while (true);

                    break;
                case 4:
                    System.out.println("Irá remover o primeiro elemento não nulo que encotrar");
                        if (!continuar()) {
                            break;
                        }
                        if (lista.removerElemento()) {
                            System.out.println("elemento Removido");
                        } else {
                            System.out.println("A lista está vazia");
                        }
                    break;
                case 5:
                    do {
                        try {
                            System.out.println("Digite o Indice");
                            lista.removerIndice(scanner.nextInt());
                            System.out.println("removido elemento");
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("índice inválido");
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    break;
                case 6:
                    System.out.println("ira remover da lista os elementos que forem iguais os do array de parametro e estiverem na mesma sequencia");
                    Integer [] auxd = new Integer[0];
                    System.out.println("digite o elemento que deseja remover");
                    do {
                        try {

                            elemento = scanner.nextInt();

                            auxd = atualizaArray(auxd,elemento);

                            if (continuar()) {
                                System.out.println("Digite o próximo elemento");
                            } else {
                                try {
                                    System.out.print("será removido: ");
                                    exibirArray(auxd);
                                    System.out.print("Lista: ");
                                    lista.removerSequencia(auxd);
                                    lista.exibir();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Elemento Inválido, digite novamente");
                        }
                    } while (true);

                    break;
                case 7:
                    do {

                        try {
                            System.out.println("Digite o elemento");
                            lista.removerTodasOcorrencias(scanner.nextInt());
                            System.out.println("Removido todas as ocorrências");
                            break;
                        }catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("elemento inválido");
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());

                            if (!continuar()) {
                                break;
                            }

                        }

                    } while (true);
                    break;
                case 8:
                    if (lista.estaVazia()) {
                        System.out.println("a lista está vazia");
                    } else {
                        System.out.println("a lista não está vazia");
                    }
                    break;
                case 9:
                    if (lista.estaCheia()) {
                        System.out.println("A lista está cheia");
                    } else {
                        System.out.println("A lista não está cheia");
                    }
                    break;
                case 10:
                    System.out.println("Digite o elemento");
                    do {
                        try {
                            if (lista.buscarElemento(scanner.nextInt())) {
                                System.out.println("O elemento está na lista");
                            } else {
                                System.out.println("O elemento não está na lista");
                            }
                            break;
                        }catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Elemento inválido");
                        }
                    } while (true);
                    break;
                case 11:
                    do {
                        try {
                            System.out.println("Digite o Indice");
                            System.out.println("O elemento no indice é " + lista.buscarElementoIndice(scanner.nextInt()));
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Índice inválido");
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());

                            if (!continuar()) {
                                break;
                            }
                        }
                    } while (true);
                    break;
                case 12:
                    System.out.println("Ordenando a lista de forma crescente");
                    lista.ordenarCrescente();
                    lista.exibir();
                    break;
                case 13:
                    System.out.println("Ordenando a lista de forma decrescente");
                    lista.ordenarDecrescente();
                    lista.exibir();
                    break;
                case 14:
                    System.out.println("Existem " + lista.quantidadeElementos() + " elementos na lista");
                case 15:
                    System.out.println("Dobrado a capacidade da lista");
                    lista.dobrarCapacidade();
                    break;
                case 16:
                    do {
                        try {
                            System.out.println("Digite o elemento que você deseja editar");
                            indice = scanner.nextInt();
                            System.out.println("Digite o novo valor");
                            lista.editarElemento(indice,scanner.nextInt());
                            System.out.println("Elemento editado com succeso");
                            lista.exibir();
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Elemento inválido ou novo valor invalido");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    break;
                case 17:
                    lista.limpar();
                    System.out.println("Lista Limpada");
                    break;
                case 18:
                    try {
                        System.out.println("O primeiro elemento da lista é " + lista.obterPrimeiroElemento());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 19:
                    try {
                        System.out.println("O último elemento da lista é " + lista.obterUltimoElemento());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 20:
                    do {
                        System.out.println("Lista: ");
                        lista.exibir();

                    } while (!continuar());

                    break;
                case 21:
                    do {
                        System.out.println("tem certeza que deseja sair? (1) sim (0) não");
                        try {
                            opcao = scanner.nextInt();
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Opção inválida");
                            continue;
                        }

                        if (opcao < 0 || opcao > 1) {
                            System.out.println("Opção inválida");
                            continue;
                        }

                        if (opcao == 1) {
                            return;
                        } else  {
                            break;
                        }

                    } while (true);
                    break;
            }
        } while (true);

    }
}
