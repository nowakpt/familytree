create table User (
  userId BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(30),
  password VARCHAR(60),
  emailAddress VARCHAR(40)
);

create table Tree (
  treeId BIGINT PRIMARY KEY AUTO_INCREMENT,
  owner BIGINT,
  note LONGTEXT,
  FOREIGN KEY (owner) REFERENCES User(userId)

);

create table TreeAllowedUsers (
  allowedUser BIGINT,
  tree BIGINT,
  PRIMARY KEY (allowedUser,tree),
  FOREIGN KEY (allowedUser) REFERENCES User(userId),
  FOREIGN KEY (tree) REFERENCES Tree(treeId)
);

create table Person (
  personId BIGINT PRIMARY KEY AUTO_INCREMENT,
  tree BIGINT,
  firstName VARCHAR(40),
  lastName VARCHAR(40),
  dateOfBirth DATE,
  dateOfDeath DATE,
  note LONGTEXT,
  father BIGINT,
  mother BIGINT,
  FOREIGN KEY (tree) REFERENCES Tree(treeId),
  FOREIGN KEY (father) REFERENCES Person(personId),
  FOREIGN KEY (mother) REFERENCES Person(personId)

);

create table Marriage (
  marriageId BIGINT PRIMARY KEY AUTO_INCREMENT,
  husband BIGINT,
  wife BIGINT,
  weddingDate DATE,
  FOREIGN KEY (husband) REFERENCES Person(personId),
  FOREIGN KEY (wife) REFERENCES Person(personId)
);
