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
            No no = new No(chave);
            no.setProximo(inicio);

            inicio = no;

            return true;
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

    public void deleteNode(No no, int chave) {
        No proximo = no.getProximo();
        if (proximo == null){
            return;
        }
        if (proximo.getValor() == chave){
            no.setProximo(proximo.getProximo());
        } else{
            deleteNode(proximo, chave);
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

    public boolean searchNode(No no, int chave) {
        if (no.getValor() == chave) {
            return true;
        } else if (no.getProximo() == null) {
            return false;
        } else {
            return searchNode(no.getProximo(), chave);
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
                return comparaMinimo(this.inicio, minimo);
            }
        }
    }

    public int comparaMinimo(No node, int minimo) {
        int menor = minimo;

        if (node.getProximo() == null) {
            return minimo;
        }
        
        if (node.getProximo().getValor() < minimo) {
            menor = node.getProximo().getValor();
        } 

        return comparaMinimo(node.getProximo(), menor);
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
                return comparaMaximo(this.inicio, maximo);
            }
        }
    }

    public int comparaMaximo(No node, int maximo) {
        int maior = maximo;

        if (node.getProximo() == null) {
            return maximo;
        }
        
        if (node.getProximo().getValor() > maximo) {
            maior = node.getProximo().getValor();
        } 

        return comparaMaximo(node.getProximo(), maior);
    }

    @Override
    public int sucessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }
}
