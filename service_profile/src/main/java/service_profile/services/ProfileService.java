package service_profile.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import service_profile.dto.PageResponse;
import service_profile.dto.ProfileDto;
import service_profile.dto.UpdateProfileDto;
import service_profile.entities.ProfileEntity;
import service_profile.repositories.ProfileRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService implements IProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public String createProfile(ProfileDto dto) {
        ProfileEntity entity = new ProfileEntity();
        ProfileDto profileDto = new ProfileDto();

        if (profileRepository.getByEmail(profileDto.getEmail()).isPresent()) {
            return "The email is created!. Please, Creating by other email!";
        }
        {

            entity.setEmail(dto.getEmail().trim());
            entity.setFirstName(dto.getFirstName().trim());
            entity.setLastName(dto.getLastName().trim());
            entity.setPhone(dto.getPhone());
            entity.setImage(dto.getImage().trim());
            entity.setAddress(dto.getAddress().trim());
            profileRepository.save(entity);
            return "Profile is created successfully!";
        }
    }

    @Override
    public String updateProfile(UpdateProfileDto dto, String email) {

        var dataDB = profileRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Profile not found"));

        if (dto.getEmail() != null) dataDB.setEmail(dto.getEmail().trim());
        if (dto.getFirstName() != null) dataDB.setFirstName(dto.getFirstName().trim());
        if (dto.getLastName() != null) dataDB.setLastName(dto.getLastName().trim());
        if (dto.getAddress() != null) dataDB.setAddress(dto.getAddress().trim());
        if (dto.getPhone() != null) dataDB.setPhone(dto.getPhone());
        if (dto.getImage() != null) dataDB.setImage(dto.getImage().trim());
        if (dto.isDelete() != dataDB.isDelete()) dataDB.setDelete(dto.isDelete());

        profileRepository.save(dataDB);
        return "Profile is updated successfully!";
    }

    @Override
    public String isDeleteOneProfile(String email, boolean delete) {
//        //Todo: Soft-Delete
        var entity = profileRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Profile is not found"));

        if (!entity.isDelete()){
            entity.setDelete(delete);

            profileRepository.save(entity);
            return "Deleting is success";
        } else {
            return "The Email is deleted before";
        }

    }

    @Override
    public PageResponse<ProfileDto> getAllProfile(int pageNumber, int pageSize) {
        PageResponse<ProfileDto> pageResponse = new PageResponse<>();

        Sort sort = Sort.by("phone").descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

        // Fetch paginated data from the repository
        var data = profileRepository.findAll(pageable);
        // Map entities to DTOs
        List<ProfileDto> dtoList = data.getContent()
                .stream() // Convert the content list to a stream
                .map(this::customMapEntity2Dto) // Map each entity to a DTO
                .collect(Collectors.toList()); // Collect the result as a list

        // Set pagination details in the response
        pageResponse.setPageNumber(data.getNumber());
        pageResponse.setPageSize(data.getSize());
        pageResponse.setTotalElement(data.getTotalElements());
        pageResponse.setContent(dtoList);

        return pageResponse;
    }

    private ProfileDto customMapEntity2Dto(ProfileEntity e) {
        ProfileDto dto = new ProfileDto();
        dto.setFirstName(e.getFirstName());
        dto.setLastName(e.getLastName());
        dto.setEmail(e.getEmail());
        dto.setAddress(e.getAddress());
        dto.setImage(e.getImage());
        dto.setPhone(e.getPhone());
        dto.setDelete(e.isDelete());
        return dto;
    }

}
