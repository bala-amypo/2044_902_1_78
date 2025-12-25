import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile v) {
        return service.create(volunteerProfile);
;
    }

    // GET all
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public VolunteerProfile update(
            @PathVariable Long id,
            @RequestBody VolunteerProfile v) {
        return service.update(id, v);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
