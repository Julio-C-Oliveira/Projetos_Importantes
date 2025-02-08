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
        movements[0] = createMove("Investida", (short) 75, (byte) 100, Type.NORMAL, StatusCondition.NORMAL, StatusCondition.NORMAL);
        movements[1] = createMove("Technician", (short) 0, (byte) 15, Type.NORMAL, StatusCondition.NORMAL, StatusCondition.EXCITED);
        movements[2] = createMove("Immunity", (short) 0, (byte) 7, Type.NORMAL, StatusCondition.NORMAL, StatusCondition.IMMUNITY);

        // Tipo FIRE.
        movements[3] = createMove("Heavy Fire", (short) 250, (byte) 5, Type.FIRE, StatusCondition.NORMAL, StatusCondition.NORMAL);
        movements[4] = createMove("Incendiar", (short) 50, (byte) 50, Type.FIRE, StatusCondition.BURN, StatusCondition.NORMAL);
        movements[5] = createMove("Warm Up", (short) 0, (byte) 10, Type.FIRE, StatusCondition.NORMAL, StatusCondition.WARMUP);

        // Tipo WATER.
        movements[6] = createMove("Torrent", (short) 25, (byte) 5, Type.WATER, StatusCondition.NORMAL, StatusCondition.HEALING);
        movements[7] = createMove("Tsunami", (short) 200, (byte) 5, Type.WATER, StatusCondition.DROWNING, StatusCondition.NORMAL);
        movements[8] = createMove("Bolha", (short) 50, (byte) 100, Type.WATER, StatusCondition.NORMAL, StatusCondition.NORMAL);

        // Tipo GRASS.
        movements[9] = createMove("Chlorophyll", (short) 0, (byte) 20, Type.GRASS, StatusCondition.NORMAL, StatusCondition.HEALING);
        movements[10] = createMove("Root", (short) 75, (byte) 5, Type.GRASS, StatusCondition.PARALYSIS, StatusCondition.HEALING);
        movements[11] = createMove("Turbilhão de Folhas", (short) 175, (byte) 7, Type.GRASS, StatusCondition.NORMAL, StatusCondition.NORMAL);

        // Tipo ELECTRIC.
        movements[12] = createMove("Eletrificar", (short) 55, (byte) 20, Type.ELETRIC, StatusCondition.PARALYSIS, StatusCondition.ELECTRIFIED);
        movements[13] = createMove("Rajada do Trovão", (short) 250, (byte) 7, Type.ELETRIC, StatusCondition.NORMAL, StatusCondition.NORMAL);
        movements[14] = createMove("Estático", (short) 0, (byte) 7, Type.ELETRIC, StatusCondition.CONFUSION, StatusCondition.IMMUNITY); //Não pode atacar, mas não pode ser atingido.

        // Tipo ICE.
        movements[15] = createMove("Snow Cloak", (short) 0, (byte) 8, Type.ICE, StatusCondition.CONFUSION, StatusCondition.NORMAL);
        movements[16] = createMove("Freezing", (short) 0, (byte) 5, Type.ICE, StatusCondition.SLEEP, StatusCondition.NORMAL);
        movements[17] = createMove("Nevasca", (short) 275, (byte) 7, Type.ICE, StatusCondition.NORMAL, StatusCondition.NORMAL);

        // Tipo FIGHTING.
        movements[18] = createMove("Guts", (short) 375, (byte) 3, Type.FIGHTING, StatusCondition.POISON, StatusCondition.CONFUSION);
        movements[19] = createMove("Iron Punch", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NORMAL, StatusCondition.FIGHTSPIRIT);
        movements[20] = createMove("Erguer Guarda", (short) 0, (byte) 15, Type.FIGHTING, StatusCondition.NORMAL, StatusCondition.SOLIDIFIED);

        // Tipo POISON. "Poison Point", "Sopro Ácido", "Ingestão", // Tipo POISON.
        movements[21] = createMove();
        movements[22] = createMove();
        movements[23] = createMove();

        // Tipo GROUND. "Sand Veil", "Tempestade de Areia", "Dissolver", // Tipo GROUND.
        movements[24] = createMove();
        movements[25] = createMove();
        movements[26] = createMove();

        // Tipo FLYING. "Defense Up", "Evasão", "Sobrevoar", // Tipo FLYING.
        movements[27] = createMove();
        movements[28] = createMove();
        movements[29] = createMove();

        // Tipo PSYCHIC. "Synchronize", "Sleep Time", "Ataque Psiquico", // Tipo PSYCHIC.
        movements[30] = createMove();
        movements[31] = createMove();
        movements[32] = createMove();

        // Tipo BUG. "Compound Eyes", "Minimize", "Infestação", // Tipo BUG.
        movements[33] = createMove();
        movements[34] = createMove();
        movements[35] = createMove();

        // Tipo ROCK. "Sturdy", "Solid Punch", "Solid Rock", // Tipo ROCK.
        movements[36] = createMove();
        movements[37] = createMove();
        movements[38] = createMove();

        // Tipo GHOST. "Cursed Body", "Amaldiçoar", "Possessão", // Tipo GHOST.
        movements[39] = createMove();
        movements[40] = createMove();
        movements[41] = createMove();

        // Tipo DRAGON. "Baforada de Fogo", "Fire Charge", "Levantar Vôo", // Tipo DRAGON.
        movements[42] = createMove();
        movements[43] = createMove();
        movements[44] = createMove();

        // Tipo DARK. "Intimidar", "Assombrar", "Shadow Steal", // Tipo DARK
        movements[45] = createMove();
        movements[46] = createMove();
        movements[47] = createMove();

        // Tipo STEEL.  "Fortalecer", "Bullet", "Tétano"}; // Tipo STEEL.
        movements[48] = createMove();
        movements[49] = createMove();
        movements[50] = createMove();
        return movements;
    }
}
