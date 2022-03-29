package monRoadtrip.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monRoadtrip.model.Compte;
import monRoadtrip.model.JsonViews;
import monRoadtrip.services.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {

	
	@Autowired
	CompteService compteService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteService.getAll();
	}
}
