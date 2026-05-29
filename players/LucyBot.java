package players;

import gamefiles.readOnlyGameState;

public class LucyBot implements gamefiles.botInterface {
    int currentTokens;
    public int getBet(readOnlyGameState g) {
        currentTokens = g.getMyTokens();
        int opponentTokens = g.getOpponentTokens();
        int tokensToBetThisRound = 5;

        if (opponentTokens <= currentTokens) {
            tokensToBetThisRound = currentTokens;
            boolean correct = betValid(tokensToBetThisRound);
            if (!correct) {
                tokensToBetThisRound = 5;
            }
        } else if (opponentTokens > currentTokens) {
            if (g.getOpponentPreviousBet() > 5 && g.getOpponentPreviousBet() < currentTokens) {
                tokensToBetThisRound = g.getOpponentPreviousBet() + 5;
            }
        }

        return tokensToBetThisRound;
    }

    private boolean betValid(int a) {
        if (a < 5 || a > currentTokens) {
            return false;
        }
        return true;
    }
}