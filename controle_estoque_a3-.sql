drop database controle_de_estoque

create database controle_de_estoque;

USE controle_de_estoque;

-- Criação da tabela de categorias
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    embalagem VARCHAR(50) NOT NULL
);

-- Criação da tabela de produtos
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    qtd_minima INT NOT NULL,
    qtd_maxima INT NOT NULL,
    categoria_id INT NOT NULL,
    unidade_medida VARCHAR(10) NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

-- Criação da tabela de movimentações
CREATE TABLE movimentacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT NOT NULL,
    tipo ENUM('entrada', 'saida') NOT NULL,
    quantidade INT NOT NULL,
    data_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    observacoes TEXT NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
/* 
SELECT 
    p.nome AS nome_produto,
    p.preco,
    p.quantidade,
    p.qtd_minima,
    p.qtd_maxima,
    c.nome AS categoria
FROM produtos p
JOIN categorias c ON p.categoria_id = c.id;

SELECT * FROM Produtos;
SELECT * FROM categorias;
SELECT * FROM movimentacoes;
 */
