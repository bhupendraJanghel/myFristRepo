package comm.example.springdemo;

public class HappyFortuneService implements FortuneService {

	public  HappyFortuneService() {
		System.out.println("HappyFortuneService: Object created");
	}
	
	
	
	@Override
	public String getFortune() {
		 return "Today is your lucky day!";
	}
	

}
