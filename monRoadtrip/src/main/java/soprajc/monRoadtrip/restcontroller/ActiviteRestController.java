package soprajc.monRoadtrip.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.monRoadtrip.exceptions.ActiviteException;
import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.services.ActiviteService;
import soprajc.monRoadtrip.services.CompteService;

@RestController
@RequestMapping("/api/activite")
@CrossOrigin(origins = "*")
public class ActiviteRestController {

	@Autowired
	private ActiviteService activiteService;
	
	@Autowired
	private CompteService compteService;
	
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
	
	@JsonView({JsonViews.Common.class})
	@PatchMapping("/{id}") //pour l'update partielle d'un objet
	public Activite partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Activite activite = activiteService.getById(id);
		fields.forEach((key,value)->{
			if(key.equals("heure")) {
				List<Integer> heureRecuperee = (List<Integer>) value;
				activite.setHeure(LocalTime.of(heureRecuperee.get(0), heureRecuperee.get(1)));
			} else if(key.equals("date")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				activite.setDate(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (key.equals("adresse")) {
				String valueString = value.toString().substring(1,value.toString().length()-1);
				Adresse adresse = new Adresse();
				HashMap<String, String> map = (HashMap<String, String>) Arrays.asList(valueString.split(",")).stream().map(s -> s.split("=")).collect(Collectors.toMap(e -> e[0], e -> (e[1])));
				map.forEach((cle,val)->{
					Field field = ReflectionUtils.findField(Adresse.class, cle.trim());
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, val);
				});
				activite.setAdresse(adresse);
			} else if (key.equals("organisateur")) {
				
			} else {
			Field field = ReflectionUtils.findField(Activite.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, activite, value);
			}
		});
		return activiteService.save(activite);
	}	
	
	@JsonView({JsonViews.Common.class})
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		activiteService.deleteById(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/organisateur/{mail}")
	public List<Activite> getAllByOrganisateur(@PathVariable String mail) {
		return activiteService.getActiviteByOrganisateur(mail);
	}
	
	
}
