package com.example.spring;

import java.util.Random;

public class RandomFortuneService  implements FortuneService{

	private Random random=new Random();
	
	private String[] data= {
			"Be aware of wolf in sheep's clothing",
			"Delegance is the mother of good luck",
			"work is a journey"
	};
	

	
	@Override
	public String getFortune() {
       
		int index=random.nextInt(data.length);
		return data[index];
    
	}

}
