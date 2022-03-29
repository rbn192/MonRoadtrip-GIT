package monRoadtrip.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import monRoadtrip.exceptions.ActiviteException;
import monRoadtrip.model.Activite;
import monRoadtrip.model.JsonViews;
import monRoadtrip.services.ActiviteService;

@RestController
@RequestMapping("/api/activite")
public class ActiviteRestController {

	@Autowired
	private ActiviteService activiteService;
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("")
	public List<Activite> getAll() {
		return activiteService.getAll();
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/{id}")
	public Activite getById(@PathVariable Integer id) {
		return activiteService.getById(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Activite create(@Valid @RequestBody Activite activite, BindingResult br) {
		return createOrUpdate(activite, br);
	}
	
	@JsonView({JsonViews.Common.class})
	@PutMapping("/{id}")
	public Activite update(@PathVariable Integer id, @Valid @RequestBody Activite activite, BindingResult br) {
		activite.setId(id);
		return createOrUpdate(activite, br);
	}

	private Activite createOrUpdate(Activite activite, BindingResult br) {
		if (br.hasErrors()) {
			throw new ActiviteException();
		}
		return activiteService.save(activite);
	}
	
	//partial update TO DO	
	
	@JsonView({JsonViews.Common.class})
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		activiteService.deleteById(id);
	}
}
