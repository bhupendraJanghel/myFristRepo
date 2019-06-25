package com.example.annotation;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	Random random;
	String str = null;
	ArrayList<String> data;
	
	int index = 0;
	FileReader f = null;
	BufferedReader br = null;

	@PostConstruct
	public void doInit() {

		try {
			f = new FileReader("fortune.txt");

			br = new BufferedReader(f);

			data = new ArrayList<String>();
			while ((str = br.readLine()) != null) {

				data.add(str);

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PreDestroy
	public void doCleanUp() {
		try {
			f.close();
			br.close();
			data = null;
			random = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getFortune() {

		random = new Random();
		index = random.nextInt(data.size());

		return data.get(index);
	}

}
