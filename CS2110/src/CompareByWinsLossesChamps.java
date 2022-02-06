import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if (a.getNumberOfWins() > b.getNumberOfWins()) {
			return -1;
			} if (a.getNumberOfWins() < b.getNumberOfWins()) {
				return 1;
			} else {
				return a.getNumberOfChampionships()-b.getNumberOfChampionships();
			}
	}

}
