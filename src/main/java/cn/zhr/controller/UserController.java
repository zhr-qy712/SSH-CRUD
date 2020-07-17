package cn.zhr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhr.entity.Msg;
import cn.zhr.entity.User;
import cn.zhr.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "")
	private IUserService userService;
	
	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		
		List<User> users = userService.getAllUser();
		request.setAttribute("users", users);
		return "/userManager";
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String delUser(String id) {
		//判断取值id是否为null，为null则表明删除失败！
		if(id==null) {
			return "error";
		}else {
			userService.delUser(id);
			return "ok";
		}
	}
	@RequestMapping("/getUser")
	public String getUser(String id,HttpServletRequest request) {
		User user = userService.getUser(id);
		request.setAttribute("user", user);
		return "/editUser";
	}
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/user/getAllUser";
	}
	
}
