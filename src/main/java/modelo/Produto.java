package modelo;

import dao.ProdutoDAO;
/**
 *
 * @author Beatriz Arevalo Freitas & Ana Luiza Seemann Felisbino
 */
public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;
    private int categoriaId;
    private int qtd_minima;
    private int qtd_maxima;
    private String uni_medida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getQtd_minima() {
        return qtd_minima;
    }

    public void setQtd_minima(int qtd_minima) {
        this.qtd_minima = qtd_minima;
    }

    public int getQtd_maxima() {
        return qtd_maxima;
    }

    public void setQtd_maxima(int qtd_maxima) {
        this.qtd_maxima = qtd_maxima;
    }

    public String getUni_medida() {
        return uni_medida;
    }

    public void setUni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    public Produto() {
        this("", 0.0, 0, null, 0, 0, 0, "");
    }

    public Produto(String nome, double preco, int quantidade, Categoria categoria, int categoriaId, int qtd_minima, int qtd_maxima, String uni_medida) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;  
    this.categoriaId = categoriaId;
    this.qtd_minima = qtd_minima;
    this.qtd_maxima = qtd_maxima;
    this.uni_medida = uni_medida;
}
  
    public boolean insertProdutoBD(String nome, double preco, int quantidade, Categoria categoria,
                                   int categoriaId, String uni_medida, int qtd_minima, int qtd_maxima) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        produto.setCategoria(categoria);
        produto.setCategoriaId(categoriaId);
        produto.setUni_medida(uni_medida);
        produto.setQtd_minima(qtd_minima);
        produto.setQtd_maxima(qtd_maxima);

        return ProdutoDAO.insertProduto(produto);
    }
}
