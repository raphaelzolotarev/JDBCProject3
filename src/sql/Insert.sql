insert into user
    (username,
     email,
     role,
     password,
     createdAt,
     updatedAt)
VALUES
    ('abdelkrim', 'abdelkrim@gmail.com', 'client', 'abdelkrim1234', '2024-03-26 10:00:00', null),
    ('elmaz', 'elmaz@gmail.com', 'admin', 'elmaz1234', '2018-03-12 23:55:00', null),
    ('elon', 'elon@gmail.com', 'writter', 'elon1234', '2001-05-17 05:31:00', null)
    ;

insert into post(userId, title, slug, views, image, body, published, createdAt, updatedAt)
values (1, 'The Rise of Artificial Intelligence in Healthcare', 'the-rise-of-ai-in-healthcare', 1550, null, 'Explore how artificial intelligence is revolutionizing healthcare, from diagnosing diseases to personalized treatment plans, and its potential impact on improving patient outcomes and reducing healthcare costs.', 1, '2024-03-26 11:00:00', null),
       (2, 'Sustainable Fashion: Redefining Style with Eco-Friendly Practices', 'sustainable-fashion-redefining-style', 190, null, 'Dive into the world of sustainable fashion and learn how eco-friendly materials, ethical manufacturing processes, and circular fashion initiatives are reshaping the industry to create stylish, environmentally conscious clothing options.', 1, '2018-03-12 01:55:00', null),
       (3, 'The Power of Mindfulness: Cultivating Mental Wellness in a Busy World', 'power-of-mindfulness-mental-wellness', 3, null, 'Discover the benefits of mindfulness practices in promoting mental wellness and managing stress. Learn simple techniques to incorporate mindfulness into your daily routine and enhance your overall well-being in today''s fast-paced world.', 1, '2001-05-17 06:31:00', null);


insert into topic(name, slug)
values ('Exploring Quantum Computing', 'exploring-quantum-computing'),
       ('The Future of Remote Work', 'future-of-remote-work'),
       ('Climate Change and Biodiversity Loss', 'climate-change-biodiversity-loss'),
       ('Blockchain Technology: Beyond Cryptocurrency', 'blockchain-technology-beyond-crypto'),
       ('Mental Health Awareness in the Workplace', 'mental-health-awareness-workplace');

insert into postlike(postid, userid)
VALUES (1,1),
       (1,2),
       (1,3),
       (2,1),
       (2,2),
       (2,3),
       (3,1),
       (3,2),
       (3,3);

insert into posttopic(postid, topicid)
VALUES (1,1),
       (2,2),
       (3,3);