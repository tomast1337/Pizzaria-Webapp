package negocio;

public class Pedido {
    private Cliente cliente;
    private String endereco;
    private String detalhePedido;
    private String data;

    public Pedido(Cliente cliente, String endereco, String detalhePedido, String data) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.detalhePedido = detalhePedido;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDetalhePedido() {
        return detalhePedido;
    }

    public void setDetalhePedido(String detalhePedido) {
        this.detalhePedido = detalhePedido;
    }
}
