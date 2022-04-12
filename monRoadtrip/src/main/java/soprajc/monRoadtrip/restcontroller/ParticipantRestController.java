package soprajc.monRoadtrip.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

import soprajc.monRoadtrip.exceptions.ParticipantException;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.model.Participant;
import soprajc.monRoadtrip.services.ParticipantService;

@RestController
@RequestMapping("/api/participant")
@CrossOrigin(origins = "*")
public class ParticipantRestController {
	
	@Autowired
	private ParticipantService participantService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Participant> getAll() {
		return participantService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Participant getById(@PathVariable Integer id) {
		return participantService.getById(id);
	}	

	private Participant createOrUpdate(Participant participant, BindingResult br) {
		if (br.hasErrors()) {
			throw new ParticipantException();
		}
		return participantService.save(participant);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Participant create(@Valid @RequestBody Participant participant, BindingResult br) {
		System.out.println(participant.getNom()+"HERE");
		return createOrUpdate(participant, br);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Participant update(@PathVariable Integer id, @Valid @RequestBody Participant participant, BindingResult br) {
		participant.setId(id);
		return createOrUpdate(participant, br);
	}

	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Participant PartialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id) {
		Participant participant=participantService.getById(id);
			fields.forEach((key,value)->{

				Field field=  ReflectionUtils.findField(Participant.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, participant, value);	
			});
			return participantService.save(participant);	
		}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		participantService.delete(id);
	}
	
	

}
