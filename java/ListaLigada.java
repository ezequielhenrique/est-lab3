public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.insert(5);
        lista.insert(10);
        lista.insert(7);
        lista.insert(8);
        lista.insert(9);

        System.out.println(lista.search(5));
        System.out.println(lista.search(7));
        System.out.println(lista.search(11));

        System.out.println(lista.minimum());
        System.out.println(lista.maximum());

        System.out.println(lista.sucessor(10));
        System.out.println(lista.sucessor(8));
        System.out.println(lista.prodessor(9));
        System.out.println(lista.prodessor(10));

        System.out.println(lista.delete(10));
        System.out.println(lista.search(10));
        System.out.println(lista.delete(9));
        System.out.println(lista.search(9));
        System.out.println(lista.delete(1));
    }

    @Override
    public boolean insert(int chave) {
        if (this.inicio == null) {
            inicio = new No(chave);
            return true;
        } else {
            return insertLast(this.inicio, chave);
        }
    }

    public boolean insertLast(No node, int chave) {
        if (node.getProximo() == null) {
            No newNode = new No(chave);
            node.setProximo(newNode);
            return true;
        } else {
            return insertLast(node.getProximo(), chave);
        }
    }

    @Override
    public boolean delete(int chave) {
        if (this.inicio != null) {
            if (search(chave)) {
                if (inicio.getValor() == chave) {
                    inicio = inicio.getProximo();
                } else{
                    deleteNode(inicio, chave);
                }
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void deleteNode(No node, int chave) {
        if (node.getProximo() == null){
            return;
        } else if (node.getProximo().getValor() == chave){
            node.setProximo(node.getProximo().getProximo());
        } else{
            deleteNode(node.getProximo(), chave);
        }
    }

    @Override
    public boolean search(int chave) {
        if (this.inicio == null) {
            return false;
        } else {
            return searchNode(this.inicio, chave);
        }
    }

    public boolean searchNode(No node, int chave) {
        if (node.getValor() == chave) {
            return true;
        } else if (node.getProximo() == null) {
            return false;
        } else {
            return searchNode(node.getProximo(), chave);
        }
    }

    @Override
    public int minimum() {
        if (this.inicio == null) {
            return -1;
        } else {
            int minimo = this.inicio.getValor();

            if (inicio.getProximo() == null) {
                return minimo;
            } else {
                return searchMinimum(this.inicio, minimo);
            }
        }
    }

    public int searchMinimum(No node, int minimo) {
        int menor = minimo;

        if (node.getProximo() == null) {
            return minimo;
        }
        
        if (node.getProximo().getValor() < minimo) {
            menor = node.getProximo().getValor();
        } 

        return searchMinimum(node.getProximo(), menor);
    }

    @Override
    public int maximum() {
        if (this.inicio == null) {
            return -1;
        } else {
            int maximo = this.inicio.getValor();

            if (inicio.getProximo() == null) {
                return maximo;
            } else {
                return searchMaximum(this.inicio, maximo);
            }
        }
    }

    public int searchMaximum(No node, int maximo) {
        int maior = maximo;

        if (node.getProximo() == null) {
            return maximo;
        }
        
        if (node.getProximo().getValor() > maximo) {
            maior = node.getProximo().getValor();
        } 

        return searchMaximum(node.getProximo(), maior);
    }

    @Override
    public int sucessor(int chave) {
        if (search(chave)) {
            return searchSucessor(this.inicio, chave);
        } else {
            return -1;
        }
    }

    public int searchSucessor(No node, int chave) {
        if (node.getProximo() == null) {
            return -1;
        } else if (node.getValor() == chave) {
            return node.getProximo().getValor();
        } else {
            return searchSucessor(node.getProximo(), chave);
        }
    }

    @Override
    public int prodessor(int chave) {
        if (search(chave)) {
            return searchProdessor(this.inicio, chave);
        } else {
            return -1;
        }
    }

    public int searchProdessor(No node, int chave) {
        if (node.getProximo() == null) {
            return -1;
        } else if (node.getProximo().getValor() == chave) {
            return node.getValor();
        } else {
            return searchProdessor(node.getProximo(), chave);
        }
    }
}
