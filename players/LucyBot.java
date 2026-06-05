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
            tokensToBetThisRound = 5;
            if (!betValid(tokensToBetThisRound) && newValueBad(currentTokens, tokensToBetThisRound)) {
                tokensToBetThisRound = betterify(currentTokens);
            }
        }

        if (g.getCurrentRound() == 0) {
            return 40;
        }

        return tokensToBetThisRound;
    }

    private boolean betValid(int a) {
        if (a < 20 || a > currentTokens) {
            return false;
        }
        return true;
    }

    private boolean newValueBad(int x, int y) {
        if (x - y < 20) {
            return true;
        }
        return false;
    }

    private int betterify(int c) {
        if (!betValid(c - 30)) {
            for (int i = 1; i < 20; i++) {
                if (c - i == 20) {
                    return i;
                }
            }
        }
        return 5;
    }
}