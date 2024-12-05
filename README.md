Main.java
line 1-4 package imports

line 10 - 23 maakt nieuwe window die heet Sudoku Solver
             set de dimensies van de window
             maakt het grid van 9 x 9 waarin je nummers kan zetten

line 25 - 38 maakt een knop waarop staat Solve
             voegt een actionlistener toe die alle nummers die zijn ingevoegd ophaalt
             zorgt ervoor dat als het op te lossen is dat het de lege vakken invult met
             blauwe nummers die de oplossing zijn
             als het niet kan opgelost worden komt er een error die zegt Unsolvable
    zorgt er ook voor dat het grid en de knop op de plekken staan waar ze staan (rechts en midden)

 line 39 - 51 Extract numbers zorgt ervoor dat alle nummers die ingevuld zijn worden opgehaald

 line 53 - 69 Solve zorgt ervoor dat de sudoku wordt opgelost door een backtracking algorithm
              die alle mogelijkheden doorgaat maar alleen de juiste laat zien

 line 71 - 78 isSafe zorgt ervoor dat de sudoku kan worden opgelost door false terug te geven als
              hetzelfde nummer in de rij of vak van het nummer zit

 line 80 - 89 zorgt ervoor dat je alleen maar cijfers van 1 t/m 9 kan typen 
             
