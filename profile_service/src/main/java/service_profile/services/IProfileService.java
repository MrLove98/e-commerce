package service_profile.services;

import service_profile.dto.PageResponse;
import service_profile.dto.ProfileDto;
import service_profile.dto.UpdateProfileDto;

public interface IProfileService {

    String createProfile(ProfileDto dto);

    String updateProfile(UpdateProfileDto dto, String email);

    String isDeleteOneProfile(String email, boolean delete);

    PageResponse<ProfileDto> getAllProfile(int pageNumber, int pageSize);

    String xinchao();
}
