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
        } else {
            tokensToBetThisRound = currentTokens / 2;
            if (!betValid(tokensToBetThisRound) && !newValueBad(currentTokens, tokensToBetThisRound)) {
                tokensToBetThisRound = betterify(currentTokens);
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

    private boolean newValueBad(int x, int y) {
        if (x - y < 5) {
            return true;
        }
        return false;
    }

    private int betterify(int c) {
        if (!betValid(c - 5)) {
            
        }
        return 5;
    }
}