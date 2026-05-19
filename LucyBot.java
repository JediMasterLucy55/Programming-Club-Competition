import gamefiles.readOnlyGameState;

public class LucyBot implements gamefiles.botInterface {
    int currentTokens;
    int bettedTokens;

    @Override
    public int getBet(readOnlyGameState g) {
        return bettedTokens;
    }
}