create table TRANSACTION_TYPE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint TRANSACTION_TYPE_PK
        primary key,
    TYPE VARCHAR(30)
);

create table USER_TYPE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint USER_TYPE_PK
        primary key,
    TYPE VARCHAR(30)
);

create table USERS
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint USER_PK
        primary key,
    USERNAME VARCHAR(64),
    PASSWORD VARCHAR(64),
    ID_USER_TYPE  INTEGER not null
        constraint FK_USER_TYPE
            references USER_TYPE
            on delete cascade
);

create table TRANSACTIONS
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint TRANSACTION_PK
        primary key,
    TRANSACTION_DATE   TIMESTAMP,
    ID_CASHIER         INTEGER not null
        constraint FK_TRANSACTION_USER
            references USERS,
    ID_TYPE            INTEGER not null
        constraint FK_TRANSACTION_TRANSACTION_TYPE
            references TRANSACTION_TYPE,
    VALUE              DOUBLE
);

create table PRODUCT
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint PRODUCT_PK
        primary key,
    PRODUCT_NAME VARCHAR(30),
    PRICE        DOUBLE,
    UNIT      VARCHAR(30),
    QUANTITY INTEGER
);