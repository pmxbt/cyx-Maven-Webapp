package tools;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.base.bean.User;

public class BaseAction {

	protected User user;
	
	@Autowired  
	private HttpSession session;  
	
	
	@ModelAttribute
	public void perpare(){
		user = (User) session.getAttribute("user");
	}
}
