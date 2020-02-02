package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStockDao;
import com.app.pojos.Stock;

@RestController // @Controller + @RespBody
@RequestMapping("/stocks") // resource oreinted naming pattern
public class StockController {
	@Autowired
	private IStockDao dao;

	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}

	// in case of valid id --- sts code --OK ,stock details added in resp
	// in case invalid id -- sts code 404 , string mesg --- invalid stock id
	@GetMapping("/{stockId}")
	public ResponseEntity<?> getStockDetails(@PathVariable int stockId) {
		System.out.println("in get stock dtls " + stockId);
		Stock s = dao.getStockDetails(stockId);
		if (s == null)
			return new ResponseEntity<String>("Invalid Stock ID", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Stock>(s, HttpStatus.OK);
	}

	@GetMapping
	public List<Stock> getAllStocks() {
		System.out.println("in get all stocks");
		return dao.getAvailableStocks();
	}

	// req handling method to add new stock
	@PostMapping
	public ResponseEntity<String> addStock(@RequestBody Stock s) // un marshalling resource JSON --->Java obj
	{
		System.out.println("in add stock " + s);
		try {
			return new ResponseEntity<>(dao.createNewStock(s), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("Stock creation failed !!! : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// request hadnling method to update the stock
	// i/p stock id URI variable , updated Stock details
	@PutMapping("/{stockId}")
	public ResponseEntity<?> updateStock(@PathVariable int stockId, @RequestBody Stock s) {
		System.out.println("in update " + stockId + " " + s);
		// chk if stock exists
		Stock existingStock = dao.getStockDetails(stockId);
		if (existingStock == null)
			return new ResponseEntity<String>("Invalid Stock ID", HttpStatus.NOT_FOUND);
		// stock exists
		s.setId(existingStock.getId());// setting stock id --- deatched pojo
		return new ResponseEntity<Stock>(dao.updateStock(s), HttpStatus.OK);

	}

	// request handling method for deleting the stock
	// i/p stock name
	@DeleteMapping("/{stockName}")
	public ResponseEntity<String> deleteStock(@PathVariable String stockName) {
		System.out.println("in delete stock " + stockName);
		try {
			return new ResponseEntity<>(dao.deleteStock(stockName), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("Stock deletion failed !!! : " + e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

}
