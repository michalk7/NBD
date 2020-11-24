db.people.mapReduce(
	function() {
		this.credit.forEach(card => {
			emit(card.currency, card.balance);
		});
	},
	function(key, values) {
		return Array.sum(values);
	},
	{
		out: 'total_balance_per_currency'
	}
);

printjson(db.total_balance_per_currency.find().toArray())
