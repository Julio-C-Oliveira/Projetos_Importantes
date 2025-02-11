Repositório criado para armazenar os trabalhos da diciplina Programação II
## Requisitos do Jogo de Turno
1. Cada héroi e monstro deverá ter, pelo menos os seguintes atributos:
	- Nome.
	- Pontos de Vida.
	- Força de Ataque.
	- Defesa.
 	- Destreza. Quando maior, mais chance de acertar um ataque.
 	- Velocidade. Quanto maior, mais chance de desviar de um ataque.
 	- Os atributos devem ser definidos aléatoriamente dentro de um intervalo pré definido.
2. Cada héroi e monstro deverá ter, pelo menos as seguintes implementações:
   	- Um construtor.
	- Getters e Setters.
	- Um método abstrato chamado realizarAtaque().
	- Um método estático que gere um héroi ou um monstro.
3. Acomode o jogo dentro de uma classe chamada Game, que deve acomodar os seguintes requisitos:
	- Estado do Jogo.
	- N° de Hérois.
	- N° de Monstros.
	- Player com maior/menor atributo específico no campo de batalha.
	- Métodos para iniciar e finalizar o jogo.
	- Controle de fluxo.
	- Gerenciar os turnos.
	- Armazenar os Logs do Jogo, crie uma classe Log para este requisito.
	- Diferentes níveis de dificuldade, com monstros mais fortes dependendo do nível.
4. Acomode os Turnos dentro de uma classe chamada Turno, que deve atender os seguintes requisitos:
	- Realizar os turnos do Jogo.
	- Controlar as ações dos players.
	- Ordenar os players com base em algum atributo.
	- Armazenar o resultado do ataque que será um ENUM.
5. O Enum deve modelar o resultado de um Ataque para os valores:
	- ERROU.
	- ACERTOU.
	- CRITICAL_HIT.
	- Quando um Player ataca o outro a destreza deve ser levada em consideração.
6. A batalha deve ser simulada automáticamente:
	- Mecanismos que permitem visualizar o resultado do jogo devem ser implementados.
	- Método pra visualizar as ocorrências ao longo do jogo, a partir dos logs.
7. Implemente uma inteligência artificial naive para os monstros, tais como:
	- Atacar o herói com o menor atributo.
		- Menor HP.
		- Menor Defesa.
	- Atacar o mesmo inimigo.
8. Realizar tratamento de exceções sempre que achar necessário.

## Progresso da Implemenação	
1. Cada héroi e monstro deverá ter, pelo menos os seguintes atributos, (Feito):
	- [x] Nome.
	- [x] Pontos de Vida.
	- [x] Força de Ataque.
	- [x] Defesa.
 	- [x] Destreza. Quando maior, mais chance de acertar um ataque.
 	- [x] Velocidade. Quanto maior, mais chance de desviar de um ataque.
 	- [x] Os atributos devem ser definidos aléatoriamente dentro de um intervalo pré definido.
2. Cada héroi e monstro deverá ter, pelo menos as seguintes implementações:
   	- [x] Um construtor.
	- [x] Getters e Setters.
   	- [ ] Um método abstrato chamado realizarAtaque(), o método na nossa se chama carryOutAttack, é válido?.
	- [ ] Um método estático que gere um héroi ou um monstro, o nosso método não gera especificamente um ou outro ainda.
3. Acomode o jogo dentro de uma classe chamada Game, que deve acomodar os seguintes requisitos:
	- [ ] Estado do Jogo.
	- [ ] N° de Hérois.
	- [ ] N° de Monstros.
	- [ ] Player com maior/menor atributo específico no campo de batalha.
	- [ ] Métodos para iniciar e finalizar o jogo.
	- [ ] Controle de fluxo.
	- [ ] Gerenciar os turnos.
	- [ ] Armazenar os Logs do Jogo, crie uma classe Log para este requisito.
	- [ ] Diferentes níveis de dificuldade, com monstros mais fortes dependendo do nível.
4. Acomode os Turnos dentro de uma classe chamada Turno, que deve atender os seguintes requisitos:
	- [ ] Realizar os turnos do Jogo.
	- [ ] Controlar as ações dos players.
	- [ ] Ordenar os players com base em algum atributo.
	- [ ] Armazenar o resultado do ataque que será um ENUM.
5. O Enum deve modelar o resultado de um Ataque para os valores: (Feito)
	- [x] ERROU.
	- [x] ACERTOU.
	- [x] CRITICAL_HIT.
6. A batalha deve ser simulada automáticamente:
	- [ ] Mecanismos que permitem visualizar o resultado do jogo devem ser implementados.
	- [ ] Método pra visualizar as ocorrências ao longo do jogo, a partir dos logs.
7. Implemente uma inteligência artificial naive para os monstros, tais como:
	- [ ] Atacar o herói com o menor atributo.
		- [ ] Menor HP.
		- [ ] Menor Defesa.
	- [ ] Atacar o mesmo inimigo.
8. Realizar tratamento de exceções sempre que achar necessário.
	      
