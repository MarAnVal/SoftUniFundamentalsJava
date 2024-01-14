import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Long> pokemons = Arrays.stream(input.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        long sum = 0;
        long element = 0;

        while (!pokemons.isEmpty()) {
            int pokemonIndex = Integer.parseInt(input.nextLine());
            if (pokemonIndex < 0) {
                //If the given index is LESS than 0, remove the first element of the sequence,
                // and COPY the last element to its place.
                pokemonIndex = 0;
                element = pokemons.get(pokemonIndex);
                sum += element;
                long elementToAdd = pokemons.get(pokemons.size() - 1);
                pokemons.set(pokemonIndex, elementToAdd);
            } else if (pokemonIndex > pokemons.size() - 1) {
                //If the given index is GREATER than the last index of the sequence,
                // remove the last element from the sequence, and COPY the first element to its place.
                pokemonIndex = pokemons.size() - 1;
                element = pokemons.get(pokemonIndex);
                sum += element;
                long elementToAdd = pokemons.get(0);
                pokemons.set(pokemonIndex, elementToAdd);
            } else {
                element = pokemons.get(pokemonIndex);
                sum += element;
                pokemons.remove(pokemonIndex);

            }
            for (int i = 0; i < pokemons.size(); i++) {
                long currentElement = pokemons.get(i);
                if (currentElement <= element) {
                    //You must INCREASE the value of all elements in the sequence which are LESS or EQUAL
                    // to the removed element with the value of the removed element.
                    pokemons.set(i, currentElement + element);
                } else {
                    //You must DECREASE the value of all elements in the sequence which are GREATER
                    //than the removed element with the value of the removed element.
                    pokemons.set(i, currentElement - element);

                }

            }
        }

        System.out.println(sum);
    }
}
