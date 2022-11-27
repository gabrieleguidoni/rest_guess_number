package gg.springboot;

import java.util.Random;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.gg.springboot.UserResponse;

@RestController
public class GuessNumber {

	Random rand = new Random();
	String uniqueID = UUID.randomUUID().toString();
	int randomNumber = rand.nextInt(10) + 1;

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public UserResponse play() {
		UserResponse userResponse = new UserResponse();
		userResponse.setMessage(uniqueID);
		userResponse.setData(0);
		return userResponse;
	}

	@RequestMapping(value = "/guess", method = RequestMethod.POST)
	@ResponseBody
	public UserResponse guessRequest(@RequestBody UserResponse userResponse) {
		if (uniqueID.equals(userResponse.getMessage())) {
			return userResponse;
		} else {
			UserResponse NewuserResponse = new UserResponse();
			NewuserResponse.setMessage("Invalid Credentials");
			NewuserResponse.setData(0);
			return NewuserResponse;
		}
	}

	@RequestMapping(value = "/guess", method = RequestMethod.GET)
	@ResponseBody
	public UserResponse responseRequest(@RequestBody UserResponse userResponse) {
		if (uniqueID.equals(userResponse.getMessage())) {
			if (randomNumber == userResponse.getData()) {
				UserResponse NewuserResponse = new UserResponse();
				NewuserResponse.setMessage("Correct You win!");
				NewuserResponse.setData(1);
				return NewuserResponse;
			} else if (randomNumber > userResponse.getData()) {
				UserResponse NewuserResponse = new UserResponse();
				NewuserResponse.setMessage("The Correct number is Higher, try Again!" + randomNumber);
				NewuserResponse.setData(1);
				return NewuserResponse;
			} else {
				UserResponse NewuserResponse = new UserResponse();
				NewuserResponse.setMessage("The Correct number is Lower, try Again!" + randomNumber);
				NewuserResponse.setData(1);
				return NewuserResponse;
			}
		} else {
			UserResponse NewuserResponse = new UserResponse();
			NewuserResponse.setMessage("Invalid Credentials ");
			NewuserResponse.setData(0);
			return NewuserResponse;
		}
	}
}