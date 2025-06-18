
# Sistema de Controle de Estoque
#### Programação de Soluções Computacionais A3
Sistema desenvolvido com a finalidade de gerenciar estoque, podendo o usuário cadastrar produtos, gerenciar estoque, cadastrar categorias, controlar entrada e saída e analizar relatórios.

## Requisitos

### Requisitos funcionais 
- RF01: O sistema permite o cadastro de produtos, contendo nome, preço unitário, unidade, quantidade mínima em estoque, quantidade máxima em estoque, e categoria.
- RF02: O sistema permite o cadastro de categorias (ex: limpeza, enlatados, vegetais, óleos).
- RF03: O sistema permite o reajuste de preços de todos os produtos por um determinado percentual.
- RF04: O sistema permite as operações de inclusão, alteração, consulta e exclusão de produtos.
- RF05: O sistema permite o registro de entrada e saída de produtos.
- RF06: O sistema alerta quando a quantidade de um produto estiver abaixo da quantidade mínima configurada, sugerindo a necessidade de compra.
- RF07: O sistema alerta quando a quantidade de um produto estiver acima da quantidade máxima configurada, sugerindo evitar novas compras.
- RF08: O sistema permite gerar um relatório de Lista de Preços, exibindo todos os produtos em ordem alfabética, com preço, unidade de medida e categoria.
- RF09: O sistema permite gerar um relatório de Balanço Físico/Financeiro, exibindo todos os produtos em ordem alfabética, com quantidade disponível, valor total por produto e valor total do estoque.

### Requisitos não funcionais
- RNF01: O sistema é intuitivo e fácil de usar para o comerciante.
- RNF02: As telas de cadastro e movimentação são claras e de fácil compreensão.
- RNF03: O sistema responde às operações de cadastro, consulta e movimentação de estoque em um tempo aceitável, mesmo com um grande volume de dados.
- RNF04: A geração de relatórios é rápida e eficiente.
- RNF05: O sistema garante a integridade dos dados de estoque, evitando perdas ou inconsistências.
- RNF06: O sistema tem mecanismos para lidar com erros de entrada de dados e evitar falhas críticas.
- RNF07: O código-fonte é bem documentado e estruturado para facilitar a manutenção.

## 👨‍💻Participantes
```javascript
| Nome:                      | user:              | RA:         |            
|----------------------------|                    |-------------|
| Ana Luiza Seemann Felisbino| AnaLuiza2412       | 10724268572 | 
| Beatriz Arevalo Freitas    | biaArevaloFreitas  | 10725115625 |
| Gustavo Godinho            | gustavo-godinho    | 10724268995 | 
| Lívia de Oliveira          | Livia0120          | 10725115228 |
| Vitor Steinbach            | steinbachvitor     | 10724268585 | 

```


## 🛠 Tecnologias utilizadas
- Apache NetBeans IDE 26
- MySQL 8.0
- Java 24
- JDBC 

## 🗄️ Configuração do Banco de Dados
Credenciais do Banco de Dados MySQL
```bash
  User:  root
  Senha: root
```
Repositório de script do banco de dados: 
[control_estoque_a3](https://github.com/Livia0120/controle_de_estoque/blob/main/controle_estoque_a3-.sql)
