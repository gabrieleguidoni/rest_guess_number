package gg.springboot;

import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class GuessNumber {

	Random rand = new Random();
	String uniqueID = UUID.randomUUID().toString();
	int randomNumber = rand.nextInt(10) + 1;
	int tryCount = 0;
	int userGuess = 0;
	String returnMessage = "";
	// System.out.println("The Random Number is: " + randomNumber);

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public String play() {
		return returnMessage = "This is your unique identifier: " + uniqueID;
	}

	@RequestMapping(value = "/guess", method = RequestMethod.POST)
	@ResponseBody
	public Integer guessRequest(@RequestParam String id, @RequestParam Integer num) {
		userGuess = num;
		if (id.equals(uniqueID)) {
			return num;
		} else
			return 0;
	}

	@RequestMapping(value = "/guess", method = RequestMethod.GET)
	public String guessResponse(@RequestParam String id) {
		if (id.equals(uniqueID)) {
			if (userGuess == randomNumber) {
				return "Correct You Win!";
			} else if (randomNumber > userGuess) {
				return "Nope! The number is higher. Guess again." + randomNumber;
			} else
				return "Nope! The number is lower. Guess again." + randomNumber;
		} else
			return "Invalid credentials";
	}
}