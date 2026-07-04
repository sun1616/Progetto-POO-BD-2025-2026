--
-- PostgreSQL database dump
--

\restrict uVpkVmBtfqPygTbaYNRXA3fQKENsqdGVucVer010ifYPE6IG7faAujID11L7jPn

-- Dumped from database version 18.4
-- Dumped by pg_dump version 18.4

-- Started on 2026-07-04 16:35:32 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 223 (class 1255 OID 16441)
-- Name: update_numero_iscritti(); Type: FUNCTION; Schema: public; Owner: -
--

CREATE FUNCTION public.update_numero_iscritti() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        UPDATE account 
        SET numero_iscritti = numero_iscritti + 1 
        WHERE id_account = NEW.following_id;
    ELSIF (TG_OP = 'DELETE') THEN
        UPDATE account 
        SET numero_iscritti = numero_iscritti - 1 
        WHERE id_account = OLD.following_id;
    END IF;
    RETURN NULL;
END;
$$;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16403)
-- Name: account; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.account (
    id_account text CONSTRAINT "Account_ID_Account_not_null" NOT NULL,
    nome text CONSTRAINT "Account_nome_not_null" NOT NULL,
    email text CONSTRAINT "Account_email_not_null" NOT NULL,
    password text CONSTRAINT "Account_password_not_null" NOT NULL,
    numero_iscritti integer DEFAULT 0,
    numero_video integer DEFAULT 0,
    numero_streaming integer DEFAULT 0
);


--
-- TOC entry 222 (class 1259 OID 16464)
-- Name: recensione; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.recensione (
    id_recensione text CONSTRAINT recensione_id_rencensione_not_null NOT NULL,
    id_account text CONSTRAINT recensione_id_acount_not_null NOT NULL,
    id_video text NOT NULL,
    descrizione text NOT NULL,
    numero_like integer DEFAULT 0
);


--
-- TOC entry 220 (class 1259 OID 16417)
-- Name: subscription; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.subscription (
    follower_id text NOT NULL,
    following_id text NOT NULL
);


--
-- TOC entry 221 (class 1259 OID 16443)
-- Name: video; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.video (
    id_video text NOT NULL,
    id_account text NOT NULL,
    titolo text NOT NULL,
    descrizione text,
    tipo text,
    numero_like integer DEFAULT 0,
    numero_visual integer DEFAULT 0,
    durata_secondi integer NOT NULL
);


--
-- TOC entry 3849 (class 0 OID 16403)
-- Dependencies: 219
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.account (id_account, nome, email, password, numero_iscritti, numero_video, numero_streaming) FROM stdin;
ACC003	Luca Verdi	luca.verdi@example.com	Mysecretpwd	1	0	0
ACC001	Marco Rossi	marco.rossi@example.com	Pass1234	0	0	0
ACC002	Giulia Bianchi	giulia.b@example.com	Secure987	1	0	0
ACC004	Sofia Esposito	sofia.e@example.com	Password2026	0	0	0
ACC006	BB1	22@	AA	0	0	0
ACC005	Alessandro Marino	alessandro.m@example.com	Admin4321	1	0	0
ACC007	33	33@	AA	1	0	0
ACC008	cccc	cccc@	AA	1	0	0
\.


