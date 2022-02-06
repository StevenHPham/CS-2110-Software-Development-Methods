import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
				if (a.isPlayoffTeam() && b.isPlayoffTeam() == false){
					return -1;
					
				}
				if (a.isPlayoffTeam() == false && b.isPlayoffTeam() == false) {
					return 1;
				} else {
					return (int)(a.getSalaryInMillions()-b.getSalaryInMillions());
				}
	}
}


