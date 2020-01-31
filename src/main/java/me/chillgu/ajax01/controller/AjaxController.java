package me.chillgu.ajax01.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.chillgu.ajax01.form.MemberForm;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/string")
	@ResponseBody
	public MemberForm responseByString(MemberForm memberForm) throws Exception {
		
		log.info("===================");
		log.info("userId = " + memberForm.getUserId());
		log.info("userPwd = " + memberForm.getUserPwd());
		log.info("===================");
		
		return memberForm;
	}
	
	@PostMapping("/json")
	@ResponseBody
	public JSONObject responseByJson(@RequestBody String member, 
										@RequestHeader HttpHeaders header) throws Exception {
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(member);

		log.info(header.getContentType().toString());
		
		log.info("===================");
		log.info("userId = " + jsonObject.get("userId"));
		log.info("userPwd = " + jsonObject.get("userPwd"));
		log.info("===================");
	
		return jsonObject;
	}
}
