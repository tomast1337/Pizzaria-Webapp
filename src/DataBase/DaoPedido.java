package DataBase;

import negocio.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Nicolas Vycas Nery
 */
public class DaoPedido implements DaoInterface {
    public DaoPedido(){
        String tabela = "CREATE TABLE IF NOT EXISTS public.pedidos" +
                        "(" +
                        "    idpedido integer NOT NULL," +
                        "    endereco character varying COLLATE pg_catalog.\"default\" NOT NULL," +
                        "    data date NOT NULL," +
                        "    pedido json NOT NULL," +
                        "    idcliente integer NOT NULL," +
                        "    CONSTRAINT pedidos_pkey PRIMARY KEY (idpedido)," +
                        "    CONSTRAINT clientepedidos FOREIGN KEY (idpedido)" +
                        "        REFERENCES public.clientes (id) MATCH SIMPLE" +
                        "        ON UPDATE NO ACTION" +
                        "        ON DELETE NO ACTION" +
                        "        NOT VALID" +
                        ")" +
                        "" +
                        "TABLESPACE pg_default;" +
                        "" +
                        "ALTER TABLE public.pedidos" +
                        "    OWNER to postgres;" +
                        "COMMENT ON TABLE public.pedidos" +
                        "    IS 'Tabela armazena pedidos dos clientes , unica tabela que pode ser acessada por clientes ';";
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
        Pedido pedido = (Pedido) o;
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
        throw new UnsupportedOperationException("Não Implementado");
    }

    @Override
    public boolean excluir(Object o) {
        throw new UnsupportedOperationException("Não Implementado");
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
