public class Player implements java.io.Serializable {
    private int currentSquareValue;
    private CardColor currentSquareColor;
    private Token token;
    private int previousSquareValue;
    private int boomerangs = 0;
    private boolean aiPlayer;
    private boolean dad;

    public Player(int pNum, String pName, boolean aiPlayer) {
        if (WorldOfSweets.getGameMode()) {
            this.boomerangs = 3;
        }
        this.currentSquareValue = -1;
        this.currentSquareColor = CardColor.ORANGE;
        this.aiPlayer = aiPlayer;
        this.token = new Token(pNum, pName);
        if (pName.equalsIgnoreCase("dad"))
            dad = true;
        else
            dad = false;
    }

    public Player(int pNum, String pName, int currentSquareValue, CardColor currentSquareColor, int x, int y, int previousSquareValue, boolean aiPlayer) {
        if (WorldOfSweets.getGameMode()) {
            this.boomerangs = 3;
        }
        this.currentSquareValue = currentSquareValue;
        this.currentSquareColor = currentSquareColor;
        this.aiPlayer = aiPlayer;
        token = new Token(pNum, pName, x, y);
        if (pName.equalsIgnoreCase("dad"))
            dad = true;
        else
            dad = false;
    }

    public Player(int pNum, String pName, int currentSquareValue, CardColor currentSquareColor, int x, int y, int previousSquareValue, int boomerangs, boolean aiPlayer) {
        this.currentSquareValue = currentSquareValue;
        this.currentSquareColor = currentSquareColor;
        this.boomerangs = boomerangs;
        this.aiPlayer = aiPlayer;
        token = new Token(pNum, pName, x, y);
        if (pName.equalsIgnoreCase("dad"))
            dad = true;
        else
            dad = false;
    }

    public int getBoomerangs() {
        return this.boomerangs;
    }

    public int decrementBoomerangCount() {
        if (this.boomerangs > 0)
            this.boomerangs--;
        return this.boomerangs;
    }

    /**
     * @return if this player is dad
     */
    public boolean isDad() {
        return dad;
    }

    public boolean isAiPlayer() {
        return this.aiPlayer;
    }

    /**
     * This method makes a move for the AI Player
     * They will use a boomerang under these conditions:
     * - They have a boomerang left
     * - The current leader is at square 70 or beyond
     * - The current leader is not them
     */
    public void makeMove() {
        if (this.boomerangs == 0) {
            WorldOfSweets.gameboard.cardDeck.board.getMouseListeners()[0].mouseClicked(null);
        } else {
            Player[] players = WorldOfSweets.players;
            int currentLeaderSquareValue = 0;
            String currentLeaderName = "";
            for (int i = 0; i < players.length; i++) {
                if (players[i].getCurrentSquareValue() > currentLeaderSquareValue) {
                    currentLeaderSquareValue = players[i].getCurrentSquareValue();
                    currentLeaderName = players[i].getToken().getName();
                }
            }
            if (this.currentSquareValue < currentLeaderSquareValue && currentLeaderSquareValue >= 70) {
                WorldOfSweets.gameboard.useBoomerang(currentLeaderName, true);
            } else {
                WorldOfSweets.gameboard.cardDeck.board.getMouseListeners()[0].mouseClicked(null);
            }
        }
    }

    /**
     * @return This players token
     */
    public Token getToken() {
        return this.token;
    }

    /**
     * @return This players current square value
     */
    public int getCurrentSquareValue() {
        return this.currentSquareValue;
    }

    /**
     * @return This players current square color
     */
    public CardColor getCurrentSquareColor() {
        return this.currentSquareColor;
    }

    /**
     * Handles moving the token of this player
     *
     * @param newValue Value of new board space
     * @param newColor Color of new board space
     */
    public void moveToken(int newValue, CardColor newColor) {
        this.currentSquareValue = newValue;
        this.currentSquareColor = newColor;
    }


