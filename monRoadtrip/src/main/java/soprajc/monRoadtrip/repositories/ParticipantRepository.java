package soprajc.monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import soprajc.monRoadtrip.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
