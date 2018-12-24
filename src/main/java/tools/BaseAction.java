package tools;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.base.bean.Region;
import com.base.bean.User;

public class BaseAction {

	protected User user;
	
	protected List<Region> region_list;
	@Autowired  
	private HttpSession session;  
	
	
	@ModelAttribute
	public void perpare(){
		user = (User) session.getAttribute("user");
		region_list= (List<Region>) session.getAttribute("region_list");
	}
}
