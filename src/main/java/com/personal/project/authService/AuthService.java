package com.personal.project.authService;

public class AuthService {
	
	public boolean isNameAndPasswordValid(String name, String password) {
		if(name.equals("Najib") && password.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}

}
