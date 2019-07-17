package comm.example.springdemo;

public class CricketCoach implements Coach {

	private String email;
	private String team;
	private FortuneService fortuneService;

	public CricketCoach() {
		super();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bowling today!";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
