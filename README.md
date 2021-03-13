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
implementata successivamente. Nel codice abbiamo effettuato la lettura del [
database (https://docs.google.com/spreadsheets/d/1-Yw_hxKg4_Z6nziu_lHgmgpDhv4dFtOQmIZDYbOK21I/edit?usp=sharing)
contenente le informazioni relative a ciascun pokémon.

## Terza settimana

Nella terza settimana, siamo riusciti a completare gran parte del codice, implementando la grafica e aggiungendo alcuni file di tipo Excel per rendere più funzionale e interattivo il programma. Alcuni piccoli errori ci hanno bloccato, ma senza quasi nessun problema siamo riusciti a superarli. Attualmente il codice si trova in uno stato funzionante ma ancora non ultimato, infatti mancano ancora alcuni punti della sezione work in progress.

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
