package com.te.springsso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller
public class LoginController { 
    private static final String jwtTokenCookieName = "JWT-TOKEN";
	    private static final String signingKey = "signingKey";
	    private static final Map<String, String> credentials = new HashMap<>();

//	    public LoginController() {
//	        credentials.put("helloworld", "helloworld");
////	        credentials.put("hellosso", "hellosso");
//	    }

	    @RequestMapping("/")
	    public String home(){
	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String login(){
	        return "login.html";
	    }

	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
	    	
	        if (username.equals("helloworld") && password.equals("helloworld")){
	        	
	        	String token = JwtUtil.generateToken(signingKey, username);
	        	
		        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
		        
		        return "redirect:http://localhost:8081/protected-resource";
		        
	        	
	        }
	        else {
	        	model.addAttribute("error", "Invalid username or password!");
	            return "login.html";
	        }
	         
	    }
}
