package DataBase;

import negocio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Nicolas Vycas Nery
 */
public class DaoCliente implements DaoInterface {
    DaoPedido dPedido;
    public DaoCliente(){
        String tabela = "CREATE TABLE IF NOT EXISTS public.clientes" +
                        "(" +
                        "    id integer NOT NULL," +
                        "    email character varying NOT NULL," +
                        "    nome character varying NOT NULL," +
                        "    senha character varying(64) NOT NULL," +
                        "    status character varying NOT NULL," +
                        "    PRIMARY KEY (id)" +
                        ");" +
                        "" +
                        "ALTER TABLE public.clientes" +
                        "    OWNER to postgres;" +
                        "COMMENT ON TABLE public.clientes" +
                        "    IS 'Tabela guarda informações dos usuários/clientes ';";
        try {
            Connection conn = ConnectionDB.getInstancia().getConn();
            try (PreparedStatement pS = conn.prepareStatement(tabela)) {
                pS.execute();
            }
            ConnectionDB.getInstancia().setConn(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public boolean incluir(Object o) {
        boolean result = true;
        Cliente cliente = (Cliente) o;
        String querry = "Insert Into Venda (Numero,Data,Cliente_Codigo) values (?,?,?)";
        try {
            Connection con = ConnectionDB.getInstancia().getConn();
            try (PreparedStatement pS = con.prepareStatement(querry)) {
                pS.execute();
            }
            ConnectionDB.getInstancia().setConn(con);
        } catch (SQLException e) {
            result = false;
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean alterar(Object o) {
        boolean result = true;
        Cliente cliente = (Cliente) o;

        return result;
    }

    @Override
    public boolean excluir(Object o) {
        boolean result = true;
        Cliente cliente = (Cliente) o;

        return result;
    }

    @Override
    public Object buscar(int Codigo1, int Codigo2) {

        throw new UnsupportedOperationException("Não Implementado");
    }

    @Override
    public List<Object> carregar() {
        throw new UnsupportedOperationException("Não Implementado");
    }
}
