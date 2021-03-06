CREATE SCHEMA IF NOT EXISTS client;

create sequence IF NOT EXISTS client.CLIENT_ID_SEQUENCE start with 1 increment by 1;

create table IF NOT EXISTS client.CLIENT (
       ID integer not null,
        BIRTH_DATE date,
        EMAIL varchar(80),
        NAME varchar(80),
        PHONE_NUMBER bigint,
        primary key (ID)
    );  

DELETE FROM client.CLIENT;

INSERT INTO client.CLIENT (ID, NAME, BIRTH_DATE, EMAIL, PHONE_NUMBER) 
VALUES ( nextval('client.CLIENT_ID_SEQUENCE'), 'John Smith','1983-03-25','john@tst.com', 5561984881234);

INSERT INTO client.CLIENT (ID, NAME, BIRTH_DATE, EMAIL, PHONE_NUMBER) 
VALUES ( nextval('client.CLIENT_ID_SEQUENCE'), 'William','1988-03-28','william@tst.com', 5592743881234);

INSERT INTO client.CLIENT (ID, NAME, BIRTH_DATE, EMAIL, PHONE_NUMBER) 
VALUES ( nextval('client.CLIENT_ID_SEQUENCE'), 'Marcus','1995-03-28','marcus@tst.com', 5592743789564);

INSERT INTO client.CLIENT (ID, NAME, BIRTH_DATE, EMAIL, PHONE_NUMBER) 
VALUES ( nextval('client.CLIENT_ID_SEQUENCE'), 'Karen','1980-02-22','karen@tst.com', 5892755788746);
