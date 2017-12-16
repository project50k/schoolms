package pl.school.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomController {

	@RequestMapping("/random")
	@ResponseBody
	public String randomNum() {
		Random r = new Random();
		int number = r.nextInt(100);
		return "Wylosowana liczba to: "+number;
	}
	

	
}
