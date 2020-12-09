#!/usr/bin/env python
# -*- coding: utf-8 -*-

import riak

riakClient = riak.RiakClient(pb_port=8087, protocol='pbc')

myBucket = riakClient.bucket('s15122')

first_person_data = {'nickname': 'andyN','name': 'Andrew Noah', 'height': 190, 'weight': 105, 'hobby': 'skiing'}
#dodanie do bazy
first_person_key = myBucket.new(first_person_data['nickname'], data=first_person_data)
first_person_key.store()

#pobranie z bazy
fetched_person = myBucket.get(first_person_data['nickname'])
#wypisanie
print("Dane dodane do bazy: {}".format(str(fetched_person.data)))

#update
fetched_person.data['height'] = 186
fetched_person.store()

#pobranie po update
print("Update pola 'height'")
person_fetched_again = myBucket.get(first_person_data['nickname'])
#wypisanie
print("Dane po update: {}".format(str(person_fetched_again.data)))

#delete
person_fetched_again.delete()

#pobranie po delete
person_after_delete = myBucket.get(first_person_data['nickname'])
#wypisanie
print("Wynik pobrania usuniętego dokumentu: {}. \nCzy dokument istnieje? {}".format(str(person_after_delete.data), person_after_delete.exists))
