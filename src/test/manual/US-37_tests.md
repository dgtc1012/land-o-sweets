US-37: AI Player

1. Start a new classic game, and click the AI? radio button next to a player's name. Once it's the AI player's turn, ensure that
a card was drawn for it, and its token moves to the correct location on the gameboard. 
    
        If the AI player moves to the correct location, the test passes. If not, the test fails.
        
2. Start a new classic game, and click the AI? radio button for all players. The game should then progress without you having to 
touch a button. 
    
        If the game doesn't finish, or a player moves to the wrong location, the test fails. If the game completes with 
        all players going to the correct squares, and a winner is correctly identified, the test passes.
        
3. Start a classic game with an AI player. Play some of the game, and then save it. Then, load that saved game, and continue
playing it. The same player that was an AI player before you saved it should be an AI player after you saved it. If not, 
the test fails.

4. Start a strategic game, and have at least one AI player. Play until the user controlled player is leading, and gets beyond
square 70. If the AI player uses a boomerang on the leader who is beyond square 70, the test passes. If they don't, or 
anything else unexpected happens, the test fails.