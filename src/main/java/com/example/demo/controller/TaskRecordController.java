@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    // GET all
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }

    // GET by id
    @GetMapping("/{id}")
    public TaskRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public TaskRecord update(
            @PathVariable Long id,
            @RequestBody TaskRecord task) {
        return service.update(id, task);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
