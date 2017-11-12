public class Player {
    private int currentSquareValue;
    private CardColor currentSquareColor;
    private Token token;
    private boolean middle;

    public Player(int pNum, String pName) {
        this.currentSquareValue = -1;
        this.currentSquareColor = CardColor.ORANGE;
        this.token = new Token(pNum, pName);
        middle = false;
    }

    public Token getToken() {
        return this.token;
    }

    public int getCurrentSquareValue() {
        return this.currentSquareValue;
    }

    public CardColor getCurrentSquareColor() {
        return this.currentSquareColor;
    }


    public void moveToken(int newValue, CardColor newColor) {
        this.currentSquareValue = newValue;
        this.currentSquareColor = newColor;
    }


    public int newCardDrawn(int value, CardColor color) {
        //single card
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
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares Remaining!");
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
            WorldOfSweets.gameboard.labels.get(this.token.getName()).setText(this.token.getName() + "- " + (WorldOfSweets.gameboard.numberOfSquares - this.currentSquareValue) + " Squares Remaining!");
            return this.currentSquareValue;
        }

        //skip turn
        else {
            return this.currentSquareValue;
        }
    }
}
