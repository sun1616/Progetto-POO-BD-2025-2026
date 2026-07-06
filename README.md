Project RiftView

1. Introduzione

Il progetto RiftView consiste nella progettazione e nello sviluppo di una piattaforma di intrattenimento realizzata mediante Java e PostgreSQL. L'applicazione permette agli utenti registrati di pubblicare video, visualizzare contenuti multimediali, interagire attraverso recensioni e like e, in futuro, gestire anche dirette streaming con chat in tempo reale.

L'obiettivo principale del progetto è applicare le conoscenze acquisite nei corsi di Programmazione Object Oriented e Basi di Dati, realizzando un sistema informativo completo che integri un database relazionale con un'applicazione Java organizzata secondo il pattern BCE + DAO. L'architettura separa chiaramente l'interfaccia grafica, la logica applicativa, i modelli del dominio e l'accesso ai dati, garantendo modularità, riutilizzo del codice e facilità di manutenzione.



2. Panoramica del progetto

RiftView è una piattaforma ispirata ai principali servizi di streaming online, progettata per offrire agli utenti uno spazio dedicato alla condivisione e alla fruizione di contenuti digitali.

Il sistema consente agli utenti di:

registrare un nuovo account;
effettuare il login;
pubblicare nuovi video;
consultare l'elenco dei video disponibili;
visualizzare descrizioni, autore, numero di visualizzazioni e like;
interagire con i contenuti mediante recensioni e valutazioni;
utilizzare, nelle future estensioni del progetto, live streaming, chat in tempo reale e contenuti pubblicitari.

Dal punto di vista della base di dati, il sistema è composto principalmente dalle entità Account, Video, LiveStreaming, Recensione, ChatLive e Pubblicità, collegate tramite opportune relazioni e vincoli di integrità.

3. Scelta del tema

Abbiamo scelto di sviluppare una piattaforma di streaming perché rappresenta uno dei sistemi informatici più diffusi e utilizzati nel panorama digitale moderno. Servizi come YouTube e Twitch consentono quotidianamente a milioni di utenti di condividere contenuti multimediali, trasmettere dirette e interagire con altre persone.

Questo dominio applicativo risulta particolarmente adatto allo sviluppo di un progetto universitario poiché permette di applicare numerosi concetti studiati durante il corso, tra cui:

progettazione orientata agli oggetti;
modellazione Entity-Relationship;
realizzazione di database relazionali;
utilizzo dell'ereditarietà (Video → Pubblicità);
gestione delle relazioni tra entità;
implementazione del pattern BCE + DAO;
separazione tra logica applicativa, interfaccia grafica e persistenza dei dati.

Inoltre, la presenza di numerose entità e relazioni rende il progetto facilmente estendibile con nuove funzionalità senza modificarne l'architettura principale.

4. Obiettivi di apprendimento

Durante lo sviluppo del progetto sono stati raggiunti gli obiettivi previsti dal corso.

In particolare sono stati:

raccolti e documentati i requisiti funzionali della piattaforma;
progettato il dominio applicativo mediante diagrammi UML ed Entity-Relationship;
definite le principali operazioni dell'applicazione e implementate tramite metodi Java;
progettato lo schema concettuale e successivamente tradotto nello schema logico del database PostgreSQL;
implementati vincoli di integrità sia a livello applicativo sia a livello database;
applicati i principi della programmazione orientata agli oggetti, come incapsulamento, ereditarietà e riutilizzo del codice;
sviluppata un'applicazione Java funzionante organizzata secondo il pattern BCE + DAO;
implementate le operazioni di persistenza dei dati mediante classi DAO;
realizzata la connessione tra applicazione e database PostgreSQL;
predisposto il progetto per future estensioni quali streaming live, recensioni complete e gestione della pubblicità.

5. Elaborati consegnati

Per il progetto vengono consegnati i seguenti elaborati:
relazione completa del progetto;
diagramma UML delle classi;
diagramma Entity-Relationship;
codice sorgente Java;
progetto Maven completo di file pom.xml;
script SQL per la creazione del database;
implementazione dell'architettura BCE + DAO.

Per quanto riguarda la base di dati, è stato progettato un database composto dalle seguenti entità:

Account, che rappresenta gli utenti registrati;
Video, contenente tutti i contenuti caricati;
Pubblicità, specializzazione della classe Video;
Recensione, utilizzata per i commenti degli utenti;
LiveStreaming, dedicata alle dirette;
ChatLive, utilizzata per la comunicazione durante le dirette.

Tra queste entità sono state definite relazioni, chiavi primarie, chiavi esterne e vincoli di integrità necessari a garantire la coerenza dei dati. Sono inoltre presenti regole di business, come l'unicità dell'email degli utenti e il corretto formato della durata dei video.

6. Componenti del gruppo

Il progetto è stato sviluppato dal gruppo composto da:

