package org.example.awsspring.web;

import org.example.awsspring.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSOM반환하는 컨트롤러로 만들어줌. @Responsebody를 각 메소드마다 선언했던것을 한번에 사용할수있게 해준다생각.
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
		return new HelloResponseDto(name, amount);
	}
}