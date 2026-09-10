# Questões

## Questão - 1
Por que essa abordagem usando um array de instâncias da classe Vetor torna a busca de um contato mais rápida em comparação com a versão anterior (uma única lista contendo todos os contatos)?


### Resposta: 

Pegando como exemplo um sistema com um milhão de contatos cadastrados, ao percorrer
todo o vetor temos que procurar um contato no meio de um milhão, mas se a busca for dividida
em 26 arrays diferentes, esse número se torna menor, o que significa mais eficiente e menos custoso.


## Questão - 2
O que acontece com o desempenho da busca se a maioria dos contatos cadastrados começar com a mesma letra (ex: centenas de nomes iniciando com a letra "M")? O sistema continuará rápido? Justifique.

### Resposta

Dependendo do sistema no geral ele pode continuar rápido, considerando
que um sistema tenha muitos nomes que comecem com a letra
"M", ele será menos eficiente do que um sistema com diversos nomes
espalhados, logo parar decidir qual o array mais eficiente para se aplicar, é preciso
analisar a situação e a necessidade.
Se tratando do "M" talvez fosse mais eficiente usar outro sistema de organização,
contudo se diversos nomes forem registrados, é melhor usar o sistema de 26 arrays.

