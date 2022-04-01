package soprajc.monRoadtrip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.repositories.CompteRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepo.findByMail(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("mail inconnu");
		});
	}

}
