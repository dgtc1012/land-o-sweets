US-32 Manual GUI Tests

1. Upon starting the game, the number of players and their names are asked. Enter any
variation you want. 

    Pass: If the names you entered appear on the right hand side, with the proper token 
    next to it, the test passes.
    Fail: If the token picture doesn't match up with the name, or the names aren't displayed.

2. Start the game up once again. Enter any variation of number of players and the
player names. Start drawing cards. The "number of squares to grandma's house"
value should change for the correct player based on the card value drawn. 

    Pass: Draw a card. Count how many squares remain until reaching grandma's house.
    If that total equals the total squares displayed, the test passes.
    Fail: If the total counted squares and the value displayed don't match. 