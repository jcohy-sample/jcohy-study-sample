package com.jcohy.gateway.filter;

import com.jcohy.gateway.filter.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	
	@GetMapping("/getToken/{name}")
    public String get(@PathVariable("name") String name)  {
        return JwtUtil.generateToken(name);
    }
	
}
