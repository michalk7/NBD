var mapFun = function() {
	emit(this.sex, {weight: this.weight, height: this.height, count: 1});
};

var reduceFun = function(key, values) {
	reducedVal = {sum_weight: 0, sum_height: 0, count: 0}
	for (let i = 0; i < values.length; i++) {
		reducedVal.sum_weight += values[i].weight;
		reducedVal.sum_height += values[i].height;
		reducedVal.count += values[i].count;
	}
	return reducedVal;
};

var finalizeFun = function(key, reducedVal) {
	reducedVal.avg_weight = reducedVal.sum_weight/reducedVal.count;
	reducedVal.avg_height = reducedVal.sum_height/reducedVal.count;
	return {
		avg_weight: reducedVal.avg_weight,
		avg_height: reducedVal.avg_height
	};
};

db.people.mapReduce(
	mapFun, 
	reduceFun, 
	{
		out: "avg_weight_height_per_sex", 
		finalize: finalizeFun
	}
)

printjson(db.avg_weight_height_per_sex.find().toArray())
