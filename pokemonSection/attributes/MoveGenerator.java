package pokemonSection.attributes;

import pokemonSection.constants.StatusCondition;
import pokemonSection.constants.Type;

import java.util.HashMap;
import java.util.Map;

import static pokemonSection.attributes.MoveBase.createMove;

public class MoveGenerator {
    public MoveGenerator() {}

    // Criar todos os movimentos que estarão disponiveis.
    public static Map<Type, MoveBase[]> generateAllMoves() {
        Map<Type, MoveBase[]> movementsDict = new HashMap<>();

        // Tipo NENHUM.
        movementsDict.put(Type.NORMAL, new MoveBase[]{
                createMove("Barragem", (short) 175, (byte) 20, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Rasteira", (short) 100, (byte) 50, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Voadora", (short) 200, (byte) 10, Type.NORMAL, StatusCondition.CONFUSION, (byte) 1, StatusCondition.NENHUM, (byte) 0),
                createMove("Investida", (short) 75, (byte) 100, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Technician", (short) 0, (byte) 15, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.EXCITED, (byte) 3),
                createMove("Immunity", (short) 0, (byte) 7, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.IMMUNITY, (byte) 3)});

        // Tipo FIRE.
        movementsDict.put(Type.FIRE, new MoveBase[]{
                createMove("Heavy Fire", (short) 250, (byte) 5, Type.FIRE, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Incendiar", (short) 50, (byte) 50, Type.FIRE, StatusCondition.BURN, (byte) 3, StatusCondition.NENHUM, (byte) 0),
                createMove("Warm Up", (short) 0, (byte) 10, Type.FIRE, StatusCondition.NENHUM, (byte) 0, StatusCondition.WARMUP, (byte) 3)
        });

        // Tipo WATER.
        movementsDict.put(Type.WATER, new MoveBase[]{
                createMove("Torrent", (short) 25, (byte) 5, Type.WATER, StatusCondition.NENHUM, (byte) 0, StatusCondition.HEALING, (byte) 3),
                createMove("Tsunami", (short) 200, (byte) 5, Type.WATER, StatusCondition.DROWNING, (byte) 3, StatusCondition.NENHUM, (byte) 0),
                createMove("Bolha", (short) 50, (byte) 100, Type.WATER, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo GRASS.
        movementsDict.put(Type.GRASS, new MoveBase[]{
                createMove("Chlorophyll", (short) 0, (byte) 20, Type.GRASS, StatusCondition.NENHUM, (byte) 0, StatusCondition.HEALING, (byte) 3),
                createMove("Root", (short) 75, (byte) 5, Type.GRASS, StatusCondition.PARALYSIS, (byte) 3, StatusCondition.HEALING, (byte) 3),
                createMove("Turbilhão de Folhas", (short) 175, (byte) 7, Type.GRASS, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo ELECTRIC.
        movementsDict.put(Type.ELETRIC, new MoveBase[]{
                createMove("Eletrificar", (short) 55, (byte) 20, Type.ELETRIC, StatusCondition.PARALYSIS, (byte) 2, StatusCondition.ELECTRIFIED, (byte) 2),
                createMove("Rajada do Trovão", (short) 250, (byte) 7, Type.ELETRIC, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Estático", (short) 0, (byte) 7, Type.ELETRIC, StatusCondition.CONFUSION, (byte) 3, StatusCondition.IMMUNITY, (byte) 1) //Talvez não possa atacar, mas não pode ser atingido.
        });

        // Tipo ICE.
        movementsDict.put(Type.ICE, new MoveBase[]{
                createMove("Snow Cloak", (short) 0, (byte) 8, Type.ICE, StatusCondition.CONFUSION, (byte) 3, StatusCondition.NENHUM, (byte) 0),
                createMove("Freezing", (short) 0, (byte) 5, Type.ICE, StatusCondition.SLEEP, (byte) 2, StatusCondition.NENHUM, (byte) 0),
                createMove("Nevasca", (short) 275, (byte) 7, Type.ICE, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo FIGHTING.
        movementsDict.put(Type.FIGHTING, new MoveBase[]{
                createMove("Guts", (short) 375, (byte) 3, Type.FIGHTING, StatusCondition.POISON, (byte) 2, StatusCondition.CONFUSION, (byte) 3),
                createMove("Iron Punch", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NENHUM, (byte) 0, StatusCondition.FIGHTSPIRIT, (byte) 3),
                createMove("Erguer Guarda", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NENHUM, (byte) 0, StatusCondition.SOLIDIFIED, (byte) 3)
        });

        // Tipo POISON.
        movementsDict.put(Type.POISON, new MoveBase[]{
                createMove("Poison Point", (short) 5, (byte) 5, Type.POISON, StatusCondition.POISON, (byte) 2, StatusCondition.HEALING, (byte) 2),
                createMove("Sopro Ácido", (short) 150, (byte) 15, Type.POISON, StatusCondition.POISON, (byte) 3, StatusCondition.NENHUM, (byte) 0),
                createMove("Disperse", (short) 0, (byte) 7, Type.POISON, StatusCondition.POISON, (byte) 2, StatusCondition.IMMUNITY, (byte) 1)
        });

        // Tipo GROUND.
        movementsDict.put(Type.GROUND, new MoveBase[]{
                createMove("Sand Veil", (short) 100, (byte) 20, Type.GROUND, StatusCondition.CONFUSION, (byte) 3, StatusCondition.NENHUM, (byte) 0),
                createMove("Tempestade de Areia", (short) 250, (byte) 10, Type.GROUND, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Dissolver", (short) 0, (byte) 7, Type.GROUND, StatusCondition.NENHUM, (byte) 0, StatusCondition.IMMUNITY, (byte) 2)
        });

        // Tipo FLYING.
        movementsDict.put(Type.FLYING, new MoveBase[]{
                createMove("Defense Up", (short) 0, (byte) 20, Type.FLYING, StatusCondition.NENHUM, (byte) 0, StatusCondition.SOLIDIFIED, (byte) 3),
                createMove("Rasante", (short) 270, (byte) 7, Type.FLYING, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Sobrevoar", (short) 50, (byte) 15, Type.FLYING, StatusCondition.NENHUM, (byte) 0, StatusCondition.FLYINGHIGH, (byte) 3)
        });

        // Tipo PSYCHIC.
        movementsDict.put(Type.PSYCHIC, new MoveBase[]{
                createMove("Mind Destroyer", (short) 300, (byte) 2, Type.PSYCHIC, StatusCondition.BURN, (byte) 1, StatusCondition.POISON, (byte) 3),
                createMove("Sleep Time", (short) 0, (byte) 5, Type.PSYCHIC, StatusCondition.SLEEP, (byte) 3, StatusCondition.SLEEP, (byte) 1),
                createMove("Ataque Psiquico", (short) 125, (byte) 20, Type.PSYCHIC, StatusCondition.CONFUSION, (byte) 3, StatusCondition.CONFUSION, (byte) 2)
        });

        // Tipo BUG.
        movementsDict.put(Type.BUG, new MoveBase[]{
                createMove("Compound Eyes", (short) 0, (byte) 3, Type.BUG, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 1),
                createMove("Minimize", (short) 0, (byte) 10, Type.BUG, StatusCondition.CONFUSION, (byte) 2, StatusCondition.WEAKENED, (byte) 3),
                createMove("Infestação", (short) 75, (byte) 15, Type.BUG, StatusCondition.POISON, (byte) 3, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo ROCK. Todos os abaixo ainda não foram implementados, esses só são para não gerar erros.
        movementsDict.put(Type.ROCK, new MoveBase[]{
                createMove("Sturdy", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Solid Punch", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Solid Rock", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo GHOST.
        movementsDict.put(Type.GHOST, new MoveBase[]{
                createMove("Cursed Body", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Amaldiçoar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Possessão", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo DRAGON.
        movementsDict.put(Type.DRAGON, new MoveBase[]{
                createMove("Baforada de Fogo", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Fire Charge", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Levantar Vôo", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo DARK.
        movementsDict.put(Type.DARK, new MoveBase[]{
                createMove("Intimidar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Assombrar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Shadow Steal", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        // Tipo STEEL.
        movementsDict.put(Type.STEEL, new MoveBase[]{
                createMove("Fortalecer", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Bullet", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0),
                createMove("Tétano", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NENHUM, (byte) 0, StatusCondition.NENHUM, (byte) 0)
        });

        return movementsDict;
    }
}
