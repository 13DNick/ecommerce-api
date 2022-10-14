package com.nikitadev.ecommercestore.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nikitadev.ecommercestore.entities.Product;

public class ProductDeserializer extends JsonDeserializer<Product>{

	@Override
	public Product deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		//create initial node
		ObjectCodec oc = p.getCodec();
	    JsonNode node = oc.readTree(p);
	    
	    //extract values
	    final String name = node.get("title").asText();
	    final double price = node.get("price").asDouble();
	    final String description = node.get("description").asText();
	    final String imageURL = node.get("image").asText();
	    final String category = node.get("category").asText();
	    
	    //create node for nested object
	    final JsonNode nested = node.get("rating");
	    
	    //extract nested values
	    final double rating = nested.get("rate").asDouble();
	    final int ratingCount = nested.get("count").asInt();
	    
	    Product product = new Product(name, description, price, imageURL, rating, ratingCount);
	    product.setCategory(category);
	    
		return product;
	}

}
