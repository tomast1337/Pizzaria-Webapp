package DataBase;

import java.util.List;
/**
 *
 * @author Nicolas Vycas Nery
 */
public interface DaoInterface {
    public boolean incluir(Object o);
    public boolean alterar(Object o);
    public boolean excluir(Object o);
    public Object buscar(int Codigo1,int Codigo2);
    public List<Object> carregar();
}
