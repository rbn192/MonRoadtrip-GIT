package monRoadtrip.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monRoadtrip.model.JsonViews;
import monRoadtrip.model.Logement;
import monRoadtrip.services.LogementService;

@RestController
@RequestMapping("/api/logement")
public class LogementRestController {
	
	@Autowired
	LogementService logementService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Logement> getAll() {
		return logementService.getAll();
	}

	
	
}
