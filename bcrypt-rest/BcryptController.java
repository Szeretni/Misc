package bcryptRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BcryptController {

	@RequestMapping("/bcrypt")
	public BcryptLogic bcryptLogic(@RequestParam(value="password", defaultValue="bcrypt") String password){
		return new BcryptLogic(password);
	}
	
	@RequestMapping("/match")
	public String bcryptLogic(@RequestParam(value="password", defaultValue="bcrypt") String password, 
			@RequestParam(value="hash") String hash){
		return BcryptLogic.BcryptMatch(password, hash);
	}
}

