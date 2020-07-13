CREATE TABLE customer (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(75) NOT NULL,
    email VARCHAR(100) NOT NULL,
    total_sales INTEGER,
    total_spent DECIMAL(8,2),
    favorite_category INTEGER
);

CREATE TABLE item (
    serial_number UUID NOT NULL,
    category_id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(8,2) NOT NULL,
    description VARCHAR(400) NOT NULL,
    store_quantity INTEGER,
    online_quantity INTEGER
);

CREATE TABLE sale (
    id SERIAL NOT NULL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    item_serial_number UUID NOT NULL,
    quantity INTEGER NOT NULL,
    stock_location INTEGER NOT NULL,
    shipping_address VARCHAR(150) NOT NULL,
    sale_date CURRENT_DATE,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE refund (
    id SERIAL NOT NULL PRIMARY KEY,
    sale_id INTEGER NOT NULL,
    customer_id INTEGER NOT NULL,
    item_serial_number UUID NOT NULL,
    quantity INTEGER NOT NULL,
    stock_location INTEGER NOT NULL,
    shipping_address VARCHAR(150) NOT NULL,
    refund_date CURRENT_DATE,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);