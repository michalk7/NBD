var mapFun = function() {
	bmi = this.weight/Math.pow(this.height/100, 2)
	emit(this.nationality, {bmi: bmi, bmi_min: bmi, bmi_max: bmi, counter: 1});
};


var reduceFun = function(key, values) {
	reducedVal = {bmi_sum: 0, bmi_min: values[0].bmi_min, bmi_max: values[0].bmi_max, counter: 0}

	for (let i = 0; i < values.length; i++){
		if (values[i].bmi > reducedVal.bmi_max){
			reducedVal.bmi_max = values[i].bmi
		}
		else if (values[i].bmi < reducedVal.bmi_min){
			reducedVal.bmi_min = values[i].bmi
		}
		reducedVal.bmi_sum += values[i].bmi
		reducedVal.counter += values[i].counter
	}
	return reducedVal;
};

var finalizeFun = function(key, reducedVal) {
	return {
		min_bmi: reducedVal.bmi_min,
		avg_bmi: reducedVal.bmi_sum/reducedVal.counter,
		max_bmi: reducedVal.bmi_max
	}
};

db.people.mapReduce(
	mapFun,
	reduceFun,
	{
		out: "bmi_per_nationality",
		finalize: finalizeFun
	}
);

printjson(db.bmi_per_nationality.find().toArray())
