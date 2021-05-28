package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapDB implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapDB(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ap = new Author("Apostle", "Paul");
        Book rom = new Book("232323", "Romans");
        ap.getBooks().add(rom);
        rom.getAuthors().add(ap);


        authorRepository.save(ap);
        bookRepository.save(rom);
        Publisher pub = new Publisher("Zondervan","111 Main St", "Chicago","IL","11111");
        pub.getBooks().add(rom);
        publisherRepository.save(pub);
        System.out.println("Number of books saved: " + bookRepository.count() );
        System.out.println("Book of Romans ID: " + rom.getId());
        System.out.println("Number of publishers saved: " + publisherRepository.count());
    }
}
