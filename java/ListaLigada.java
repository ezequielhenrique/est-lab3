public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    public void removeInicio (){
        if (inicio != null)
            inicio = inicio.getProximo();
    }

    public void removeFim (){
        if (inicio == null){
            return;
        }
        if (inicio.getProximo() == null){
            inicio = null;
        }
        removeFim(inicio);
    }

    public void removeFim (No n){
        No proximo = n.getProximo();
        if (proximo.getProximo() == null){
            n.setProximo(null);
            return;
        } else{
            removeFim(proximo);
        }
    }

    public void insereInicio (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        No n = new No(valor);
        n.setProximo(inicio);
        inicio = n;

    }

    public void insereFim (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        insere(inicio, valor);
    }

    public boolean procura (int valor){
        if (inicio == null){
            return false;
        } else {
            return procura(inicio, valor);
        }
    }

    public boolean procura (No n, int valor){
        if (n.getValor() == valor){
            return true;
        } else if (n.getProximo() == null){
            return false;
        } else {
            return procura(n.getProximo(), valor);
        }
    }
    public void insere (No n, int valor){
        if (n.getProximo() == null){
            No novo = new No(valor);
            n.setProximo(novo);
        } else {
            insere(n.getProximo(), valor);
        }
    }

    public void remover(int valor){
        if (inicio == null){
            return;
        }
        if (inicio.getValor() == valor){
            inicio = inicio.getProximo();
            return;
        }
        remover(inicio, valor);
    }

    public void remover(No n, int valor){
        No proximo = n.getProximo();
        if (proximo == null){
            return;
        }
        if (proximo.getValor() == valor){
            n.setProximo(proximo.getProximo());
        } else{
            remover(proximo, valor);
        }
    }

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
        System.out.println(lista.search(20));
        System.out.println(lista.delete(10));
        System.out.println(lista.search(10));
        System.out.println(lista.delete(9));
        System.out.println(lista.search(9));
        System.out.println(lista.delete(1));
        System.out.println(lista.delete(5));
        System.out.println(lista.search(5));

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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int maximum() {
        // TODO Auto-generated method stub
        return 0;
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
