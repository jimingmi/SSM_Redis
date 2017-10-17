package com.gobha.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gobha.model.User;
import com.gobha.service.UserService;


@Controller
public class UserController extends BaseController {

	private UserService userService;

	@Autowired
	public void setUserService( UserService userService ) {
		this.userService = userService;
	}

	@GetMapping({"/","/sys/login"})
	public static String login() {
		return "jsp/login";
	}

	@PostMapping("/sys/login")
	public String login( String account , String password , RedirectAttributes redirectAttributes ) {
		try {
			User user = userService.login(account, password);
			// 保存到会话中
			session.setAttribute("session_user", user);
			return "jsp/main";
		} catch (RuntimeException ex) {
			logger.debug(ex);
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("account", account);
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
			return "redirect:/sys/login";
		}
	}

	@GetMapping("/sys/exit")
	public String exit() {
		session.invalidate();
		return "redirect:/sys/login";
	}

}
