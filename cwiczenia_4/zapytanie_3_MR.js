db.people.mapReduce(
	function() {
		emit(this.job, 1);
	},
	function(key, value) {
		return key;
	},
	{
		out: "distinct_job"
	}
)

printjson(db.distinct_job.find().toArray())
