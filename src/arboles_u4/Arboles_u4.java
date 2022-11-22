package arboles_u4;
public class Arboles_u4 
{
    public static void main(String[] args) 
    {
        arbol miArbol = new arbol();
        
        miArbol.eliminar(100);
        
        if(miArbol.verificarVacio())
            System.out.println("Está vació!");
        
        miArbol.insertarNodo(62);
        miArbol.insertarNodo(35);
        miArbol.insertarNodo(80);
        miArbol.insertarNodo(22);
        miArbol.insertarNodo(50);
        miArbol.insertarNodo(65);
        miArbol.insertarNodo(90);
        
        
        miArbol.inorden(miArbol.getRoot());
        System.out.println("");
        miArbol.preorden(miArbol.getRoot());
        System.out.println("");
        miArbol.postorden(miArbol.getRoot());
        
        System.out.println("");
        
        if(miArbol.buscar(22))
            System.out.println("El elemento 22 sí está en el árbol.");
        else
            System.out.println("El elemento 22 no se encuentra en el árbol.");
        
        if(miArbol.eliminar(80))
            System.out.println("Se elimino correctamente el elemento 80!");
        else
            System.out.println("Dato no encontrado!");
        
        miArbol.inorden(miArbol.getRoot());
    }
}
