USE controle_de_estoque;

-- Criação da tabela de categorias
CREATE TABLE Categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    embalagem VARCHAR(50) NOT NULL
);

-- Criação da tabela de produtos
CREATE TABLE Produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    qtd_minima INT NOT NULL,
    qtd_maxima INT NOT NULL,
    categoria_id INT NOT NULL,
    unidade_medida VARCHAR(10) NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES Categorias(id)
);

-- Criação da tabela de movimentações
CREATE TABLE Movimentacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT NOT NULL,
    tipo ENUM('entrada', 'saida') NOT NULL,
    quantidade INT NOT NULL,
    data_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    observacoes TEXT NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES Produtos(id)
);

SELECT 
    p.nome AS nome_produto,
    p.preco,
    p.quantidade,
    p.qtd_minima,
    p.qtd_maxima,
    c.nome AS categoria
FROM Produtos p
JOIN Categorias c ON p.categoria_id = c.id;

SELECT * FROM Produtos;
SELECT * FROM Categorias;
SELECT * FROM Movimentacoes;
