package com.r2b.TransactionManagement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.r2b.transaction.App;
import com.r2b.transaction.entity.Account;
import com.r2b.transaction.entity.Transaction;

/**
 * Unit test for simple App.
 */
public class AppTest {

	App app;
	
	@Before
	public void setUp() {
		app = new App();
	}
	
    /**
     * test if the methdod return one transaction with condition value <1000 and gender is M
     */
    @Test
    public void getTransactinSouldReturn1()
    {
    	List<Transaction> result = app.getTransactionsValueSup100AndGenderM(populateTransaction ());
        assertEquals(1, result.size());
        assertEquals("Yugariten", result.get(0).getAccount().getName());
    }
    
    @Test
    public void getSumMustReturn3140() {
    	Optional<Double> result = app.getSumTransactions(populateTransaction());
        assertEquals(true, result.isPresent());
        assertEquals("3140.0", result.get().toString());
    }
    
    @Test
    public void getMapGroupedGender() {
    	Map<String, List<Transaction>> result = app.getGroupedTransactionPerGender(populateTransaction());
    	assertEquals(2, result.size());
    	assertEquals(3, result.get("M").size());
    	assertEquals(2, result.get("F").size());
    }
    
    @Test
    public void getDistinctAccountCities() {
    	Set<String> result = app.getDistinctCities(populateTransaction());
    	assertEquals(3, result.size());
    }
    
    /**
     * Populate Transactions
     * @return
     */
	private static List<Transaction> populateTransaction() {

		List<Transaction> result = new ArrayList<Transaction>();
		
		Account account1 = new Account();
		account1.setCity("Bejaia");
		account1.setGender("M");
		account1.setName("Yugariten");
		
		Account account2 = new Account();
		account2.setCity("Bouira");
		account2.setGender("F");
		account2.setName("Tiziri");
		
		Account account3 = new Account();
		account3.setCity("Tizi Ouzou");
		account3.setGender("M");
		account3.setName("Massi");
		
		Account account4 = new Account();
		account4.setCity("Bejaia");
		account4.setGender("F");
		account4.setName("Tinhinane");
		
		Account account5 = new Account();
		account5.setCity("Bejaia");
		account5.setGender("M");
		account5.setName("Agawa");
		
		Transaction transaction = new Transaction();
		transaction.setValue(1230);
		transaction.setAccount(account1);
		
		Transaction transaction1 = new Transaction();
		transaction1.setValue(1530);
		transaction1.setAccount(account2);
		
		Transaction transaction2 = new Transaction();
		transaction2.setValue(130);
		transaction2.setAccount(account3);
		
		Transaction transaction3 = new Transaction();
		transaction3.setValue(150);
		transaction3.setAccount(account4);

		Transaction transaction4 = new Transaction();
		transaction4.setValue(100);
		transaction4.setAccount(account5);
		
		result.add(transaction);
		result.add(transaction1);
		result.add(transaction2);
		result.add(transaction3);
		result.add(transaction4);
		
		return result;
	}
}
