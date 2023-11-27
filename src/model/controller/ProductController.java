package model.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Product;
import project_final_block_01.util.OutPut;
import repository.ProductRepository;

public class ProductController implements ProductRepository {

	List<Product> products = new ArrayList<Product>();
	private int id;
	public String errorOperation = "Product Id not found";
	
	@Override
	public void register(Product product) {
		
		products.add(product);
		OutPut.printSucess("Product registered successfully.");
	}

	@Override
	public void listAll() {
		
		if (products.isEmpty())
			OutPut.printFailed("There are no registered products");
		else
			products.forEach(p -> OutPut.printfSucess(p.toString()));
	}

	@Override
	public void findById(int id) {
		
		var product = findProduct(id);
		
		if (product.isPresent())
			OutPut.printSucess(product.get().toString());
		else
			OutPut.printFailed(errorOperation);
		
	}

	@Override
	public void findByName(String name) {

		var product = products.stream()
				.filter(p -> p.getName().contains(name))
				.collect(Collectors.toList());
			
		if (product.size() > 0)
			product.forEach(p -> OutPut.printfSucess(p.toString()));
		else
			OutPut.printFailed(errorOperation);
	}

	@Override
	public void findByPlatform(String platform) {
		
		var product = products.stream()
				.filter(p -> p.getPlatform().contains(platform))
				.collect(Collectors.toList());
			
		if (product.size() > 0)
			product.forEach(p -> OutPut.printfSucess(p.toString()));
		else
			OutPut.printFailed(errorOperation);
		
	}

	@Override
	public void delete(int id) {
		
		var productToDelete = findProduct(id);
		
		if(productToDelete.isPresent()) {
			products.remove(productToDelete.get());
			OutPut.printfSucess("Product Id: %d successfully removed", id);
		}else {
			OutPut.printFailed(errorOperation);
		}
		
	}

	@Override
	public void update(Optional<Product> product) {
		
		var productToUpdate = findProduct(product.get().getId());
		
		if (productToUpdate.isPresent()) {
			products.set(products.indexOf(productToUpdate.get()), product.get());
			OutPut.printfSucess("Product %s updated successfully", product.get().getName());
		} else {
			OutPut.printFailed(errorOperation);
		}
		
	}
	
	public Optional<Product> findProduct(int id) {

		var product = products.stream()
				.filter(p -> p.getId() == id)
				.collect(Collectors.toList());
			
		return Optional.ofNullable(product.get(0));
	}

	public int generateId() {
		return ++id;
	}
}
