import java.util.ArrayList;
import java.util.List;

public class Lista {
    List<Libro>biblioteca;

    public Lista() {
        biblioteca=new ArrayList<>();
    }
    //public void agregar (Libro dato) throws Exception {
       // int tam= biblioteca.size();
        //if (tam==0) {
            //biblioteca.add(dato);
        //}else{
            //if(dato.getIsbn()>biblioteca.get(tam-1).getIsbn()){
               // biblioteca.add(dato);
            //}else {
                //throw new Exception("ISBN no ordenado");
           // }
        //}
    //}

    public  void agregar (Libro dato) throws Exception {
        if(unico(dato)){
            biblioteca.add(dato);
            ordenar();
        }else{
            throw new Exception("Valor duplicado");
        }


    }

    public boolean unico (Libro aux){
        for (Libro l:biblioteca){
            if(l.getIsbn()==aux.getIsbn()){
                return false;
            }
        }
        return true;
    }


    public void ordenar(){
        Libro aux;
        for (int i=0; i< biblioteca.size()-1;i++){
            for (int j=i+1; j<biblioteca.size();j++){
                if (biblioteca.get(i).getIsbn()>biblioteca.get(j).getIsbn()){
                    aux=biblioteca.get(i);
                    biblioteca.set(i,biblioteca.get(j));
                    biblioteca.set(j,aux);
                }
            }
        }

    }
    public ArrayList<Libro> buscar(String texto){
        ArrayList<Libro> resultado=new ArrayList<>();

        for(Libro aux:biblioteca){
            if(aux.getTitulo().contains(texto)){
                resultado.add(aux);
            }
        }
        return resultado;
    }

    public int binario(int isbn){
        int tam=biblioteca.size()-1;
        if(isbn<biblioteca.get(0).getIsbn()||
                isbn>biblioteca.get(tam).getIsbn()){
            return -1;
        }
        int i=0;
        int s=tam;
        int c;
        while (i<=s){
            c=(i+s)/2;
            int valor=biblioteca.get(c).getIsbn();
            if(isbn==valor){
                return c;
            } else if (isbn>valor) {
                i=c+1;
            }else{
                s=c-1;
            }
        }
        return -1;
    }

    public ArrayList<Libro> obtener(){
        return (ArrayList<Libro>) biblioteca;
    }
}
