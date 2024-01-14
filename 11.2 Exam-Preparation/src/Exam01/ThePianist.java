package Exam01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        LinkedHashMap<String, String> pieceKeyMap = new LinkedHashMap<>();
        LinkedHashMap<String, String> pieceComposerMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String havePieces = input.nextLine();
            //"{piece}|{composer}|{key}".
            String piece = havePieces.split("\\|")[0];
            String composer = havePieces.split("\\|")[1];
            String pieceKey = havePieces.split("\\|")[2];
            pieceKeyMap.put(piece, pieceKey);
            pieceComposerMap.put(piece, composer);
        }
        String line = input.nextLine();
        while (!line.equals("Stop")) {
            String command = line.split("\\|")[0];
            switch (command) {
                //"Add|{piece}|{composer}|{key}"
                case "Add":
                    String pieceAdd = line.split("\\|")[1];
                    //You need to add the given piece with the information about it to the other pieces and print:
                    //"{piece} by {composer} in {key} added to the collection!"
                    if (pieceKeyMap.containsKey(pieceAdd)) {
                        //If the piece is already in the collection, print:
                        //"{piece} is already in the collection!"
                        System.out.printf("%s is already in the collection!%n", pieceAdd);
                    } else {
                        //You need to add the given piece with the information about it to the other pieces and print:
                        //"{piece} by {composer} in {key} added to the collection!"
                        String composerAdd = line.split("\\|")[2];
                        String pieceKeyAdd = line.split("\\|")[3];
                        pieceKeyMap.put(pieceAdd, pieceKeyAdd);
                        pieceComposerMap.put(pieceAdd, composerAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n",
                                pieceAdd, composerAdd, pieceKeyAdd);
                    }
                    break;
                //"Remove|{piece}"
                case "Remove":
                    String pieceRemove = line.split("\\|")[1];
                    if (pieceKeyMap.containsKey(pieceRemove)) {
                        //If the piece is in the collection, remove it and print:
                        //"Successfully removed {piece}!"
                        pieceKeyMap.remove(pieceRemove);
                        pieceComposerMap.remove(pieceRemove);
                        System.out.printf("Successfully removed %s!%n", pieceRemove);
                    } else {
                        //Otherwise, print:
                        //"Invalid operation! {piece} does not exist in the collection."
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceRemove);
                    }
                    break;
                //"ChangeKey|{piece}|{new key}"
                case "ChangeKey":
                    String pieceChange = line.split("\\|")[1];
                    if (pieceKeyMap.containsKey(pieceChange)) {
                        //If the piece is in the collection, change its key with the given one and print:
                        //"Changed the key of {piece} to {new key}!"
                        String newPieceKey = line.split("\\|")[2];
                        pieceKeyMap.put(pieceChange, newPieceKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceChange, newPieceKey);
                    } else {
                        //Otherwise, print:
                        //"Invalid operation! {piece} does not exist in the collection."
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceChange);
                    }
                    break;
            }
            line = input.nextLine();
        }
        for (Map.Entry<String, String> entry : pieceKeyMap.entrySet()) {
            //"{Piece} -> Composer: {composer}, Key: {key}"
            String piece = entry.getKey();
            String composer = pieceComposerMap.get(piece);
            String pieceKey = entry.getValue();
            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, pieceKey);
        }

    }
}
