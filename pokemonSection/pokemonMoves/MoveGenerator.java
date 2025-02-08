package pokemonSection.pokemonMoves;

import pokemonSection.StatusCondition;
import pokemonSection.Type;

import static pokemonSection.pokemonMoves.MoveBase.createMove;

public class MoveGenerator {
    public MoveGenerator() {}

    // Criar todos os movimentos que estarão disponiveis.
    public static MoveBase[] generateAllMoves() {
        MoveBase[] movements = new MoveBase[51];

        // Tipo NORMAL.
        movements[0] = createMove("Investida", (short) 75, (byte) 100, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[1] = createMove("Technician", (short) 0, (byte) 15, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.EXCITED, (byte) 3);
        movements[2] = createMove("Immunity", (short) 0, (byte) 7, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.IMMUNITY, (byte) 3);

        // Tipo FIRE.
        movements[3] = createMove("Heavy Fire", (short) 250, (byte) 5, Type.FIRE, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[4] = createMove("Incendiar", (short) 50, (byte) 50, Type.FIRE, StatusCondition.BURN, (byte) 3, StatusCondition.NORMAL, (byte) 0);
        movements[5] = createMove("Warm Up", (short) 0, (byte) 10, Type.FIRE, StatusCondition.NORMAL, (byte) 0, StatusCondition.WARMUP, (byte) 3);

        // Tipo WATER.
        movements[6] = createMove("Torrent", (short) 25, (byte) 5, Type.WATER, StatusCondition.NORMAL, (byte) 0, StatusCondition.HEALING, (byte) 3);
        movements[7] = createMove("Tsunami", (short) 200, (byte) 5, Type.WATER, StatusCondition.DROWNING, (byte) 3, StatusCondition.NORMAL, (byte) 0);
        movements[8] = createMove("Bolha", (short) 50, (byte) 100, Type.WATER, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo GRASS.
        movements[9] = createMove("Chlorophyll", (short) 0, (byte) 20, Type.GRASS, StatusCondition.NORMAL, (byte) 0, StatusCondition.HEALING, (byte) 3);
        movements[10] = createMove("Root", (short) 75, (byte) 5, Type.GRASS, StatusCondition.PARALYSIS, (byte) 3, StatusCondition.HEALING, (byte) 3);
        movements[11] = createMove("Turbilhão de Folhas", (short) 175, (byte) 7, Type.GRASS, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo ELECTRIC.
        movements[12] = createMove("Eletrificar", (short) 55, (byte) 20, Type.ELETRIC, StatusCondition.PARALYSIS, (byte) 2, StatusCondition.ELECTRIFIED, (byte) 2);
        movements[13] = createMove("Rajada do Trovão", (short) 250, (byte) 7, Type.ELETRIC, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[14] = createMove("Estático", (short) 0, (byte) 7, Type.ELETRIC, StatusCondition.CONFUSION, (byte) 3, StatusCondition.IMMUNITY, (byte) 1); //Não pode atacar, mas não pode ser atingido.

        // Tipo ICE.
        movements[15] = createMove("Snow Cloak", (short) 0, (byte) 8, Type.ICE, StatusCondition.CONFUSION, (byte) 3, StatusCondition.NORMAL, (byte) 0);
        movements[16] = createMove("Freezing", (short) 0, (byte) 5, Type.ICE, StatusCondition.SLEEP, (byte) 2, StatusCondition.NORMAL, (byte) 0);
        movements[17] = createMove("Nevasca", (short) 275, (byte) 7, Type.ICE, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo FIGHTING.
        movements[18] = createMove("Guts", (short) 375, (byte) 3, Type.FIGHTING, StatusCondition.POISON, (byte) 2, StatusCondition.CONFUSION, (byte) 3);
        movements[19] = createMove("Iron Punch", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NORMAL, (byte) 0, StatusCondition.FIGHTSPIRIT, (byte) 3);
        movements[20] = createMove("Erguer Guarda", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NORMAL, (byte) 0, StatusCondition.SOLIDIFIED, (byte) 3);

        // Tipo POISON.
        movements[21] = createMove("Poison Point", (short) 5, (byte) 5, Type.POISON, StatusCondition.POISON, (byte) 2, StatusCondition.HEALING, (byte) 2);
        movements[22] = createMove("Sopro Ácido", (short) 150, (byte) 15, Type.POISON, StatusCondition.POISON, (byte) 3, StatusCondition.NORMAL, (byte) 0);
        movements[23] = createMove("Disperse", (short) 0, (byte) 7, Type.POISON, StatusCondition.POISON, (byte) 2, StatusCondition.IMMUNITY, (byte) 1);

        // Tipo GROUND.
        movements[24] = createMove("Sand Veil", (short) 100, (byte) 20, Type.GROUND, StatusCondition.CONFUSION, (byte) 3, StatusCondition.NORMAL, (byte) 0);
        movements[25] = createMove("Tempestade de Areia", (short) 250, (byte) 10, Type.GROUND, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[26] = createMove("Dissolver", (short) 0, (byte) 7, Type.GROUND, StatusCondition.NORMAL, (byte) 0, StatusCondition.IMMUNITY, (byte) 2);

        // Tipo FLYING.
        movements[27] = createMove("Defense Up", (short) 0, (byte) 20, Type.FLYING, StatusCondition.NORMAL, (byte) 0, StatusCondition.SOLIDIFIED, (byte) 3);
        movements[28] = createMove("Rasante", (short) 270, (byte) 7, Type.FLYING, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[29] = createMove("Sobrevoar", (short) 50, (byte) 15, Type.FLYING, StatusCondition.NORMAL, (byte) 0, StatusCondition.FLYINGHIGH, (byte) 3);

        // Tipo PSYCHIC.
        movements[30] = createMove("Mind Destroyer", (short) 300, (byte) 2, Type.PSYCHIC, StatusCondition.BURN, (byte) 1, StatusCondition.POISON, (byte) 3);
        movements[31] = createMove("Sleep Time", (short) 0, (byte) 5, Type.PSYCHIC, StatusCondition.SLEEP, (byte) 3, StatusCondition.SLEEP, (byte) 1);
        movements[32] = createMove("Ataque Psiquico", (short) 125, (byte) 20, Type.PSYCHIC, StatusCondition.CONFUSION, (byte) 3, StatusCondition.CONFUSION, (byte) 2);

        // Tipo BUG.
        movements[33] = createMove("Compound Eyes", (short) 0, (byte) 3, Type.BUG, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 1);
        movements[34] = createMove("Minimize", (short) 0, (byte) 10, Type.BUG, StatusCondition.CONFUSION, (byte) 2, StatusCondition.WEAKENED, (byte) 3);
        movements[35] = createMove("Infestação", (short) 75, (byte) 15, Type.BUG, StatusCondition.POISON, (byte) 3, StatusCondition.NORMAL, (byte) 0);

        // Tipo ROCK. Todos os abaixo ainda não foram implementados, esses só são para não gerar erros.
        movements[36] = createMove("Sturdy", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[37] = createMove("Solid Punch", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[38] = createMove("Solid Rock", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo GHOST.
        movements[39] = createMove("Cursed Body", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[40] = createMove("Amaldiçoar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[41] = createMove("Possessão", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo DRAGON.
        movements[42] = createMove("Baforada de Fogo", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[43] = createMove("Fire Charge", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[44] = createMove("Levantar Vôo", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo DARK.
        movements[45] = createMove("Intimidar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[46] = createMove("Assombrar", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[47] = createMove("Shadow Steal", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);

        // Tipo STEEL.
        movements[48] = createMove("Fortalecer", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[49] = createMove("Bullet", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        movements[50] = createMove("Tétano", (short) 0, (byte) 0, Type.NORMAL, StatusCondition.NORMAL, (byte) 0, StatusCondition.NORMAL, (byte) 0);
        return movements;
    }
}
