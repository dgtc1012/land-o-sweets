import java.awt.*;
public class Player {
    private int currentSquareValue;
    private CardColor currentSquareColor;
    private Token token;
    private boolean middle;

    public Player(int pNum, String pName){
        this.currentSquareValue = -1;
        this.currentSquareColor = CardColor.ORANGE;
        this.token = new Token(pNum, pName);
        middle = false;
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

    public Color getCurrentSquareColor2(){
        if (this.currentSquareColor == CardColor.ORANGE)
            return Color.orange;
        else if (this.currentSquareColor == CardColor.RED)
            return Color.red;
        else if (this.currentSquareColor == CardColor.BLUE)
            return Color.blue;
        else if (this.currentSquareColor == CardColor.GREEN)
            return Color.green;
        else 
            return Color.yellow;
    }

    public void moveToken(int newValue, CardColor newColor){
        this.currentSquareValue = newValue;
        this.currentSquareColor = newColor;
    }


    public int newCardDrawn(int value, CardColor color){
        //single card
        if(value == 1) {
            /*if (this.currentSquareValue>=39 && this.currentSquareValue<44)
                this.currentSquareValue++;*/
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==40)
                                this.currentSquareValue++;
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
                            if (this.currentSquareValue==40)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==41)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==41)
                                this.currentSquareValue++;
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
                            if (this.currentSquareValue==41)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==42)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==42)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if (this.currentSquareValue==42)
                                this.currentSquareValue++;
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 1;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            if (this.currentSquareValue==42)
                                this.currentSquareValue++;
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==43)
                                this.currentSquareValue++;
                            this.currentSquareValue += 2;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==43)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if (this.currentSquareValue==43)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            if (this.currentSquareValue==43)
                                this.currentSquareValue++;
                            this.currentSquareValue += 5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            if (this.currentSquareValue==43)
                                this.currentSquareValue++;
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
                            if (this.currentSquareValue==39)
                                this.currentSquareValue++;
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
            switch (currentSquareColor) {
                case RED:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==35)
                                this.currentSquareValue++;
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
                            if (this.currentSquareValue==35)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case YELLOW:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==36)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==36)
                                this.currentSquareValue++;
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
                            if (this.currentSquareValue==36)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case BLUE:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==37)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==37)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if (this.currentSquareValue==37)
                                this.currentSquareValue++;
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            if (this.currentSquareValue==37)
                                this.currentSquareValue++;
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case GREEN:
                    switch (color) {
                        case RED:
                            if (this.currentSquareValue==38)
                                this.currentSquareValue++;
                            this.currentSquareValue += 2+5;
                            this.currentSquareColor = CardColor.RED;
                            break;
                        case YELLOW:
                            if (this.currentSquareValue==38)
                                this.currentSquareValue++;
                            this.currentSquareValue += 3+5;
                            this.currentSquareColor = CardColor.YELLOW;
                            break;
                        case BLUE:
                            if (this.currentSquareValue==38)
                                this.currentSquareValue++;
                            this.currentSquareValue += 4+5;
                            this.currentSquareColor = CardColor.BLUE;
                            break;
                        case GREEN:
                            if (this.currentSquareValue==38)
                                this.currentSquareValue++;
                            this.currentSquareValue += 5+5;
                            this.currentSquareColor = CardColor.GREEN;
                            break;
                        case ORANGE:
                            if (this.currentSquareValue==38)
                                this.currentSquareValue++;
                            this.currentSquareValue += 1+5;
                            this.currentSquareColor = CardColor.ORANGE;
                            break;
                    }
                    break;
                case ORANGE:
                    switch (color) {
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
                            if (this.currentSquareValue==34)
                                this.currentSquareValue++;
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
            this.currentSquareValue = (WorldOfSweets.getBoardLength()-1)/2+1;
            middle = true;
            return this.currentSquareValue;       //increment fixs off by one movement bug
        }

        //skip turn
        else{
            return this.currentSquareValue;
        }
    }
}
