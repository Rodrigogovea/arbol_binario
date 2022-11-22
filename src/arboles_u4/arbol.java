package arboles_u4;
public class arbol 
{
    private nodo root;    
    public arbol()
    {
        root = null;
    }
    
    public nodo getRoot()
    {
        return this.root;
    }
    public void insertarNodo(int dato)
    {
        nodo nuevo = new nodo();
        nuevo.setData(dato);
        if(root==null)
        {
            root = nuevo;
        }
        else
        {
            nodo temp = root;
            nodo padre;
            while(true)
            {
                padre = temp;
                if(dato<temp.getData())
                {
                    temp = temp.izquierdo;
                    if(temp==null)
                    {
                        padre.izquierdo = nuevo;
                        return;
                    }
                }
                else
                {
                    temp=temp.derecho;
                    if(temp==null)
                    {
                        padre.derecho = nuevo;
                        return;
                    }
                }
            }
        }
            
    }
    
    public void inorden(nodo nodoActual)
    {
        if(nodoActual!=null)
        {
            inorden(nodoActual.izquierdo);
            System.out.print(nodoActual.getData() + ",");
            inorden(nodoActual.derecho);
        }
    }
    
    public void preorden(nodo nodoActual)
    {
        if(nodoActual!=null)
        {
            System.out.print(nodoActual.getData() + ",");
            preorden(nodoActual.izquierdo);
            preorden(nodoActual.derecho);
        }
    }
    
    public void postorden(nodo nodoActual)
    {
        if(nodoActual!=null)
        {
            postorden(nodoActual.izquierdo);
            postorden(nodoActual.derecho);
            System.out.print(nodoActual.getData() + ",");
        }
    }
    
    
    public boolean buscar(int buscado)
    {
        if(verificarVacio())
        {
            System.out.println("El árbol está vació!!!");
            return false;
        }
        else
        {
            nodo auxiliar = root;
            while(auxiliar.getData()!=buscado)
            {
                if(buscado<auxiliar.getData())
                {
                    auxiliar = auxiliar.izquierdo;
                }
                else
                {
                    auxiliar = auxiliar.derecho;
                }
                if(auxiliar==null)
                {
                    return false;
                }
            }
            System.out.println(auxiliar.getData());
        return true;
        }
    }
    
    public boolean eliminar(int dato)
    {
        if(verificarVacio())
        {
            System.out.println("El árbol está vacío!!!");
            return false;
        }
        else
        {
            nodo aux = root;
            nodo padre = aux;
            boolean hizquierdo = true;
            while(aux.getData()!=dato)
            {
                padre = aux;
                if(dato<aux.getData())
                {
                    hizquierdo = true;
                    aux = aux.izquierdo;
                }
                else
                {
                    hizquierdo=false;
                    aux = aux.derecho;
                }
                if(aux == null)
                {
                    return false;
                }
            }
            if(aux.izquierdo == null && aux.derecho == null)
            {
                if(aux == root)
                {
                    root = null;
                }
                else if(hizquierdo)
                {
                    padre.izquierdo = null;
                }
                else
                {
                    padre.derecho = null;
                }
            }
            else if(aux.derecho == null)
            {
                if(aux == root)
                {
                    root = aux.izquierdo;
                }
                else if(hizquierdo)
                {
                    padre.izquierdo = aux.izquierdo;
                }
                else
                {
                    padre.derecho = aux.izquierdo;
                }
            }
            else if(aux.izquierdo == null)
            {
                if(aux == root)
                {
                    root = aux.derecho;
                }
                else if(hizquierdo)
                {
                    padre.izquierdo = aux.derecho;
                }
                else
                {
                    padre.derecho = aux.izquierdo;
                }
            }
            else
            {
                nodo theOne = obtenerSiguiente(aux);
                if(aux == root)
                {
                    root = theOne;
                }
                else if(hizquierdo)
                {
                    padre.izquierdo = theOne;
                }
                else
                {
                    padre.derecho = theOne;
                }
                theOne.izquierdo = aux.izquierdo;
            }
            return true;
        }
    }
    
    
    public nodo obtenerSiguiente(nodo siguiente)
    {
        nodo padre = siguiente;
        nodo next = siguiente;
        nodo aux = siguiente.derecho;
        
        while(aux!=null)
        {
            padre = next;
            next = aux;
            aux = aux.izquierdo;
        }
        if(next!=siguiente.derecho)
        {
            padre.izquierdo = next.derecho;
            next.derecho = siguiente.derecho;
        }
        System.out.println("The one is: " + next.getData());
        return next;
    }
        
    public boolean verificarVacio()
    {
        if(root==null)
            return true;
        return false;
    }
}
