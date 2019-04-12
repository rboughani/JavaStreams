package com.r2b.transaction;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.r2b.transaction.entity.Transaction;

public class App 
{
	/**
	 * get list of transaction which is value >1000 and account gender is M
	 */
    public List<Transaction> getTransactionsValueSup100AndGenderM( List<Transaction> listTransac )
    {
		return listTransac.stream()
    			.filter(
						p->p.getValue()>1000 && p.getAccount().getGender().equals("M")
					).collect(Collectors.toList());
    }

    /**
     * return the SUM of all transactions
     * @param populateTransaction
     * @return
     */
	public Optional<Double> getSumTransactions(List<Transaction> listTransacs) {

		return listTransacs.stream()
				.map(x -> x.getValue())
				.reduce((x, y) -> x+y);
	}

	/**
	 * Get grouped transaction per account gender
	 * @param listTransac
	 * @return
	 */
	public Map<String, List<Transaction>> getGroupedTransactionPerGender(List<Transaction> listTransac) {

		return listTransac.stream()
				.filter(p->Objects.nonNull(p.getAccount().getGender()))
				.collect(Collectors.groupingBy(p->p.getAccount().getGender()));
	}

	/**
	 * Get distinc cities used in all transactions
	 * @param populateTransaction
	 * @return
	 */
	public Set<String> getDistinctCities(List<Transaction> listTransac) {
		return listTransac.stream()
				.distinct()
				.filter(p->Objects.nonNull(p.getAccount().getCity()))
				.map(p->p.getAccount().getCity())
				.collect(Collectors.toSet());
	}

}
