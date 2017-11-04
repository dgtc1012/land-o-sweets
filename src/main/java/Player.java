public class Player {
    private int currentSquareValue;
    private CardColor currentSquareColor;
    private Token token;

    public Player(int pNum, String pName){
        this.currentSquareValue = -1;
        this.currentSquareColor = CardColor.ORANGE;
        this.token = new Token(pNum, pName);
    }

    public Token getToken(){
        return this.token;
    }

    public int getCurrentSquareValue(){
        return this.currentSquareValue;
    }
    public CardColor getCurrentSquareColor(){
        return this.currentSquareColor;
    }

    public void moveToken(int newValue, CardColor newColor){
        this.currentSquareValue = newValue;
        this.currentSquareColor = newColor;
    }

    public int newCardDrawn(int value, CardColor color){
        //single card
        if(value == 1) {
            switch (color) {
                case RED:
                    switch (currentSquareColor) {
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
                    switch (currentSquareColor) {
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
                    switch (currentSquareColor) {
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
                    switch (currentSquareColor) {
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
                    switch (currentSquareColor) {
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
            return this.currentSquareValue;
        }
        //double card
        else if(value == 2){
            switch (color) {
                case RED:
                    switch (currentSquareColor) {
                        case RED:
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (currentSquareColor) {
                        case RED:
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (currentSquareColor) {
                        case RED:
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (currentSquareColor) {
                        case RED:
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (currentSquareColor) {
                        case RED:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
            }
            return this.currentSquareValue;
        }
        //middle card
        else if(value == 45){
            this.currentSquareColor = CardColor.GREEN;
            this.currentSquareValue = (WorldOfSweets.getBoardLength()-1)/2;
            return this.currentSquareValue;
        }
        //skip turn
        else{
            return this.currentSquareValue;
        }
    }
}
