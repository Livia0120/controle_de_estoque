
package modelo;

import dao.MovimentacaoDAO;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Livia0120
 */
public class Movimentacao {
    private int id;
    private int produto_Id;
    private String tipo; 
    private int quantidade;
    private Timestamp data_Movimentacao; 
    private String observacao;

    public Movimentacao() {
        this(0, 0, "", 0, null, "");
    }
        
    public Movimentacao(int id, int produto_Id, String tipo, int quantidade, Timestamp data_Movimentacao, String observacoes) {
        this.id = id;
        this.produto_Id = produto_Id;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data_Movimentacao = data_Movimentacao;
        this.observacao = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_Id() {
        return produto_Id;
    }

    public void setProduto_Id(int produto_Id) {
        this.produto_Id = produto_Id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Timestamp getData_Movimentacao() {
        return data_Movimentacao;
    }

    public void setData_Movimentacao(Timestamp data_Movimentacao) {
        this.data_Movimentacao = data_Movimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
 
    public boolean adicionarEstoque(int id, int produto_Id, String tipo, int quantidade, Timestamp data_Movimentacao, String observacoes) throws SQLException {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setId(id);
        movimentacao.setProduto_Id(produto_Id);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setData_Movimentacao(data_Movimentacao);
        movimentacao.setObservacao(observacoes);

        return MovimentacaoDAO.adicionarEstoque(movimentacao);

    }

    public boolean removerEstoque(int id, int produto_Id, String tipo, int quantidade, Timestamp data_Movimentacao, String observacoes) throws SQLException {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setId(id);
        movimentacao.setProduto_Id(produto_Id);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setData_Movimentacao(data_Movimentacao);
        movimentacao.setObservacao(observacoes);

        return MovimentacaoDAO.removerEstoque(movimentacao);
    }
}
