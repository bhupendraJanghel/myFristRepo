package comm.example.springdemo;

public class TennisCoach implements Coach{

	private String email;
	private String team;
	public TennisCoach() {
		super();
		System.out.println("default contructor called");
		
		
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
	@Override
	public String getDailyWorkout() {
		
		return "do 100 crunches";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	public void doMyInitStuff()
	{
		 System.out.println(">>tennsiCoach: inside doMyInitStuff()...");
	}
	public void doMycleanupStuff()
	{
		 System.out.println(">>tennsiCoach: inside doMyCleanupStuff()...");
	}
	
}	
