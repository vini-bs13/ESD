# Explicando labirinto



````
Crie uma nova pilha
Localize o caractere 'P' na grade
Insira sua localização na pilha
Enquanto a pilha não estiver vazia
Retire uma localização (linha, coluna) da pilha
Se a grade contiver 'T' neste local, então
Um caminho foi encontrado
Retorne True
Caso contrário, se este local não contiver um ponto
Coloque um ponto na grade neste local
Examine as células adjacentes a esta e para cada uma
que contém um espaço, insira sua localização na pilha
Retorne False
````

Dentro de uma função `resolverLabirinto()` criei uma pilha de strings:

````
Stack<String>  pilha = new Stack<>(10);
````
Para pegar o `'P'` eu usei um `push` da linha e coluna inicial, separados por uma vírgula que será importante.
````
pilha.push(linhaInicial + "," + colunaInicial);
````
Para começar o looping:
````
while(!pilha.isEmpty()){
````

Eu atribuí a localização retirada na variável ``atual``, depois criei um array com 2 elementos, a linha e a coluna.
Eu criei ele a partir de um `split` que remove a vírgula inserida anteriormente,
assim a poição 0 do array fica para a linha e a posição 1
fica para a coluna.
````
String atual = pilha.pop();
String[] linhaColuna = atual.split(",");
int linha = Integer.parseInt(linhaColuna[0]);
int coluna = Integer.parseInt(linhaColuna[1]);
````

Para verificar se o labirinto achou o lugar final:

````
if(mapa[linha][coluna] == 'T'){
    return  true;
}
````

A próxima verificação é colocar um ponto (caso não tenha) no caminho percorrido, e
ele não pode ser colocado no `'P'`
````
if(mapa[linha][coluna] != '.'){
    if(mapa[linha][coluna] != 'P'){
         mapa[linha][coluna] = '.';
    }
}
````

Agora para percorrer espaços eu criei um array com as 4 direções possíveis.
````
int[][] direcoes = {
           {-1, 0},
           {1, 0},
           {0, 1},
           {0, -1},
};
````

A partir disso fiz um `for` para percorrer as direções

````
for (int[] lados : direcoes) {
````

Nesse for eu pego a linha e coluna da variável que chamei de `atual`, e somo com o lado escolhido.
Logo que ele entrará no `for`, e com essa soma é possível chegar na próxima linha/coluna.

````
int novaLinha = linha + lados[0];
int novaColuna = coluna + lados[1];
````

Para garantir que o próximo ponto esteja dentro da matriz, fiz um `if`, verificando
se o valor é maior que 0 (menor significa fora), e menor que o máximo de elementos.
````
if (novaLinha >= 0 && novaLinha < mapa.length &&
 novaColuna >= 0 && novaColuna < mapa[0].length) {
````

Com isso é montado o próximo passo

````
char proximoPasso = mapa[novaLinha][novaColuna];
````

E verifica se deve empilhar, isso significa se o elemento é `" "` ou `"T"`

````
if (proximoPasso == ' ' || proximoPasso == 'T') {
    pilha.push(novaLinha + "," + novaColuna);
}
````

Com isso no final ele retorna false se não existir um caminho possível.

````
return false;
````

## Desafio

1 - Após as verificações se é um lugar possível ou não, ele adiciona na pilha com um push,
logo que ele só vai entrar no `if` permitido.

2 e 3 - Caso ele não encontre um caminho possível, ele vai continuar no while se não for vazio,
o que significa que ele vai voltar uma casa com o `pop` e fazer as verificações novamente.
E agora a casa que foi explorada anteriormente está com um `.` e não entrará no if novamente.
O `pop` é responsável for fazer o retrocesso em caso de não ter outras possibilidades.

4 - Já que no último `if` dentro do `for` ele também checa se for `'T'`, ele adiciona na pilha esse próximo passo
e no próximo looping do `while` ele vai entrar na condicional de `'T'` e retornar `true`


- O pior caso seria não ter um final ou ter que percorrer todos os caminhos do labirinto,
logo que isso faria o sistema rodar todas as possibilidades antes de dar erro.
 