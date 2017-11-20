US-34 Manual GUI Tests

1. After pressing the save game button a prompt should appear and the timer should stop.
Steps: Start a new game.  Play a few turns without letting any player win the game.  Press the save and quit button.

    Pass: If your are prompted to save the game and the timer freezes.
    Fail: If the prompt does not appear or the timer does not freeze.

2. After entering in a valid filename for the new save the game file should be found in the resources/game files folder
Steps: Complete test one.  Enter in the name of a new file without the extension for
your game. The prompt game saved should appear and the game should close Go to the
resources/gameFIles folder.  Verify that your nearly created file is there.

    Pass: If the nearly created file is in the proper folder.
    Fail: If the file is not found or the user cancels the save operation.
