import org.junit.Test;
import java.io.*;
import java.security.MessageDigest;

import static org.junit.Assert.assertEquals;

public class IntegrityTest {

  @Test
  public void untounchedFile() throws Exception {

    boolean unTampered = false;
    try {

            String filename = "src/test/testFiles/passingFile.txt";
            File file = new File(filename);
            StringBuilder forMD = new StringBuilder("");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String gameBol = br.readLine();
            forMD.append(gameBol);

            int numOfPlayers = Integer.parseInt(br.readLine());
            forMD.append(numOfPlayers);
            String playerStr;
            String[] pNames = new String[numOfPlayers];

            //Restores players
            for (int x = 0; x < numOfPlayers; x++) {

                pNames[x] = br.readLine();
                forMD.append(pNames[x]);
                playerStr = br.readLine();
                forMD.append(playerStr);
            }

            int currentPlayerIndex = Integer.parseInt(br.readLine());
            forMD.append(currentPlayerIndex);

            int deckSize = Integer.parseInt(br.readLine());
            forMD.append(deckSize + "\n");
            String cardStr;

            for (int x = 0; x < deckSize; x++) {
                cardStr = br.readLine();
                forMD.append(cardStr + "\n");
            }

            String lastCardStr = br.readLine();
            forMD.append(lastCardStr);
            String timeStr = br.readLine();
            forMD.append(timeStr);
            unTampered= verifyMD(forMD.toString(), br.readLine());
      }
      catch(Exception e) {}

      assertEquals(true, unTampered);
  }

  @Test
  public void deletedData() throws Exception {

    boolean unTampered = true;
    try {

            String filename = "src/test/testFiles/deletedDataFile.txt";
            File file = new File(filename);
            StringBuilder forMD = new StringBuilder("");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String gameBol = br.readLine();
            forMD.append(gameBol);

            int numOfPlayers = Integer.parseInt(br.readLine());
            forMD.append(numOfPlayers);
            String playerStr;
            String[] pNames = new String[numOfPlayers];

            //Restores players
            for (int x = 0; x < numOfPlayers; x++) {

                pNames[x] = br.readLine();
                forMD.append(pNames[x]);
                playerStr = br.readLine();
                forMD.append(playerStr);
            }

            int currentPlayerIndex = Integer.parseInt(br.readLine());
            forMD.append(currentPlayerIndex);

            int deckSize = Integer.parseInt(br.readLine());
            forMD.append(deckSize + "\n");
            String cardStr;

            for (int x = 0; x < deckSize; x++) {
                cardStr = br.readLine();
                forMD.append(cardStr + "\n");
            }

            String lastCardStr = br.readLine();
            forMD.append(lastCardStr);
            String timeStr = br.readLine();
            forMD.append(timeStr);
            unTampered= verifyMD(forMD.toString(), br.readLine());
      }
      catch(Exception e) {
        unTampered = false;
      }

      assertEquals(false, unTampered);
  }

  @Test
  public void modifiedData() throws Exception {

    boolean unTampered = true;
    try {

            String filename = "src/test/testFiles/modifiedDataFile.txt";
            File file = new File(filename);
            StringBuilder forMD = new StringBuilder("");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String gameBol = br.readLine();
            forMD.append(gameBol);

            int numOfPlayers = Integer.parseInt(br.readLine());
            forMD.append(numOfPlayers);
            String playerStr;
            String[] pNames = new String[numOfPlayers];

            //Restores players
            for (int x = 0; x < numOfPlayers; x++) {

                pNames[x] = br.readLine();
                forMD.append(pNames[x]);
                playerStr = br.readLine();
                forMD.append(playerStr);
            }

            int currentPlayerIndex = Integer.parseInt(br.readLine());
            forMD.append(currentPlayerIndex);

            int deckSize = Integer.parseInt(br.readLine());
            forMD.append(deckSize + "\n");
            String cardStr;

            for (int x = 0; x < deckSize; x++) {
                cardStr = br.readLine();
                forMD.append(cardStr + "\n");
            }

            String lastCardStr = br.readLine();
            forMD.append(lastCardStr);
            String timeStr = br.readLine();
            forMD.append(timeStr);
            unTampered= verifyMD(forMD.toString(), br.readLine());
      }
      catch(Exception e) {
        unTampered = false;
      }

      assertEquals(false, unTampered);
  }

  @Test
  public void addedData() throws Exception {

    boolean unTampered = true;
    try {

            String filename = "src/test/testFiles/addedDataFile.txt";
            File file = new File(filename);
            StringBuilder forMD = new StringBuilder("");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String gameBol = br.readLine();
            forMD.append(gameBol);

            int numOfPlayers = Integer.parseInt(br.readLine());
            forMD.append(numOfPlayers);
            String playerStr;
            String[] pNames = new String[numOfPlayers];

            //Restores players
            for (int x = 0; x < numOfPlayers; x++) {

                pNames[x] = br.readLine();
                forMD.append(pNames[x]);
                playerStr = br.readLine();
                forMD.append(playerStr);
            }

            int currentPlayerIndex = Integer.parseInt(br.readLine());
            forMD.append(currentPlayerIndex);

            int deckSize = Integer.parseInt(br.readLine());
            forMD.append(deckSize + "\n");
            String cardStr;

            for (int x = 0; x < deckSize; x++) {
                cardStr = br.readLine();
                forMD.append(cardStr + "\n");
            }

            String lastCardStr = br.readLine();
            forMD.append(lastCardStr);
            String timeStr = br.readLine();
            forMD.append(timeStr);
            unTampered= verifyMD(forMD.toString(), br.readLine());
      }
      catch(Exception e) {
        unTampered = false;
      }

      assertEquals(false, unTampered);
  }

  public boolean verifyMD(String forMD, String savedMD) {

    byte[] digestBytes = null;

    try {
      MessageDigest md = MessageDigest.getInstance("SHA");
      md.update(forMD.getBytes());
      digestBytes = md.digest();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    StringBuffer sb = new StringBuffer("");
    for (int i = 0; i < digestBytes.length; i++) {
      sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
    }

    String createdMD = sb.toString();
    if(createdMD.equals(savedMD))
      return true;
    else
      return false;
  }
}
