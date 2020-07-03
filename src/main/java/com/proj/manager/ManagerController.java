package com.proj.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	
	@RequestMapping("manager.mg")
	public String manager() throws Exception {
		return "manager";
	}
	@RequestMapping("data/data.mg")
	public String data() throws Exception {
		return "data/data";
	}
}
