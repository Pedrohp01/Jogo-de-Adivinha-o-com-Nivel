
# 🎮 Jogo de Adivinhação com Níveis de Dificuldade

Um projeto simples em Java onde o jogador tenta adivinhar um número secreto escolhido aleatoriamente pelo programa. O jogo possui diferentes níveis de dificuldade e um sistema de ranking salvo em arquivo `.txt`.

---

## 🧠 Funcionalidades

- Escolha de nível de dificuldade:
  - 🟢 Fácil: número entre 1 e 50
  - 🟡 Médio: número entre 1 e 100
  - 🔴 Difícil: número entre 1 e 500
- Sistema de tentativas com dicas se o número é maior ou menor
- Salvamento do nome do jogador e número de tentativas em `ranking.txt`
- Exibição do ranking ao final da partida, ordenado pelo menor número de tentativas

---

## 📁 Estrutura

```
JogoAdivinhacaoNivel/
├── JogoAdivinhacaoNivel.java
├── ranking.txt
└── README.md
```

---

## ▶️ Como executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SeuUsuario/JogoAdivinhacaoNivel.git
   cd JogoAdivinhacaoNivel
   ```

2. **Compile o código:**
   ```bash
   javac JogoAdivinhacaoNivel.java
   ```

3. **Execute o jogo:**
   ```bash
   java JogoAdivinhacaoNivel
   ```

---

## 📝 Exemplo de uso

```
🎯 Bem-vindo ao Jogo de Adivinhação com Dificuldade!
Digite seu nome: Pedro

Escolha a dificuldade:
1 - Fácil (1 a 50)
2 - Médio (1 a 100)
3 - Difícil (1 a 500)
Digite 1, 2 ou 3: 2

🔢 Tente adivinhar o número entre 1 e 100
Digite seu palpite: 50
🔼 O número secreto é maior!
...

✅ Parabéns, Pedro! Você acertou em 6 tentativas.
📊 Ranking de melhores pontuações:
João - 4 tentativas - Médio
Pedro - 6 tentativas - Médio
```

---

## 🛠️ Tecnologias usadas

- Java SE (sem uso de APIs externas)
- Manipulação de arquivos (`BufferedReader`, `BufferedWriter`)
- Lógica básica e estrutura condicional

---

## 💡 Possíveis melhorias

- Interface gráfica com Java Swing
- Limite de tentativas por dificuldade
- Exibição de posição do jogador no ranking
- Salvamento e carregamento de partidas

---

## 📄 Licença

Este projeto é de código aberto e pode ser usado para fins educacionais e pessoais.
