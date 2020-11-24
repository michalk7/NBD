var mapFun = function() {
	this.credit.forEach(card => {
		emit(card.currency, {balance: card.balance});
	});
};

var reduceFun = function(key, values) {
	reducedVal = { balance_sum: 0, counter: 0 }
	values.forEach(card => {
		reducedVal.balance_sum += card.balance;
		reducedVal.counter += 1
	});

	return reducedVal;
};

db.people.mapReduce(
	mapFun,
	reduceFun,
	{
		query: { sex: "Female", nationality: "Poland"},
		out: 'female_poland_balance_per_currency',
		finalize: function(key, values) {
				return {
					avg_balance: values.balance_sum/values.counter,
					total_balance: values.balance_sum
				}
			}
	}
)

printjson(db.female_poland_balance_per_currency.find().toArray())
