package monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