--
-- TOC entry 3852 (class 0 OID 16464)
-- Dependencies: 222
-- Data for Name: recensione; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.recensione (id_recensione, id_account, id_video, descrizione, numero_like) FROM stdin;
REC009	ACC004	VID005	La prima posizione è strameritata, non vedo l'ora che esca!	67
REC007	ACC003	VID004	Il pattern DAO spiegato in modo semplice, perfetto per i progetti universitari.	37
REC004	ACC004	VID002	Molto utile per l'esame di database, salvato nei preferiti!	10
REC006	ACC005	VID003	Il sound design è fantastico, la traccia scorre benissimo.	55
REC005	ACC001	VID003	Perfetta per programmare di notte, trasmette una calma incredibile.	90
REC013	ACC003	VID007	Che nostalgia di Tokyo! Video girato ed editato benissimo.	46
REC001	ACC001	VID001	Spiegazione chiarissima! Ideale per chi inizia con le GUI in Java.	16
REC032	ACC008	VID016	Inserisci la tua recensione	0
REC002	ACC003	VID001	Finalmente un tutorial fatto bene su IntelliJ e Swing. Grazie!	25
REC003	ACC002	VID002	Ottima guida, ho risolto i problemi con le variabili d'ambiente.	42
REC008	ACC002	VID004	Ottimo focus sulla separazione della logica aziendale dalla persistenza.	19
REC010	ACC005	VID005	Alcuni di questi film mi erano sfuggiti, ottima selezione.	12
REC011	ACC001	VID006	Niente panna, solo tuorlo e pecorino romano. Questa è la vera ricetta!	120
REC012	ACC002	VID006	Il trucco dell'acqua di cottura per la cremina funziona sempre.	75
REC015	ACC001	VID008	Il comparto tecnico e il gameplay strategico sembrano pazzeschi.	29
REC016	ACC004	VID008	Analisi approfondita, concordo pienamente sul potenziale di questo titolo.	17
REC017	ACC002	VID009	Fatto stamattina, molto intenso ma super efficace per iniziare la giornata.	50
REC018	ACC005	VID009	Perfetto per chi ha poco tempo ma vuole rimanere in forma.	22
REC020	ACC001	VID010	Ottimi benchmark, spero solo che ottimizzino i consumi.	41
REC021	ACC004	VID011	L'uso corretto degli indici fa davvero miracoli sulle query complesse.	112
REC022	ACC002	VID011	Spiegazione magistrale di EXPLAIN ANALYZE, video utilissimo!	83
REC023	ACC005	VID012	Il Japan Rail Pass conviene ancora? Ottima guida comunque.	61
REC024	ACC003	VID012	Consigli utilissimi sui bagagli grandi, mi hai salvato il viaggio.	34
REC025	ACC001	VID013	Idratazione al 70% e lunga lievitazione, il risultato è spettacolare!	143
REC026	ACC004	VID013	La spiegazione scientifica della maglia glutinica è eccezionale.	92
REC027	ACC002	VID014	Un'analisi architettonica e ingegneristica davvero affascinante.	27
REC028	ACC005	VID014	Splendido video culturale, la statica delle volte è pura arte.	15
REC029	ACC001	VID015	Che partita fantastica, un'intensità di gioco straordinaria!	205
REC030	ACC003	VID015	Analisi tattica veloce ma dritta al punto. Forza Napoli sempre!	189
REC014	ACC005	VID007	Il Giappone è una meta da sogno, aspetto il giorno 2!	42
REC019	ACC003	VID010	Prestazioni incredibili con il Ray Tracing attivo, ma il prezzo è alto.	95
REC033	ACC008	VID016	Inserisci la tua recensione	0
\.


--
-- TOC entry 3850 (class 0 OID 16417)
-- Dependencies: 220
-- Data for Name: subscription; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.subscription (follower_id, following_id) FROM stdin;
ACC001	ACC002
ACC004	ACC003
ACC007	ACC005
ACC007	ACC007
ACC008	ACC008
\.


