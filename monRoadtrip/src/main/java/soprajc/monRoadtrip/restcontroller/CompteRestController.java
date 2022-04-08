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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import soprajc.monRoadtrip.exceptions.CompteException;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Compte;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.services.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	LogementRestController logementRestController;

	@Autowired
	CompteService compteService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Integer id) {
		return compteService.getById(id);
	}

	@PreAuthorize("isAnonymous()")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println(compte);
			throw new CompteException("impossible de creer compte");
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		compteService.save(compte);
		return compte;
		//return save(compte, br);
	}

	private Compte save(Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		return compteService.save(compte);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		compteService.delete(id);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Compte update(@PathVariable Integer id, @Valid @RequestBody Compte compte, BindingResult br) {
		compte.setId(id);
		return save(compte, br);
	}

	// a finir
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Compte partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Compte compte = compteService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				String value = v.toString().substring(1, v.toString().length() - 1);
				Adresse adresse = new Adresse();
				HashMap<String, String> map = (HashMap<String, String>) Arrays.asList(value.split(",")).stream()
						.map(s -> s.split("=")).collect(Collectors.toMap(e -> e[0], e -> (e[1])));
//				Integer numero = Integer.parseInt(value.substring(value.indexOf("=") + 1, 0));
				System.out.println(value);
				System.out.println(map);
				map.forEach((cle, val) -> {
					System.out.println(cle.trim());
					Field field = ReflectionUtils.findField(Adresse.class, cle.trim());
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, val);
				});
				System.out.println(adresse);
				((Client) compte).setAdresse(adresse);
			} else if (k.equals("dateNaissance")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				compte.setDateNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));

			} else if (k.equals("reservation")) {

			} else if (k.equals("logements")) {

			} else if (k.equals("activites")) {

			} else {
				Field field = ReflectionUtils.findField(Compte.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, compte, v);
			}
		});
		return compteService.save(compte);
	}

}
