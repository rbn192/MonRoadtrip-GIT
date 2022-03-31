package monRoadtrip.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

import monRoadtrip.exceptions.RoadtripException;
import monRoadtrip.model.Hote;
import monRoadtrip.model.JsonViews;
import monRoadtrip.model.Roadtrip;
import monRoadtrip.services.RoadtripService;

@RestController
@RequestMapping("/api/roadtrip")
public class RoadtripRestController {
	
	@Autowired
	private RoadtripService roadtripService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Roadtrip> getAll() {
		return roadtripService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Roadtrip getById(@PathVariable Integer id) {
		return roadtripService.getById(id);
	}
	

	private Roadtrip createOrUpdate(Roadtrip roadtrip, BindingResult br) {
		if (br.hasErrors()) {
			throw new RoadtripException();
		}
		return roadtripService.save(roadtrip);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Roadtrip create(@Valid @RequestBody Roadtrip roadtrip, BindingResult br) {
		return createOrUpdate(roadtrip, br);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Roadtrip update(@PathVariable Integer id, @Valid @RequestBody Roadtrip roadtrip, BindingResult br) {
		roadtrip.setId(id);
		return createOrUpdate(roadtrip, br);
	}


	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Roadtrip PartialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id) {
		Roadtrip roadtrip=roadtripService.getById(id);
		fields.forEach((key, value) -> {
			if (key.equals("dateDepart")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				roadtrip.setDateArrivee(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} 
			else if (key.equals("dateArrivee")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				roadtrip.setDateDepart(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} 
			
		//////		
			
			else {
				Field field = ReflectionUtils.findField(Roadtrip.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, roadtrip, value);
			}
		});
		return roadtripService.save(roadtrip);	
	}
	
	
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		roadtripService.delete(id);
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
