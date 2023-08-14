package RestApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoookController {
    @GetMapping("/api/books")
    public String getBooksByCategory(@RequestParam("category") String category) {
        return "Fetching books of category: " + category;
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") String id) {
        return "Fetching specific book: " + id;
    }
}




