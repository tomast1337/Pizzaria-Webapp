package negocio;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class Cliente {
    /*Id de usuario*/
        private int id;
    /*Email do Usuario*/
        private String email;
    /*Senha em hash sha256*/
        private String senha;
    /*Cliente, Adminstrador, Banido*/
        private String stautus;
    /*Nome do usuario*/
        private String nome;
    /*pedidos Passados*/
        private ArrayList<Pedido> pedidos;

    public Cliente(int id, String email, String senha, String stautus, String nome, ArrayList<Pedido> pedidos) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.stautus = stautus;
        this.nome = nome;
        this.pedidos = pedidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        this.senha = Base64.getEncoder().encodeToString(digest.digest(senha.getBytes(StandardCharsets.UTF_8)));
    }

    public String getStautus() {
        return stautus;
    }

    public void setStautus(String stautus) {
        this.stautus = stautus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
