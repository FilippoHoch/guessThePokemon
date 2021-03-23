# Guess the Pokémon – Sub project

## Il progetto

Il progetto si compone principalmente da due sotto progetti, il
primo [pokedexRandomizer](https://github.com/FilippoHoch/pokedexRandomizer)  e il
secondo [guessThePokemon](https://github.com/FilippoHoch/guessThePokemon). La prima parte del progetto è stata svolta
senza l’aiuto di Borghesi a causa del fatto che i gruppi la prima volta erano diversi da quelli attuali. Abbiamo
comunque spiegato al compagno il progetto e ci siamo consultati per migliorarlo. Il secondo progetto invece è stato
concepito solo successivamente alla creazione dei nuovi gruppi pertanto, è molto più arretrato rispetto allo sviluppo
del primo.

## Guess the Pokémon

Questo progetto è un minigioco che utilizzando le proprietà dei vari Pokémon ne svela alcune all’utente, il quale deve
tentare d'indovinare di quale Pokémon il computer stia rivelando le informazioni una ad una.

Le informazioni che verranno rivelate, in quest’ordine: la generazione in cui è stato introdotto, l’altezza e il peso
del Pokémon, il primo tipo, la fase evolutiva, il secondo tipo, la rarità del Pokémon, un’abilità che il Pokémon può
avere e come suggerimento finale l’artwork.

Può essere inserito un nome utente in modo da poter gareggiare con altri utenti salvando i vari punteggi che verranno
conseguiti e verranno assegnati più punti in base a quante informazioni non vengono utilizzate (meno informazioni usi,
più punti ottieni).

## Installation

For installation it is necessary to add / change the library of the project, by entering that of "JavaFX". In addition,
you must enter the Virtual machine (VM Options), within the "mainApp" configurations, the code is as follows:

```bash
--module-path 

"path of your javaFX libraries" 

--add-modules 

javafx.controls,javafx.fxml 
```

Or follow this [video](https://youtu.be/FylHot91Lz8)

## Prima settimana

Durante la prima settimana, non ci siamo incentrati molto su questo codice preferendo di portare a termine la prima
parte di questo progetto, ovvero la randomizzazione dei vari Pokémon.

Nello specifico questa settimana abbiamo lavorato al progetto scrivendo in
un [database](https://docs.google.com/spreadsheets/d/1-Yw_hxKg4_Z6nziu_lHgmgpDhv4dFtOQmIZDYbOK21I/edit?usp=sharing)
tutte le informazioni dei vari pokémon che ci serviranno per svolgere il programma.

## Seconda settimana

Durante questa settimana abbiamo lavorato divisi un due gruppi: uno si occupava di iniziare a fare la grafica su
SceneBuilder, mentre l'altro ha iniziato a creare il codice funzionante senza l'aggiunta della grafica che verrà
implementata successivamente. Nel codice abbiamo effettuato la lettura
del [database] (https://docs.google.com/spreadsheets/d/1-Yw_hxKg4_Z6nziu_lHgmgpDhv4dFtOQmIZDYbOK21I/edit?usp=sharing)
contenente le informazioni relative a ciascun pokémon.

## Terza settimana

Nella terza settimana, siamo riusciti a completare gran parte del codice, implementando la grafica e aggiungendo alcuni
file di tipo Excel per rendere più funzionale e interattivo il programma. Alcuni piccoli errori ci hanno bloccato, ma
senza quasi nessun problema siamo riusciti a superarli. Attualmente il codice si trova in uno stato funzionante ma
ancora non ultimato, infatti mancano ancora alcuni punti della sezione work in progress.

## Quarta settimana

Nella quarta settimana, siamo riusciti a completare maggior parte del codice, migliorando e finendo la parte grafica, creando la parte dei leaderboards, salvando chiunque giochi tramite un sistema di punteggio. La parte principale è stata ultimata, ma ci sono ancora piccoli bug che ogni tanto si scoprono provando sempre più il programma. Nonostante alcuni problemi, siamo quasi al termine di tutto.  

## Work in Progress

### Codice:

- Punteggio
- Salvare gli user e i punteggi in un file

### Grafica:

- Implementazione tableView LeaderBoard

## Autori

- [Filippo Hoch](https://github.com/FilippoHoch)
- [Paolo Braga](https://github.com/PaoloBraga)
- [Gabriele Borghesi](https://github.com/Gabry-EXE)
- [Daniele Romano](https://github.com/ROMA030)


# Guess the Pokémon – Manuale

## L'obiettivo del gioco

L'obiettivo del gioco è semplice: indovinare un pokémon basandosi sulle informazioni che il programma fornisce all'utente.

## Preparazione della partita

All’avvio del programma sarà necessario selezionare l’opzione per creare una nuova partita. Durante questa fase il programma permette all’utente di filtrare i pokémon secondo tre criteri: la generazione, lo stadio evolutivo e la rarità.
Dopo aver impostato i filtri come si desidera, per poter escludere certi tipi di pokémon o sceglierne solo alcuni sarà richiesto di inserire un nome, o un nickname per chi preferisce, prima di poter finalmente avviare il gioco.

## Lo svolgimento della partita

A sfida iniziata il programma darà il primo indizio riguardo al pokémon che l’utente deve indovinare. Informazione generalmente insufficiente per indovinare un pokémon, forzando l’utente ad andare a caso. Dopo aver inserito un primo tentativo il programma darà altri indizi all’utente, permettendogli di figurare, passo dopo passo, quale sia il pokémon di cui il programma stava fornendo gli indizi.
Gli indizi che vengono dati sono la parte più importante del gioco. Ovviamente uno viene già dato all’inizio della partita e questo è la generazione di appartenenza al pokémon. In seguito, nell’ordine in cui vengono riportati qui, sono date queste informazioni: il primo tipo, la fase evolutiva, il secondo tipo, la rarità, la sagoma del pokémon e l’orma del piede, l’abilità e come ultimo indizio l’artwork.

## Il punteggio della competizione

Ovviamente chi indovina viene ricompensato con un luccicante punteggio compreso tra zero a cento. 
Il punteggio tiene conto di due fattori: 
- Il filtro dei pokémon selezionato: maggiore è la quantità di pokémon tra cui si deve indovinare, maggiore è il punteggio!
- Il numero di tentativi utilizzato: vengono premiati coloro che utilizzano meno indizi per indovinare!
E’ disponibile una tabella dei punteggi migliori da consultare a fine partita.

## Siti utilizzati per ottenere informazioni necessarie

Oltre al sito ufficiale, abbiamo utilizzato anche altri siti molto utili:
- [fontmeme.com](https://fontmeme.com/it/font-pokemon/): questo sito è stato utile per la creazione di varie scritte nello stile proprio dei vari giochi Pokémon;
- [veekun/pokedex](https://github.com/veekun/pokedex): questo sito è stato utilizzato per ottenere informazioni sull’id, il peso e le abilità dei pokémon;
- [veekun.com/dex/downloads](https://veekun.com/dex/downloads): consultato per poter utilizzare gli sprite che erano necessari per rappresentare le orme o le sprite dei pokémon.