Cristian Solmonese (DE1000197)
Junhao Sun (DE1000309)

La distribuzione del lavoro è stata la seguente:



Cristian Solmonese

ideazione del progetto;
progettazione del diagramma Entity-Relationship;
definizione delle entità, attributi e relazioni;
realizzazione della documentazione principale;
descrizione delle classi e dell'architettura software.

Junhao Sun

Sviluppo dell applicazione Java;
definizione delle entità, attributi e relazioni;
gestione della repository GitHub;
supporto nella progettazione della base di dati.

7. Struttura del progetto (Programmazione Object Oriented)

L'intera applicazione è stata sviluppata seguendo il pattern architetturale BCE + DAO, richiesto dalle specifiche del progetto.

L'architettura è suddivisa nei seguenti package:

gui: contiene tutte le schermate dell'applicazione (Login, Home, Video, AddVideo, VideoDettaglio e Account), responsabili dell'interazione con l'utente.
controller: contiene la logica applicativa. Il Controller coordina le operazioni tra interfaccia grafica, modelli e database.
model: rappresenta il dominio applicativo mediante le classi Account, Video, Recensione, LiveStreaming, ChatLive e Pubblicità.
dao: contiene le interfacce DAO e le relative implementazioni, utilizzate per l'accesso ai dati persistenti.
database: comprende la classe ConnessioneDatabase, responsabile della connessione al database PostgreSQL attraverso il pattern Singleton.

L'applicazione implementa attualmente le principali funzionalità della piattaforma:

registrazione degli utenti;
autenticazione tramite login;
caricamento di nuovi video;
visualizzazione dell'elenco dei video;
consultazione dei dettagli di un contenuto;
gestione dei dati tramite database PostgreSQL;
utilizzo di eccezioni personalizzate per migliorare la gestione degli errori.

Questa organizzazione garantisce una netta separazione delle responsabilità tra interfaccia grafica, logica di business, modelli e persistenza dei dati, rendendo il progetto facilmente estendibile con funzionalità future quali live streaming, recensioni complete, sistema di follower e gestione avanzata delle pubblicità.

8. Progettazione della Base di Dati

La base di dati di RiftView è stata progettata utilizzando PostgreSQL con l'obiettivo di memorizzare in modo strutturato tutte le informazioni necessarie al funzionamento della piattaforma. La progettazione è iniziata con la realizzazione di un diagramma Entity-Relationship (E-R), successivamente tradotto in uno schema relazionale composto da tabelle, chiavi primarie, chiavi esterne e vincoli di integrità.

Le principali entità presenti nel database sono:

Account, che rappresenta gli utenti registrati della piattaforma e contiene informazioni come ID, nome, email, password, numero di iscritti, numero di video e numero di streaming.
Video, che memorizza tutti i contenuti caricati dagli utenti, comprendendo titolo, descrizione, categoria, durata, numero di like e numero di visualizzazioni.
Pubblicità, specializzazione della tabella Video, utilizzata per rappresentare i contenuti sponsorizzati mediante attributi aggiuntivi come sponsor, link esterno e possibilità di saltare la pubblicità.
Live Streaming, dedicata alle dirette create dagli utenti e contenente informazioni quali titolo, data di inizio, data di fine e categoria.
Chat Live, che rappresenta la chat associata ad una diretta streaming e consente agli utenti di comunicare durante la trasmissione.
Recensione, utilizzata per memorizzare i commenti e le valutazioni lasciate dagli utenti sui video.

Tra queste entità sono state definite diverse relazioni fondamentali per il corretto funzionamento del sistema:

un Account può pubblicare più Video;
un Account può creare più Live Streaming;
un Video può ricevere numerose Recensioni;
ogni Recensione appartiene ad un solo Video e ad un solo Account;
una Live Streaming possiede una Chat Live dedicata;
gli utenti possono partecipare alle chat e visualizzare sia video sia dirette streaming.

Per garantire la coerenza delle informazioni sono stati definiti diversi vincoli di integrità. In particolare:

l'email di ogni account deve essere univoca;
ogni tabella possiede una chiave primaria che identifica univocamente ogni record;
le relazioni tra le tabelle sono realizzate mediante chiavi esterne;
i dati relativi ai video e alle dirette devono rispettare i vincoli previsti dal modello concettuale.

L'interazione tra l'applicazione Java e il database viene gestita attraverso il pattern DAO (Data Access Object). Le operazioni di inserimento, aggiornamento e lettura dei dati vengono eseguite dalle classi AccountDAOImpl e VideoDAOImpl, mentre la connessione al database PostgreSQL è centralizzata nella classe ConnessioneDatabase, sviluppata mediante il pattern Singleton. In questo modo viene garantita una chiara separazione tra logica applicativa e gestione della persistenza dei dati.

Per ulteriore informazione leggi pdf in /documentazione/documentazionefinale

