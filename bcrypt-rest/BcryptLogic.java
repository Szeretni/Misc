package bcryptRest;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptLogic {

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private String password;
	private String bcryptHash;

	public BcryptLogic(String password) {
		this.password = password;
		this.bcryptHash = passwordEncoder().encode(password);
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getBcryptHash() {
		return bcryptHash;
	}

	public void setBcryptHash(String bcryptHash) {
		this.bcryptHash = bcryptHash;
	}
	
	public static String BcryptMatch(String password, String hash) {
		if(passwordEncoder().matches(password,hash)) {
			return "Password " + password + " matches Bcrypted hash " + hash;
		} else {
			return "Password " + password + " didn't match Bcrypted hash " + hash;
		}
	}

}
