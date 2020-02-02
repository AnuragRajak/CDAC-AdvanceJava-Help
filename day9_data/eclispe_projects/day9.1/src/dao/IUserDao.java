package dao;

import java.util.Date;
import java.util.List;

import pojos.User;

public interface IUserDao {
	String registerUser(User u); // C

	User getUserDetails(int userId);

	List<User> getAllUsers();

	List<User> getAllSelectedUsers(String role, Date d);

	String updateUserDetails(String email, String pass, String newPass, double incrAmt);

	// delete by user id
	String deleteUserDetails(int userId);

	// delete by reg date
	List<User> deleteUserDetails(Date d);
	//bulk update -- apply discount to users reged before a specific date
	String bulkUpdateUserDetails(double discount,Date d);
}
