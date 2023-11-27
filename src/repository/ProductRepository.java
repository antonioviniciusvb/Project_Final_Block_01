package repository;

import java.util.Optional;

import model.Product;

public interface ProductRepository {
	public void register(Product product);
	public void listAll();
	public void findById(int id);
	public void findByName(String name);
	public void findByplatform(String platform);
	public void delete(int id);
	public void update(Optional<Product> product);
}
