package dev.snowdrop.gettingstarted;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController {

	@GetMapping
	public String hello() {
		return "Hello Cloud Native World!";
	}
}