package helpme.todo.Repository;

import helpme.todo.DTO.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TodoRepository {
    private static HashMap<Long, Todo> data = new HashMap<Long, Todo>();
    private static long sequence = 0L;

    public void save(Todo todo) {
        todo.setId(++sequence);
        data.put(todo.getId(), todo);
    }

    public void update(Long totoId,Todo todo) {
        Todo todo1 = findById(totoId);
        todo1.setTitle(todo.getTitle());
        todo1.setContent(todo.getContent());
    }

    public void delete(Long id) {
        data.remove(id);
    }

    public Todo findById(Long id) {
        return data.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(data.values());
    }
}
