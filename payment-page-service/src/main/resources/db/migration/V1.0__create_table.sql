CREATE TABLE IF NOT EXISTS payment_page (
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS payment_page_option (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    coins_amount    BIGINT UNSIGNED NOT NULL,
    price           DECIMAL(15, 2)  NOT NULL,
    payment_page_id BIGINT,
    FOREIGN KEY (payment_page_id) REFERENCES payment_page(id)
);