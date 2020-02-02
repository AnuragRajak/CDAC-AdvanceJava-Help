package com.app.dao;

import java.util.List;

import com.app.pojos.Stock;

public interface IStockDao {
	Stock getStockDetails(int id);
	List<Stock> getAvailableStocks();
	String createNewStock(Stock s);
	Stock updateStock(Stock s);
	String deleteStock(String name);
}
