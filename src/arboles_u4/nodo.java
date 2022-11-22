package arboles_u4;
public class nodo 
{
    private int dato;
    nodo izquierdo;
    nodo derecho;
    public nodo()
    {
        izquierdo = null;
        derecho = null;
    }
    public void setData(int info)
    {
        this.dato = info;
    }
    public int getData()
    {
        return this.dato;
    }
}