    public void checkJump() {
        int pVal = this.previousSquareValue;
        int cVal = this.currentSquareValue;
        if (WorldOfSweets.gameboard.usingBoomerang) {
            if (cVal <= 13 && pVal >= 13) {
                this.currentSquareValue--;
                return;
            }
            if (cVal <= 29 && pVal >= 29) {
                this.currentSquareValue--;
                return;
            }
            if (cVal <= 45 && pVal >= 45) {
                this.currentSquareValue--;
                return;
            }
            if (cVal <= 61 && pVal >= 61) {
                this.currentSquareValue--;
                return;
            }
            if (cVal <= 77 && pVal >= 77) {
                this.currentSquareValue--;
                return;
            }
        } else {
            if (pVal < 13 && cVal >= 13) {
                this.currentSquareValue++;
                return;
            }
            if (pVal < 29 && cVal >= 29) {
                this.currentSquareValue++;
                return;
            }
            if (pVal < 45 && cVal >= 45) {
                this.currentSquareValue++;
                return;
            }
            if (pVal < 61 && cVal >= 61) {
                this.currentSquareValue++;
                return;
            }
            if (pVal < 77 && cVal >= 77) {
                this.currentSquareValue++;
                return;
            }
        }
    }

    public int useBoomerang(int value, CardColor color) {
        //single card
        this.previousSquareValue = this.currentSquareValue;
        if (value == 1) {
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 4;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 3;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 2;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 1;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 1;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 4;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 3;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 2;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 2;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 1;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if (!(this.currentSquareValue == 13 || this.currentSquareValue == 29 || this.currentSquareValue == 45 || this.currentSquareValue == 77 || this.currentSquareValue == 61)) {
                                this.currentSquareValue -= 5;
                            }
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 4;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 3;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 3;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 2;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 1;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 4;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 4;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 3;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 2;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 1;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
            }
            checkJump();
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //double card
        else if (value == 2) {
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 5 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 4 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 3 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 2 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 1 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 1 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 5 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 4 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 3 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 2 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 2 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 1 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if ((this.currentSquareValue == 13 || this.currentSquareValue == 29 || this.currentSquareValue == 45 || this.currentSquareValue == 77 || this.currentSquareValue == 61)) {
                                this.currentSquareValue -= 5;
                            } else {
                                this.currentSquareValue -= 5 + 5;
                            }

                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 4 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 3 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 3 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 2 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 1 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 5 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 4 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue -= 4 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue -= 3 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue -= 2 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue -= 1 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue -= 5 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
            }
            checkJump();
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //special squares
        else if (value == Constants.LICORICE) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 29;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.PEPPERMINT) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 13;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.ICECREAM) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 45;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.GINGERBREAD) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 61;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.CUPCAKE) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 77;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //skip turn
        else {
            return this.currentSquareValue;
        }
    }

    /**
     * Handles moving the player to new location after card drawn
     *
     * @param value Value to move
     * @param color Color to move
     * @return new square value
     */
    public int newCardDrawn(int value, CardColor color) {
        //single card
        this.previousSquareValue = this.currentSquareValue;
        if (value == 1) {
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
            }
            checkJump();
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //double card
        else if (value == 2) {
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 5 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 1 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 2 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 3 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 4 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 4 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 5 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 1 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 2 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 3 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 3 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 4 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 5 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 1 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 2 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 2 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 3 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 4 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 5 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 1 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (color) {
                        case RED:
                            this.currentSquareValue += 1 + 5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 2 + 5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 3 + 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 4 + 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 5 + 5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
            }
            checkJump();
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //special squares
        else if (value == Constants.LICORICE) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 29;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.PEPPERMINT) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 13;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.ICECREAM) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 45;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.GINGERBREAD) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 61;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        } else if (value == Constants.CUPCAKE) {
            this.currentSquareColor = CardColor.BLUE;
            this.currentSquareValue = 77;
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining and " + this.boomerangs + " Boomerangs remaining!";
            } else {
                msg = this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares remaining!";
            }
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(msg);
            return this.currentSquareValue;
        }
        //skip turn
        else {
            return this.currentSquareValue;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(currentSquareValue + "#");
        sb.append(currentSquareColor + "#");
        sb.append(token.toString() + "#");
        if(currentSquareValue <= 0)
          sb.append(0 + "#");
        else
          sb.append(previousSquareValue + "#");
        sb.append(boomerangs + "#");
        sb.append(aiPlayer);

        return sb.toString();
    }
}
