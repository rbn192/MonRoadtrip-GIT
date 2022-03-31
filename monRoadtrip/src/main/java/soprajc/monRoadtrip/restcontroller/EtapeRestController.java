package soprajc.monRoadtrip.restcontroller;

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

import soprajc.monRoadtrip.exceptions.EtapeException;
import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.services.EtapeService;

@RestController
@RequestMapping("/api/etape")
public class EtapeRestController {

	@Autowired
	private EtapeService etapeService;
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("")
	public List<Etape> getAll() {
		return etapeService.getAll();
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/{id}")
	public Etape getById(@PathVariable Integer id) {
		return etapeService.getById(id);
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
	
	/*@JsonView({JsonViews.Common.class})
	@PatchMapping("/{id}") //pour l'update partielle d'un objet
	public Etape partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Etape etape = etapeService.getById(id);
		fields.forEach((key,value)->{
			if(key.equals("date")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				etape.setDate(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (key.equals("activites")) {
				
			} else if (key.equals("logement")) {
				
			} else if (key.equals("reservation")) {
				
			} else {
			Field field = ReflectionUtils.findField(Etape.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, etape, value);
			}
		});
		return etapeService.save(etape);
	}*/
	
	@JsonView({JsonViews.Common.class})
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		etapeService.deleteById(id);
	}
}
