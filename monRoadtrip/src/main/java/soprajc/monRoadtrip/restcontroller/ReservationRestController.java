package soprajc.monRoadtrip.restcontroller;

import java.util.List;
import java.util.Optional;

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

import soprajc.monRoadtrip.exceptions.ReservationException;
import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.JsonViews;
import soprajc.monRoadtrip.model.Reservation;
import soprajc.monRoadtrip.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationRestController {
	
	@Autowired
	ReservationService reservationService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Reservation getById(@PathVariable Integer id) {
		return reservationService.getById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		return createOrUpdate(reservation, br);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Reservation update(@PathVariable Integer id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		reservation.setId(id);
		return createOrUpdate(reservation, br);
	}

	private Reservation createOrUpdate(Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		reservationService.delete(id);
	}
	
	@JsonView({JsonViews.Common.class})
	@GetMapping("/client/{mail}")
	public List<Reservation> getAllByOrganisateur(@PathVariable String mail) {
		return reservationService.getReservationByClient(mail);
	}

}
