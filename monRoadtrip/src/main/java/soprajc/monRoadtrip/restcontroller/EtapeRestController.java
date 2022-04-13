package soprajc.monRoadtrip.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.monRoadtrip.exceptions.EtapeException;
import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.model.Reservation;
import soprajc.monRoadtrip.services.EtapeService;

@RestController
@RequestMapping("/api/etape")
@CrossOrigin(origins = "*")
public class EtapeRestController {

	@Autowired
	private EtapeService etapeService;
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("")
	public List<Etape> getAll() {
		return etapeService.getAll();
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/client/{mail}")
	public List<Etape> getAllByClient(@PathVariable String mail) {
		return etapeService.getAllByClient(mail);
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/{id}")
	public Etape getById(@PathVariable Integer id) {
		return etapeService.getById(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/reservation/{id}")
	public List<Etape>  getByIdResa(@PathVariable Integer id) {
		return etapeService.getByIdResa(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Etape create(@Valid @RequestBody Etape etape, BindingResult br) {
		return createOrUpdate(etape, br);
	}
	
	@JsonView({JsonViews.Common.class})
	@PutMapping("/{id}")
	public Etape update(@PathVariable Integer id, @Valid @RequestBody Etape etape, BindingResult br) {
		etape.setId(id);
		return createOrUpdate(etape, br);
	}

	private Etape createOrUpdate(Etape etape, BindingResult br) {
		if (br.hasErrors()) {
			throw new EtapeException();
		}
		return etapeService.save(etape);
	}
	
	@JsonView({JsonViews.Common.class})
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		etapeService.deleteById(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@PostMapping("/{etapeId}/add/logement/{logementId}")
	public Etape addLogement(@PathVariable Integer etapeId, @PathVariable Integer logementId) {
		return etapeService.addLogement(getById(etapeId), logementId);
	}
	
	@JsonView({JsonViews.Common.class})
	@PostMapping("/{etapeId}/add/activite/{activiteId}")
	public Etape addActivite(@PathVariable Integer etapeId, @PathVariable Integer activiteId) {
		return etapeService.addActivite(getById(etapeId), activiteId);
	}
	
	@JsonView({JsonViews.Common.class})
	@PostMapping("/{etapeId}/remove/logement/{logementId}")
	public Etape removeLogement(@PathVariable Integer etapeId) {
		return etapeService.removeLogement(getById(etapeId));
	}
	
	@JsonView({JsonViews.Common.class})
	@PostMapping("/{etapeId}/remove/activite/{activiteId}")
	public Etape removeActivite(@PathVariable Integer etapeId, @PathVariable Integer activiteId) {
		return etapeService.removeActivite(getById(etapeId), activiteId);
	}
	
}
