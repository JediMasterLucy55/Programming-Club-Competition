package players;

import gamefiles.botInterface;
import gamefiles.readOnlyGameState;

public class LucyBot implements gamefiles.botInterface {
    int currentTokens = readOnlyGameState.getMyTokens();
    int bettedTokens;

    @Override
    public int getBet(readOnlyGameState g) {
        return bettedTokens;
    }
}