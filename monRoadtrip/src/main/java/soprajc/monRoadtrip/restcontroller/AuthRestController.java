package soprajc.monRoadtrip.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soprajc.monRoadtrip.model.Compte;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@GetMapping("")
	public String auth(@AuthenticationPrincipal Compte compte) {
		return compte.getClass().getSimpleName().toLowerCase();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/id")
	public Integer idcompte(@AuthenticationPrincipal Compte compte) {
		return compte.getId();
	};
	}

