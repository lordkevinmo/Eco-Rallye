package model;

public class UserSingeleton {
	private static User user = new User();
	public static User getUser() {
		return user;
	}
}
