package comm.example.springdemo;

public class BaseBallCoach implements Coach{
	
	private  FortuneService myFortuneService;
	
	public BaseBallCoach() {
		super();
		System.out.println("BaseBallCoach: Object Created");
	}
	
	public BaseBallCoach(FortuneService myFortuneService)
	{
		 this.myFortuneService=myFortuneService;
		 System.out.println("BaseBallCoach : Dependency Injection performed!");
	}
	
	
	
	 public void setMyFortuneService(FortuneService myFortuneService) {
		System.out.println("setMyFortuneService:setter injection performed");
		this.myFortuneService = myFortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "practice daily pushups";
	}
	
	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}
}
