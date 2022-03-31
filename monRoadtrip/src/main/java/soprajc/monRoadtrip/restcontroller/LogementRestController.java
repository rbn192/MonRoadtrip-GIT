package soprajc.monRoadtrip.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
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

import soprajc.monRoadtrip.exceptions.LogementException;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Hote;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.model.Logement;
import soprajc.monRoadtrip.services.LogementService;

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

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Logement getById(@PathVariable Integer id) {
		return logementService.getById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Logement create(@Valid @RequestBody Logement logement, BindingResult br) {
		return createOrUpdate(logement, br);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Logement update(@PathVariable Integer id, @Valid @RequestBody Logement logement, BindingResult br) {
		logement.setId(id);
		return createOrUpdate(logement, br);
	}

	private Logement createOrUpdate(Logement logement, BindingResult br) {
		if (br.hasErrors()) {
			throw new LogementException();
		}
		return logementService.save(logement);
	}
	
	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Logement PartialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id) {
		Logement logement=logementService.getById(id);
		Adresse adresse = new Adresse();
		fields.forEach((k, v) -> {
			if (k.equals("date")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				logement.setDate(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (k.equals("hote")) {
					String value = v.toString();
					Hote hote = new Hote();
					hote.setId(Integer.parseInt(value.substring(value.indexOf("=") + 1, value.length() - 1)));
					logement.setHote(hote);
				} else if (k.equals("adresse")) {
					String value = v.toString().substring(1, v.toString().length()-1);		
					HashMap<String, String> map = (HashMap<String, String>) Arrays.asList(value.split(",")).stream().map(s -> s.split("=")).collect(Collectors.toMap(e -> e[0], e -> e[1]));
					map.forEach((key,val) -> {
						Field field = ReflectionUtils.findField(Adresse.class, key.trim());
						ReflectionUtils.makeAccessible(field);
						ReflectionUtils.setField(field, adresse, val);
					});
					logement.setAdresse(adresse);
				}
			else {
				Field field = ReflectionUtils.findField(Logement.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, logement, v);
			}
		});
		return logementService.save(logement);	
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		logementService.delete(id);
	}
	
}
