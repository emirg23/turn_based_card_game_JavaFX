# turn_based_card_game_JavaFX

JavaFX version of turn_based_card_game

there are 2 players, and mana is the currency of the game. the amount of mana equals the tour number the players are on. they can spend them with drawing cards which come in 5 rarities: bad, bad-mid, mid, mid-good, good. each cost has 5 cards hat are randomly pulled. so, there are 25 cards in total. I could add 25 more cards and make cost limit 10, but I don't want to be fully focused on JavaFX so early, so I will stick with this.

after making the turn_based_card_game, creating the JavaFX version with buttons, visuals exc. took me 6 days and I enjoyed it!

if you want to try it out, you have to go to main classes' run configurations and set the VM arguments module path to javaFX library, and
leave the "Use the -XStartOnFirstThread argument when launching with SWT" box unmarked


game rules

- a player can be attacked only if there is no creature to defend

- mana does not carry over to the next tour

- player 1 starts the game first, then players take turns in order

- creatures' special abilities get applied at the end of each tour
  

<img width="1440" alt="screenshot1" src="https://github.com/user-attachments/assets/2fee8b4c-32b3-4ff1-9391-337b89bb868a">

<img width="1440" alt="screenshot3" src="https://github.com/user-attachments/assets/8a646647-2e5b-4bc6-a84f-ee46d4d81f65">

<img width="1440" alt="screenshot4" src="https://github.com/user-attachments/assets/42266236-c536-4907-a811-fe4095f16976">

