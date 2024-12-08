package service_profile.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service_profile.entities.ProfileEntity;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> getByEmail(String email);

    Optional<ProfileEntity> findByEmail(String email);

    Page<ProfileEntity> findAll(Pageable pageable);

    Page<ProfileEntity> findByEmail(String email, Pageable pageable);
}
