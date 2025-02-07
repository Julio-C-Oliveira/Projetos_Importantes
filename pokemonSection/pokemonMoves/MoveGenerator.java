package pokemonSection.pokemonMoves;

import pokemonSection.StatusCondition;
import pokemonSection.Type;

import static pokemonSection.pokemonMoves.MoveBase.createMove;

public class MoveGenerator {
    public MoveGenerator() {}

    // Criar todos os movimentos que estarão disponiveis.
    public static MoveBase[] generateAllMoves() {
        MoveBase[] movements = new MoveBase[51];

        String[] movementNames = {
                "Blaze", "Flash Fire", "Incendiar",
                "Torrent", "Tsunami", "Bolha", // Tipo WATER.
                "Chlorophyll", "Root", "Turbilhão de Folhas", // Tipo GRASS.
                "Eletrificar", "Rajada do Trovão", "Estático", // Tipo ELETRIC.
                "Snow Cloak", "Freezing", "Nevasca", // Tipo ICE.
                "Guts", "Iron Punch", "Erguer Guarda", // Tipo FIGHTING.
                "Poison Point", "Sopro Ácido", "Ingestão", // Tipo POISON.
                "Sand Veil", "Tempestade de Areia", "Dissolver", // Tipo GROUND.
                "Defense Up", "Evasão", "Sobrevoar", // Tipo FLYING.
                "Synchronize", "Sleep Time", "Ataque Psiquico", // Tipo PSYCHIC.
                "Compound Eyes", "Minimize", "Infestação", // Tipo BUG.
                "Sturdy", "Solid Punch", "Solid Rock", // Tipo ROCK.
                "Cursed Body", "Amaldiçoar", "Possessão", // Tipo GHOST.
                "Baforada de Fogo", "Fire Charge", "Levantar Vôo", // Tipo DRAGON.
                "Intimidar", "Assombrar", "Shadow Steal", // Tipo DARK
                "Fortalecer", "Bullet", "Tétano"}; // Tipo STEEL.

        // Tipo NORMAL.
        movements[0] = createMove("Investida", (short) 75, (byte) 100, Type.NORMAL, StatusCondition.NORMAL);
        movements[2] = createMove("Technician", (short) 0, (byte) 15, Type.NORMAL, StatusCondition.EXCITED);
        movements[3] = createMove("Immunity", (short) 0, (byte) 7, Type.NORMAL, StatusCondition.IMMUNITY);

        // Tipo FIRE.
        movements[4] = createMove("Heavy Fire", (short) 250, (byte) 5, Type.FIRE, StatusCondition.NORMAL);
        movements[5] = createMove("Incendiar", (short) 50, (byte) );
        movements[6] = createMove();
        movements[7] = createMove();
        movements[8] = createMove();
        movements[9] = createMove();
        movements[10] = createMove();
        movements[11] = createMove();
        movements[12] = createMove();
        movements[13] = createMove();
        movements[14] = createMove();
        movements[15] = createMove();
        movements[16] = createMove();
        movements[17] = createMove();
        movements[18] = createMove();
        movements[19] = createMove();
        movements[20] = createMove();
        movements[21] = createMove();
        movements[22] = createMove();
        movements[23] = createMove();
        movements[24] = createMove();
        movements[25] = createMove();
        movements[26] = createMove();
        movements[27] = createMove();
        movements[28] = createMove();
        movements[29] = createMove();
        movements[30] = createMove();
        movements[31] = createMove();
        movements[32] = createMove();
        movements[33] = createMove();
        movements[34] = createMove();
        movements[35] = createMove();
        movements[36] = createMove();
        movements[37] = createMove();
        movements[38] = createMove();
        movements[39] = createMove();
        movements[40] = createMove();
        movements[41] = createMove();
        movements[42] = createMove();
        movements[43] = createMove();
        movements[44] = createMove();
        movements[45] = createMove();
        movements[46] = createMove();
        movements[47] = createMove();
        movements[48] = createMove();
        movements[49] = createMove();
        movements[50] = createMove();
        return null;
    }
}
