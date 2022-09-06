

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 56062)
-- Name: authentification; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.authentification (
    idpersonnel integer NOT NULL,
    login character(10),
    passe character(32),
    service integer
);


ALTER TABLE public.authentification OWNER TO sio1;

--
-- TOC entry 176 (class 1259 OID 56060)
-- Name: authentification_idpersonnel_seq; Type: SEQUENCE; Schema: public; Owner: sio1
--

CREATE SEQUENCE public.authentification_idpersonnel_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authentification_idpersonnel_seq OWNER TO sio1;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 176
-- Name: authentification_idpersonnel_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sio1
--

ALTER SEQUENCE public.authentification_idpersonnel_seq OWNED BY public.authentification.idpersonnel;


--
-- TOC entry 178 (class 1259 OID 56517)
-- Name: commandes; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.commandes (
    idc integer NOT NULL,
    fournisseur character varying(50),
    medicament character varying(50),
    qtte integer
);


ALTER TABLE public.commandes OWNER TO sio1;

--
-- TOC entry 180 (class 1259 OID 56599)
-- Name: demande; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.demande (
    iddemande integer NOT NULL,
    idservice integer NOT NULL,
    idmedicament integer NOT NULL,
    quantite integer
);


ALTER TABLE public.demande OWNER TO sio1;

--
-- TOC entry 179 (class 1259 OID 56597)
-- Name: demande_iddemande_seq; Type: SEQUENCE; Schema: public; Owner: sio1
--

CREATE SEQUENCE public.demande_iddemande_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.demande_iddemande_seq OWNER TO sio1;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 179
-- Name: demande_iddemande_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sio1
--

ALTER SEQUENCE public.demande_iddemande_seq OWNED BY public.demande.iddemande;


--
-- TOC entry 173 (class 1259 OID 55670)
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.fournisseur (
    "idF" integer NOT NULL,
    nom character varying(20) NOT NULL
);


ALTER TABLE public.fournisseur OWNER TO sio1;

--
-- TOC entry 174 (class 1259 OID 55680)
-- Name: medicament; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.medicament (
    idm integer NOT NULL,
    libelle character varying(25) NOT NULL,
    qtte integer NOT NULL,
    seuil integer NOT NULL,
    categorie character varying(25)
);


ALTER TABLE public.medicament OWNER TO sio1;

--
-- TOC entry 175 (class 1259 OID 56049)
-- Name: service; Type: TABLE; Schema: public; Owner: sio1
--

CREATE TABLE public.service (
    idservice integer NOT NULL,
    libelle character varying(20)
);


ALTER TABLE public.service OWNER TO sio1;

--
-- TOC entry 1907 (class 2604 OID 56065)
-- Name: authentification idpersonnel; Type: DEFAULT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.authentification ALTER COLUMN idpersonnel SET DEFAULT nextval('public.authentification_idpersonnel_seq'::regclass);


--
-- TOC entry 1908 (class 2604 OID 56602)
-- Name: demande iddemande; Type: DEFAULT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.demande ALTER COLUMN iddemande SET DEFAULT nextval('public.demande_iddemande_seq'::regclass);


--
-- TOC entry 2036 (class 0 OID 56062)
-- Dependencies: 177
-- Data for Name: authentification; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.authentification (idpersonnel, login, passe, service) VALUES (1, 'Valentin  ', '827CCB0EEA8A706C4C34A16891F84E7B', 2);
INSERT INTO public.authentification (idpersonnel, login, passe, service) VALUES (3, 'Charly    ', 'F0D41400626D1B9457628E9F874D0804', 5);
INSERT INTO public.authentification (idpersonnel, login, passe, service) VALUES (2, 'Antoine   ', 'B9A6D02F68947DDF2EDC86A59C3AF4CA', 1);


--
-- TOC entry 2037 (class 0 OID 56517)
-- Dependencies: 178
-- Data for Name: commandes; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (1, 'Hauser', 'Spasfon', 50);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (2, 'Seppic', 'Ventoline', 100);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (3, 'ACS Phyto', 'Spasfon', 40);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (4, 'Endress', 'Compresse', 8);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (5, 'Zwiebel', 'Codéïne', 24);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (6, 'Seppic', 'Tramadol', 4);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (7, 'Horizane Sante', 'Codéïne', 600);
INSERT INTO public.commandes (idc, fournisseur, medicament, qtte) VALUES (8, 'Hauser', 'Ventoline', 12);


--
-- TOC entry 2039 (class 0 OID 56599)
-- Dependencies: 180
-- Data for Name: demande; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.demande (iddemande, idservice, idmedicament, quantite) VALUES (2, 5, 5, 50);
INSERT INTO public.demande (iddemande, idservice, idmedicament, quantite) VALUES (1, 3, 7, 10);


