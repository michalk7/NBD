printjson(
    db.people.find(
        {
            "weight": { "$gte": "68.0", "$lt": "71.5" }
        }
    ).toArray()
)
