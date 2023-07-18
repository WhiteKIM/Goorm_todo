package helpme.todo.Controller;

import helpme.todo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TodoRepository repository;
    @GetMapping("/")
    String mainForm(Model model) {
        model.addAttribute("todos", repository.findAll());
        return "main";
    }
    @GetMapping("/add")
    String addForm() {
        return "pages/addForm";
    }
    @GetMapping("/todo/{id}")
    String detailForm(@PathVariable long id, Model model) {
        model.addAttribute("todo", repository.findById(id));
        return "pages/detailForm";
    }

    @GetMapping("/todo/update/{id}")
    String updateForm(@PathVariable long id, Model model) {
        model.addAttribute("todo", repository.findById(id));
        return "pages/updateForm";
    }
}
