package domain;

import manager.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Kniga001", 200, "Vasiliy");
    Book book2 = new Book(2, "Kniga002", 123, "John");


    @BeforeEach
    void setUp() {
        manager = new ProductManager(repository);
        manager.addProduct(book1);
        manager.addProduct(book2);


    }


    @Test
    void removeById() {

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

}