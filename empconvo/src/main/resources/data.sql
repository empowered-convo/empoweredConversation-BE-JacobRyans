INSERT INTO category(categoryname) VALUES ("Sexual Abuse");

INSERT INTO conversation(survivorname, survivornumber, ffname, ffnumber, categoryid) VALUES ("John", "318-112-3827", "Jane", "318-321-4823", 1);

INSERT INTO resource(textbody, author) VALUES ("This is a resource body.", "Zachory Phillips");

alter sequence hibernate_sequence restart with 25;