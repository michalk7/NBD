printjson(
    db.people.insertOne(
        {
            "sex" : "Male",
            "first_name" : "Michal",
            "last_name" : "Kubara",
            "job" : "Student",
            "email" : "s15122@pjwstk.edu.pl",
            "location" : {
                "city" : "Warszawa",
                "address" : {
                    "streetname" : "Koszykowa",
                    "streetnumber" : "86"
                }
            },
            "description" : "lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem",
            "height" : "185.4",
            "weight" : "77.25",
            "birth_date" : "1997-09-10T09:22:24Z",
            "nationality" : "Poland",
            "credit" : [
                {
                    "type" : "visa",
                    "number" : "56022541652043117",
                    "currency" : "PLN",
                    "balance" : "13843.63"
                }
            ]
        }
    )
)
