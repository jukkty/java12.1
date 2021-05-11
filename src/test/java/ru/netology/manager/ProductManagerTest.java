package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "FirstBook", 1000, "FirstAuthor");
    private Book book2 = new Book(2, "SecondBook", 2000, "SecondAuthor");
    private Book book3 = new Book(6, "ThirdBook", 3000, "FirstAuthor");
    private Smartphone smartphone1 = new Smartphone(3, "Apple", 60000, "Iphone");
    private Smartphone smartphone2 = new Smartphone(4, "Huawei", 20000, "P30");
    private Product product = new Product(5, "Product", 250);

    @Test
    public void ShouldRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product);
        manager.removeById(2);
        Product[] expected = new Product[]{book1, smartphone1, smartphone2, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldShowNotFoundException(){
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product);
        manager.add(book3);
        assertThrows(NotFoundException.class,() ->manager.removeById(19),"Элемент с данным ID существует и его возможно удалить");
        System.out.println("NotFoundException работает");
    }
}