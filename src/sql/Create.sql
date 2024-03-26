create table user(
                     id int primary key auto_increment,
                     username varchar(255),
                     email varchar(255),
                     role varchar(255),
                     password varchar(255),
                     createdAt timestamp,
                     updatedAt timestamp
);

create table post(
                    id int primary key auto_increment,
                    userId int,
                    title varchar(255),
                    slug varchar(255),
                    views int,
                    image varchar(255),
                    body varchar(255),
                    published int,
                    createdAt timestamp,
                    updatedAt timestamp,
                    CONSTRAINT post_user FOREIGN KEY (userId) REFERENCES user (id)
);


create table topic(
                      id int primary key auto_increment,
                      name varchar(255),
                      slug varchar(255)
);

create table postlike(
                      postid int,
                      userid int,
                      CONSTRAINT postlike_post FOREIGN KEY (postid) REFERENCES post (id),
                      CONSTRAINT postlike_user FOREIGN KEY (userid) REFERENCES user (id)
);

create table posttopic(
                         postid int,
                         topicid int,
                         CONSTRAINT posttopic_post FOREIGN KEY (postid) REFERENCES post (id),
                         CONSTRAINT posttopic_topic FOREIGN KEY (topicid) REFERENCES topic (id)
);