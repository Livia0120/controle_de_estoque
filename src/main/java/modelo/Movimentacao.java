
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
    private int produtoId;
    private String tipo; 
    private int quantidade;
    private Timestamp dataMovimentacao; 
    private String observacoes;

    public Movimentacao() {
        this(0, 0, "", 0, null, "");
    }
        
    public Movimentacao(int id, int produtoId, String tipo, int quantidade, Timestamp dataMovimentacao, String observacoes) {
        this.id = id;
        this.produtoId = produtoId;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
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

    public Timestamp getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Timestamp dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
 
    public boolean adicionarEstoque(int id, int produtoId, String tipo, int quantidade, Timestamp dataMovimentacao, String observacoes) throws SQLException {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setId(id);
        movimentacao.setProdutoId(produtoId);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setDataMovimentacao(dataMovimentacao);
        movimentacao.setObservacoes(observacoes);

        return MovimentacaoDAO.adicionarEstoque(movimentacao);

    }

    public boolean removerEstoque(int id, int produtoId, String tipo, int quantidade, Timestamp dataMovimentacao, String observacoes) throws SQLException {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setId(id);
        movimentacao.setProdutoId(produtoId);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setDataMovimentacao(dataMovimentacao);
        movimentacao.setObservacoes(observacoes);

        return MovimentacaoDAO.removerEstoque(movimentacao);
    }
}