--
-- TOC entry 3851 (class 0 OID 16443)
-- Dependencies: 221
-- Data for Name: video; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.video (id_video, id_account, titolo, descrizione, tipo, numero_like, numero_visual, durata_secondi) FROM stdin;
VID004	ACC005	💡 Introduzione al pattern BCE e DAO	Scrivere codice che funziona è facile, ma mantenerlo ordinato e scalabile quando il progetto cresce è tutta un'altra storia. Se ti sei mai trovato con una singola classe di mille righe in cui l'interfaccia grafica si collega direttamente al database, questo video fa per te!	Tutorial	216	4119	2800
VID008	ACC003	🎮 Perché Arknights Endfield è un Capolavoro	Se pensavate che il panorama degli Action RPG open-world avesse già detto tutto, preparatevi a ricredervi. Arknights: Endfield non è solo un altro titolo anime, ma un'esperienza rivoluzionaria che fonde combattimenti frenetici, esplorazione e una gestione industriale dei materiali mai vista prima!	Gaming	3252	79906	2026
VID005	ACC001	🍿 Top 10 Film di Fantascienza del 2025	In questo video esploreremo la nostra classifica definitiva dei 10 migliori film Sci-Fi dell'ultimo anno. Senza fare spoiler pesanti, analizzeremo le trame più originali, i colpi di scena più assurdi e quegli effetti visivi che vi terranno incollati allo schermo. Preparate i popcorn, si parte per il futuro!	Cinema	1890	54209	720
VID001	ACC005	🎬 Tutorial Java Swing per Principianti	Sei stanco delle solite applicazioni Java che girano solo sulla riga di comando? È il momento di fare il salto di qualità e dare un volto visivo al tuo codice! In questo video esploreremo passo dopo passo come progettare e sviluppare interfacce grafiche (GUI) moderne, intuitive e altamente professionali utilizzando Java Swing.	Tutorial	344	15213	2400
VID012	ACC002	🚅 Shinkansen: Come Viaggiare in Giappone	Viaggiare in Giappone è un sogno, ma spostarsi tra Tokyo e Kyoto può sembrare complicatissimo tra tessere della metro e prenotazioni dei posti. Ecco la guida definitiva per usare i treni proiettile Shinkansen, evitare gli errori più comuni e viaggiare a quasi 300km/h senza stress!	Vlog	12312	12033	13133
VID002	ACC005	🔥 Come configurare PostgreSQL su Windows	Hai bisogno di un database relazionale potente, scalabile e gratuito per i tuoi progetti, ma non sai da dove iniziare? In questo video vedremo passo dopo passo come installare e configurare PostgreSQL sul tuo sistema Windows in meno di 10 minuti!	Database	512	8913	3000
VID003	ACC002	🎵 Musica Lo-Fi per Studiare e Concentrarsi	Mettiti comodo, indossa le cuffie e lascia che queste sonorità morbide e ritmi rilassanti accompagnino la tua sessione di studio o di lettura. Perfetto come musica di sottofondo per preparare esami, scrivere la tesi o semplicemente per staccare la mente dopo una giornata intensa.	Musica	4500	12312	1400
VID010	ACC003	💻 Recensione Nuova Scheda Video Nvidia	Nvidia ha finalmente rilasciato la sua nuova, attesissima scheda video di punta! Ma la domanda che tutti si fanno è: vale davvero la pena fare l'upgrade o è solo una mossa di marketing guidata dall'hype dell'intelligenza artificiale?	Tech	2401	67008	1000
VID006	ACC004	🍳 Cucinare la Carbonara Perfetta	Diciamoci la verità: preparare una carbonara è facile, ma farla perfetta, cremosa al punto giusto e senza l'effetto frittata, è una vera e propria arte. Niente panna, niente cipolla: oggi vedremo la ricetta originale romana passo dopo passo!	Cucina	3200	78910	1200
VID009	ACC004	💪 Allenamento Full Body a Casa 20 Minuti	Non hai tempo per andare in palestra? Nessun problema! Questo allenamento Full Body di 20 minuti è studiato per farti sudare, attivare tutti i muscoli del corpo e accelerare il metabolismo, il tutto direttamente nel salotto di casa tua e senza alcun attrezzo.	Sport	870	24508	2400
VID011	ACC003	⚡ Database 10x Più Veloce! Trucchi di Ottimizzazione SQL	La tua applicazione si blocca a causa di caricamenti infiniti? Molto spesso il colpevole è una query SQL lenta o scritta male. In questo video pratico vedremo come individuare i colli di bottiglia nel tuo database PostgreSQL in pochi click e come velocizzare i tempi di caricamento di oltre X10!	Tutorial	10000	23330	22321
VID007	ACC002	✈️ Vlog Viaggio in Giappone - Giorno 1	Il sogno finalmente si avvera! Inizia ufficialmente il nostro viaggio nel Paese del Sol Levante. In questo primo giorno atterriamo a Tokyo e veniamo subito travolti dall'incredibile energia della metropoli più grande del mondo.	Vlog	1100	31211	2000
VID014	ACC006	⚙️ La Statica e la Struttura della Basilica della Santa Croce	Come ha fatto Filippo Brunelleschi a costruire la cupola in muratura più grande del mondo senza usare impalcature tradizionali di supporto? Scopriamo i misteri geometrici e i segreti ingegneristici nascosti tra le mura della Struttura della Basilica della Santa Croce	Vlog	12112	10000	12225
VID015	ACC004	⚽ Napoli: Highlights e Gol! 	Rivivi le emozioni del match del Napoli con gli highlights più spettacolari! Non solo gol e parate, ma un’analisi rapida dei movimenti chiave che hanno deciso la partita. Sei pronto a scoprire perché questa vittoria è stata fondamentale?	Sport	12540	11123	33355
VID013	ACC004	🍕 Pizza Napoletana a Casa: La Scienza dell'Impasto Perfetto	Fare una pizza napoletana a casa, morbida e leggera come in pizzeria, sembra impossibile con un forno normale. Oggi scopriremo i segreti scientifici dell'idratazione e dell'impasto perfetto per ottenere una cottura da veri professionisti nel forno della tua cucina!	Cucina	12131	4556	44454
VID016	ACC008	a	a	a	0	1	1
\.


