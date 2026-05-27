package players;

import gamefiles.botInterface;
import gamefiles.readOnlyGameState;

public class LucyBot implements gamefiles.botInterface {
    public int getBet(readOnlyGameState g) {
        int currentTokens = g.getMyTokens();
        int opponentTokens = g.getOpponentTokens();
        int tokensToBetThisRound = 5;

        if (opponentTokens < currentTokens) {
            tokensToBetThisRound = currentTokens;
        } else if (opponentTokens > currentTokens) {
            if (g.getOpponentPreviousBet() > 5 && g.getOpponentPreviousBet() < currentTokens) {
                tokensToBetThisRound = g.getOpponentPreviousBet() + 5;
            }
        }

        if (g.getCurrentRound() == 0) {
            return currentTokens;
        }

        return tokensToBetThisRound;
    }
}