package soprajc.monRoadtrip.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	@Query("select c from Client c left join fetch c.reservations where c.id=:id")
	Optional<Client> findByIdWithReservations(@Param("id") Integer id);
}
