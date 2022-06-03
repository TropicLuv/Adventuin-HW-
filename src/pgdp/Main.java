package pgdp;

import pgdp.adventuin.Adventuin;
import pgdp.adventuin.AdventuinParty;
import pgdp.adventuin.HatType;
import pgdp.adventuin.Language;
import pgdp.color.RgbColor;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        Adventuin test = new Adventuin("Player1", 133, new RgbColor(2,2,1,1), HatType.SANTA_CLAUS,Language.ENGLISH);
//        System.out.println(test.getLanguage().getLocalizedChristmasGreeting("vfe"));

        Adventuin a1 = new Adventuin ("penguin1", 100, new RgbColor (3, 2, 1, 2), HatType.FISHY_HAT, Language.ENGLISH);

        Adventuin a2 = new Adventuin ("penguiiin222", 100, new RgbColor (3, 6, 1, 0), HatType.SANTA_CLAUS, Language.ENGLISH);

        Adventuin a3 = new Adventuin ("penguin3", 100, new RgbColor (4, 2, 1, 0), HatType.SANTA_CLAUS, Language.ENGLISH);

        Adventuin a4 = new Adventuin ("lol", 100, new RgbColor (1, 1, 1, 0), HatType.NO_HAT, Language.ENGLISH);

        Adventuin a5 = new Adventuin ("Penguin_11", 100, new RgbColor (3, 4, 1, 0), HatType.NO_HAT, Language.ENGLISH);


        List<Adventuin> adventuinList = new LinkedList<>();
        adventuinList.add(a1);
        adventuinList.add(a2);
        adventuinList.add(a3);
        adventuinList.add(a4);
        adventuinList.add(a5);

        AdventuinParty aaa = new AdventuinParty();

        Map<HatType,List<Adventuin>> testMap = aaa.groupByHatType(adventuinList);
//        aaa.printLocalizedChristmasGreetings(adventuinList);
//
//        System.out.println(adventuinList.stream().filter(adventuin -> adventuin.getHatType().equals(HatType.SANTA_CLAUS))
//                .sorted(Comparator.comparing(x -> x.getName().length())).collect(Collectors.groupingBy(Adventuin :: getHatType)));

//        System.out.println(adventuinList.stream().map(x -> x.getHatType()).collect(Collectors.toList()));

//        System.out.println(adventuinList.stream().map(Adventuin::getHatType).distinct().collect(Collectors.toList()));
//        Map<HatType, List<Double>> test = aaa.getDiffOfAvgHeightDiffsToPredecessorByHatType(adventuinList);
//        System.out.println(test.toString());

        System.out.println((aaa.getDiffOfAvgHeightDiffsToPredecessorByHatType(adventuinList)).toString());
    }
}
