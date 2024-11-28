package service_profile.controller;

import org.springframework.web.bind.annotation.*;
import service_profile.clients.InventoryClient;
import service_profile.dto.PageResponse;
import service_profile.dto.ProfileDto;
import service_profile.dto.UpdateProfileDto;
import service_profile.services.IProfileService;

@RequestMapping(path = "/profile")
@RestController
public class ProfileController {

    private final InventoryClient inventoryClient;

    private final IProfileService iProfileService;

    public ProfileController(InventoryClient inventoryClient, IProfileService iProfileService) {
        this.inventoryClient = inventoryClient;
        this.iProfileService = iProfileService;
    }

    @PostMapping("/create")
    public String createProfile(@RequestBody ProfileDto profileDto) {
        return iProfileService.createProfile(profileDto);
    }

    //Todo: PathMapping: cho update 1 trường  || PutMapping: bạn buộc phải update toàn bộ các trường
    @PatchMapping("/update/{email}")
    public String updateProfile(@PathVariable String email,
                                @RequestBody UpdateProfileDto updateProfileDto) {
        return iProfileService.updateProfile(updateProfileDto, email);
    }

    @DeleteMapping("/delete/{email}")
    public String deleteProfile(@PathVariable String email,
                                @RequestParam(value = "true", required = false, defaultValue = "true") boolean delete
    ) {
        return iProfileService.isDeleteOneProfile(email, delete);
    }

    @GetMapping("/all")
    public PageResponse<ProfileDto> getAllProfile(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return iProfileService.getAllProfile(pageNumber, pageSize);
    }

    @GetMapping("/h")
    public String getHello() {
        return inventoryClient.getXinChao();
    }


//    @GetMapping("/xinchao")
//    public String xinchao() {
//        return iProfileService.xinchao();
//    }
}

/**
 * Choosing the Right Mapping:
 * Use @PostMapping for creating new resources.
 * Use @PutMapping when replacing a resource entirely or creating one if it doesn’t exist.
 * Use @PatchMapping when updating specific fields of a resource without replacing the whole resource.
 */
