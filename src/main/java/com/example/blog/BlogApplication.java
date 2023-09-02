package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@GetMapping
	public String man(){
		return "# Interview Experience Blog APIs Documentation\n" +
				"\n" +
				"APIs to manage interview experience blog posts in the Interview Experience Blog application.\n" +
				"\n" +
				"**Base URL:** `{base_url}`\n" +
				"\n" +
				"## Endpoints\n" +
				"\n" +
				"- **Retrieve All Posts:** `GET /posts`\n" +
				"- **Create Post:** `POST /posts`\n" +
				"- **Retrieve Post by ID:** `GET /posts/{pid}`\n" +
				"- **Update Post:** `PUT /posts/{pid}`\n" +
				"- **Delete Post:** `DELETE /posts/{pid}`\n" +
				"\n" +
				"## Error Handling\n" +
				"\n" +
				"- `404 Not Found` if resource doesn't exist.\n" +
				"- `400 Bad Request` for validation errors.\n" +
				"\n" +
				"## Authentication and Authorization\n" +
				"\n" +
				"Implement authentication and authorization mechanisms to secure the APIs.\n" +
				"\n" +
				"## License\n" +
				"\n" +
				"This project is licensed under the [MIT License](LICENSE).\n";
	}

}
