# FiapRide - Exercícios de POO

Repositório dos exercícios da matéria de Programação Orientada a Objetos. Aqui tem o projeto FiapRide que a gente monta em aula e a minha classe PowerBank, que é o objeto que eu escolhi pro desafio.

## Meu objeto: PowerBank

Escolhi representar um power bank (carregador portátil). É um objeto que eu uso todo dia e que tem um estado mudando o tempo todo: a bateria sobe quando ele fica na tomada e desce quando eu plugo o celular nele.

### Atributos

* modelo (String): nome do carregador
* cargaAtual (int): porcentagem de bateria, de 0 a 100
* emUso (boolean): fica true quando tem um aparelho conectado

Deixei de fora coisas como cor, peso e tipo de entrada porque nenhum método precisa desses dados pra decidir alguma coisa. Seguindo a ideia de abstração, se o sistema não usa o dado pra processar uma regra, ele vira ruído.

### Métodos

**carregarBateria(int minutosNaTomada)**
Coloca o power bank na tomada. Cada minuto recupera 1% de bateria. Não aceita tempo zero ou negativo, não deixa carregar com um aparelho plugado e a carga nunca passa de 100%.

**conectarDispositivo()**
Pluga um aparelho no power bank, ou seja, o emUso vira true. Não deixa conectar dois aparelhos ao mesmo tempo e exige pelo menos 5% de bateria pra aceitar a conexão.

**consumirBateria(int minutosDeUso)**
Simula o aparelho conectado gastando a bateria, 1% por minuto. Só funciona se tiver um aparelho conectado. Se pedir mais minutos do que a bateria aguenta, a operação é recusada inteira e nada muda, então a carga nunca fica negativa.

**desconectarDispositivo()**
Tira o aparelho e o emUso volta pra false. Só funciona se tiver alguma coisa conectada.

### Exemplo de uso

```java
PowerBank meuPowerBank = new PowerBank("Samsung 20000mAh", 40);

meuPowerBank.carregarBateria(30);      // 40% vira 70%
meuPowerBank.conectarDispositivo();
meuPowerBank.consumirBateria(20);      // 70% vira 50%
meuPowerBank.desconectarDispositivo();
```

## Como rodar

Abrir o projeto no Eclipse e rodar a classe SistemaPrincipal (botão direito, Run As, Java Application). Ela roda primeiro a parte do Passageiro que fizemos em aula e depois os testes do PowerBank, chamando os métodos com valores válidos e inválidos pra mostrar as regras de negócio funcionando.

## Por que não mexer direto no atributo

Se qualquer parte do código pudesse fazer meuPowerBank.cargaAtual = -50, o objeto ficaria num estado que não existe no mundo real. Deixando a alteração dentro dos métodos, a validação com if roda sempre, não importa quem chamou. É isso que protege o estado do objeto.