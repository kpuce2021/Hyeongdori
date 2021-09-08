package com.kpu.main;


import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/main")
public class HomeController {
	
	@RequestMapping(value="home", method= {RequestMethod.GET, RequestMethod.POST})
	public String home(Locale locale, Model model) {
		return "home";
	}
	
}