--
-- TOC entry 2032 (class 0 OID 55670)
-- Dependencies: 173
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.fournisseur ("idF", nom) VALUES (1, 'Horizane Sante');
INSERT INTO public.fournisseur ("idF", nom) VALUES (2, 'Endress');
INSERT INTO public.fournisseur ("idF", nom) VALUES (3, 'Hauser');
INSERT INTO public.fournisseur ("idF", nom) VALUES (4, 'ACS Phyto');
INSERT INTO public.fournisseur ("idF", nom) VALUES (5, 'Zwiebel');
INSERT INTO public.fournisseur ("idF", nom) VALUES (6, 'Seppic');
INSERT INTO public.fournisseur ("idF", nom) VALUES (7, 'Lavollee');
INSERT INTO public.fournisseur ("idF", nom) VALUES (8, 'Caquant');


--
-- TOC entry 2033 (class 0 OID 55680)
-- Dependencies: 174
-- Data for Name: medicament; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (6, 'Lisopaïne', 653, 200, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (7, 'Morphine', 326, 200, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (8, 'Codéïne', 284, 200, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (10, 'Compresse', 252, 200, 'Matériel Médical');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (9, 'Tramadol', 311, 400, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (5, 'Spasfon', 360, 200, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (3, 'Smecta', 1300, 200, 'Antalgique');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (4, 'Ventoline', 488, 200, 'Pneumologie');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (2, 'Xanax', 670, 200, 'Psychiatrie');
INSERT INTO public.medicament (idm, libelle, qtte, seuil, categorie) VALUES (1, 'Bandage', 590, 200, 'Matériel Médical');


--
-- TOC entry 2034 (class 0 OID 56049)
-- Dependencies: 175
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: sio1
--

INSERT INTO public.service (idservice, libelle) VALUES (1, 'Administration');
INSERT INTO public.service (idservice, libelle) VALUES (2, 'Pharmacien');
INSERT INTO public.service (idservice, libelle) VALUES (4, 'radiologie');
INSERT INTO public.service (idservice, libelle) VALUES (5, 'chirurgie');
INSERT INTO public.service (idservice, libelle) VALUES (3, 'médecine générale');


--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 176
-- Name: authentification_idpersonnel_seq; Type: SEQUENCE SET; Schema: public; Owner: sio1
--

SELECT pg_catalog.setval('public.authentification_idpersonnel_seq', 21, true);


--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 179
-- Name: demande_iddemande_seq; Type: SEQUENCE SET; Schema: public; Owner: sio1
--

SELECT pg_catalog.setval('public.demande_iddemande_seq', 2, true);


--
-- TOC entry 1910 (class 2606 OID 55674)
-- Name: fournisseur Fournisseur_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT "Fournisseur_pkey" PRIMARY KEY ("idF");


--
-- TOC entry 1914 (class 2606 OID 56053)
-- Name: service Service_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.service
    ADD CONSTRAINT "Service_pkey" PRIMARY KEY (idservice);


--
-- TOC entry 1912 (class 2606 OID 55684)
-- Name: medicament Stock_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.medicament
    ADD CONSTRAINT "Stock_pkey" PRIMARY KEY (idm);


--
-- TOC entry 1916 (class 2606 OID 56067)
-- Name: authentification authentification_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.authentification
    ADD CONSTRAINT authentification_pkey PRIMARY KEY (idpersonnel);


--
-- TOC entry 1918 (class 2606 OID 56521)
-- Name: commandes commandes_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.commandes
    ADD CONSTRAINT commandes_pkey PRIMARY KEY (idc);


--
-- TOC entry 1920 (class 2606 OID 56604)
-- Name: demande demande_pkey; Type: CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.demande
    ADD CONSTRAINT demande_pkey PRIMARY KEY (iddemande);


--
-- TOC entry 1922 (class 2606 OID 56605)
-- Name: demande ce_idmedicament_idm; Type: FK CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.demande
    ADD CONSTRAINT ce_idmedicament_idm FOREIGN KEY (idmedicament) REFERENCES public.medicament(idm);


--
-- TOC entry 1921 (class 2606 OID 56068)
-- Name: authentification fk_service_idservicce; Type: FK CONSTRAINT; Schema: public; Owner: sio1
--

ALTER TABLE ONLY public.authentification
    ADD CONSTRAINT fk_service_idservicce FOREIGN KEY (service) REFERENCES public.service(idservice);


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2021-10-22 15:58:59

--
-- PostgreSQL database dump complete
--

