-- Database: pizzaria

-- DROP DATABASE pizzaria;

CREATE DATABASE IF NOT EXISTS pizzaria
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE pizzaria
    IS 'Banco de dados da pizzaria';

CREATE TABLE IF NOT EXISTS public.clientes(
    id integer NOT NULL,
    email character varying NOT NULL,
    nome character varying NOT NULL,
    senha character varying(64) NOT NULL,
    status character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.clientes
    OWNER to postgres;
COMMENT ON TABLE public.clientes
    IS 'Tabela guarda informações dos usuários/clientes ';

-- Table: public.pedidos

-- DROP TABLE public.pedidos;

CREATE TABLE IF NOT EXISTS public.pedidos
(
    idpedido integer NOT NULL,
    endereco character varying COLLATE pg_catalog."default" NOT NULL,
    data date NOT NULL,
    pedido json NOT NULL,
    idcliente integer NOT NULL,
    CONSTRAINT pedidos_pkey PRIMARY KEY (idpedido),
    CONSTRAINT clientepedidos FOREIGN KEY (idpedido)
        REFERENCES public.clientes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.pedidos
    OWNER to postgres;
COMMENT ON TABLE public.pedidos
    IS 'Tabela armazena pedidos dos clientes , unica tabela que pode ser acessada por clientes ';

COMMENT ON CONSTRAINT clientepedidos ON public.pedidos
    IS 'Relação 1 cliente para n pedidos ';