--
-- TOC entry 3689 (class 2606 OID 16416)
-- Name: account Account_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT "Account_pkey" PRIMARY KEY (id_account);


--
-- TOC entry 3695 (class 2606 OID 16473)
-- Name: recensione recensione_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_pkey PRIMARY KEY (id_recensione);


--
-- TOC entry 3691 (class 2606 OID 16425)
-- Name: subscription subscription_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.subscription
    ADD CONSTRAINT subscription_pkey PRIMARY KEY (follower_id, following_id);


--
-- TOC entry 3693 (class 2606 OID 16460)
-- Name: video video_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.video
    ADD CONSTRAINT video_pkey PRIMARY KEY (id_video);


--
-- TOC entry 3701 (class 2620 OID 16442)
-- Name: subscription trigger_numero_iscritti; Type: TRIGGER; Schema: public; Owner: -
--

CREATE TRIGGER trigger_numero_iscritti AFTER INSERT OR DELETE ON public.subscription FOR EACH ROW EXECUTE FUNCTION public.update_numero_iscritti();


--
-- TOC entry 3699 (class 2606 OID 16476)
-- Name: recensione id_acount; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT id_acount FOREIGN KEY (id_account) REFERENCES public.account(id_account) NOT VALID;


--
-- TOC entry 3700 (class 2606 OID 16481)
-- Name: recensione id_video; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT id_video FOREIGN KEY (id_video) REFERENCES public.video(id_video) NOT VALID;


--
-- TOC entry 3696 (class 2606 OID 16426)
-- Name: subscription subscription_follower_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.subscription
    ADD CONSTRAINT subscription_follower_id_fkey FOREIGN KEY (follower_id) REFERENCES public.account(id_account) ON DELETE CASCADE;


--
-- TOC entry 3697 (class 2606 OID 16431)
-- Name: subscription subscription_following_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.subscription
    ADD CONSTRAINT subscription_following_id_fkey FOREIGN KEY (following_id) REFERENCES public.account(id_account) ON DELETE CASCADE;


--
-- TOC entry 3698 (class 2606 OID 16453)
-- Name: video video_id_account_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.video
    ADD CONSTRAINT video_id_account_fkey FOREIGN KEY (id_account) REFERENCES public.account(id_account) ON DELETE SET NULL;


-- Completed on 2026-07-04 16:35:32 CEST

--
-- PostgreSQL database dump complete
--

\unrestrict uVpkVmBtfqPygTbaYNRXA3fQKENsqdGVucVer010ifYPE6IG7faAujID11L7jPn

