package helpme.todo.Controller.API;

import helpme.todo.DTO.Todo;
import helpme.todo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainApiController {
    private final TodoRepository repository;
    @PostMapping("/add")
    public String add(@ModelAttribute Todo todo) {
        repository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, @ModelAttribute Todo todo) {
        repository.update(id, todo);
        return "redirect:/todo/"+todo.getId();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Map<String, Long> data) {
        repository.delete(data.get("id"));
        return "redirect:/";
    }
}
