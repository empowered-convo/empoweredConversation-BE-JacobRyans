DELETE
FROM category;

DELETE
FROM conversation;

DELETE
FROM  resource;

INSERT INTO category(categoryid, categoryname) VALUES (1, 'Harassment'), (2, 'Sexual Abuse');

INSERT INTO conversation(conversationid, survivorname, survivornumber, ffname, ffnumber, categoryid) VALUES (1, 'John', '318-112-3827', 'Jane', '318-321-4823', 1), (2, 'Meg', '318-421-5782', 'Johnny', '281-382-2818', 2);

INSERT INTO resource(resourceid, title, textbody, author, categoryid) VALUES (1, 'Harassment Resource','This is a resource body.', 'Zachory Phillips', 1), (2, 'Sexual Abuse Resource', 'New resource body.', 'New guy', 2);

alter sequence hibernate_sequence restart with 20;