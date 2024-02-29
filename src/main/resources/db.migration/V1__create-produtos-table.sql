CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    categoria VARCHAR(255),
    subcategoria VARCHAR(255),
    titulo VARCHAR(255),
    preco VARCHAR(255),
    disponivel VARCHAR(255),
    vendido VARCHAR(255),
    vendedor VARCHAR(255),
    detalhes TEXT
);
