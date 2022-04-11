package soprajc.monRoadtrip.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.monRoadtrip.model.Compte;
import soprajc.monRoadtrip.model.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Compte auth(@AuthenticationPrincipal Compte compte) {
		return compte;
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

