package com.te.resourceservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
@Controller
public class ResourceController {

	 private static final String jwtTokenCookieName = "JWT-TOKEN";

	    @RequestMapping("/")
	    public String home() {
	        return "redirect:/protected-resource";
	    }

	    @RequestMapping("/protected-resource")
	    public String protectedResource() {
	            return "protected-resource.html";	
	    }

	    @RequestMapping("/logout")
	    public String logout(HttpServletResponse httpServletResponse) {
	        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
	      
	        return "redirect:http://localhost:8080/login";
	    }
}
