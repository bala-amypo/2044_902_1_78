@Service
public class TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;

    public TaskAssignmentService(TaskAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public TaskAssignmentRecord create(TaskAssignmentRecord t) {
        return repo.save(t);
    }

    public List<TaskAssignmentRecord> getAll() {
        return repo.findAll();
    }

    public TaskAssignmentRecord update(Long id, TaskAssignmentRecord updated) {
        TaskAssignmentRecord existing = repo.findById(id).orElseThrow();
        existing.setTaskId(updated.getTaskId());
        existing.setVolunteerId(updated.getVolunteerId());
        existing.setStatus(updated.getStatus());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
