import gameSection.Game;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Aviso: Nenhum parâmetro foi passado.");
            System.out.println("Use '--help' para ver as opções.");
            return;
        }

        if (args.length == 1 && args[0].equals("--help")) {
            System.out.print(
                    "Uso: java Main <dificuldade> <num de heróis> <num de vilões> \n" +
                    "<dificuldade> nível de dificuldade do jogo:                  \n" +
                    "     - 1: Muito Fácil                                        \n" +
                    "     - 2: Fácil                                              \n" +
                    "     - 3: Normal                                             \n" +
                    "     - 4: Difícil                                            \n" +
                    "     - 5: Muito Difícil                                      \n" +
                    "     - 6: Extremamente Difícil                               \n" +
                    "     - 7: Impossível                                         \n" +
                    "<num de heróis> número de pókemon aliados                    \n" +
                    "<num de vilões> número de pókemon inimigos                   \n\n" +
                    "Exemplo: java Main 3 5 5                                     \n");
            return;
        }

        try {
            if (args.length < 3) {
                throw new IllegalArgumentException("Erro: Faltam parâmetros. Use '--help' para ver as opções.");
            }

            int difficultyLevel = Integer.parseInt(args[0]);
            int numberOfHeros = Integer.parseInt(args[1]);
            int numberOfVillains = Integer.parseInt(args[2]);

            if (difficultyLevel < 1 || numberOfHeros < 1 || numberOfVillains < 1) {
                throw new IllegalArgumentException("Erro: Todos os valores devem ser maiores ou iguais à 1.");
            }

            Game game = new Game();
            game.run(difficultyLevel, numberOfHeros, numberOfVillains);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Todos os parâmetros devem ser números inteiros.");
            System.out.println("Use '--help' para ver as opções.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Use '--help' para ver as opções.");
        }
    }
}