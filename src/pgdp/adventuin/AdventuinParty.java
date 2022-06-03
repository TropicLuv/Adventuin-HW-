package pgdp.adventuin;
import java.util.*;
import java.util.stream.Collectors;

public final class AdventuinParty {

    private static int roundedHeight(int num){
        if (num % 10 >= 5) return ((num + 10) / 10) * 10;
        else return num /10 * 10;
    }

    private static Double lastFunctionDiffCalculator(List<Adventuin> adventuinList) {
        if (adventuinList.size() == 1)
            return 0.0;
        List<Integer> intList = new LinkedList<>();
        adventuinList.forEach(x -> intList.add(x.getHeight()));
        List<Integer> DoubleArr = new LinkedList<>();
        for (int i = 0; i < intList.size(); i++)
            if (i == 0)
                DoubleArr.add(intList.get(intList.size() - 1) - intList.get(i));
            else
                DoubleArr.add (intList.get(i - 1) - intList.get(i));

            Double minusDiff;
            Double plusDiff;
            try {
                minusDiff = DoubleArr.stream().mapToInt(Integer::intValue).filter(x -> x < 0).average().getAsDouble();
            }catch (NoSuchElementException f){
                minusDiff = 0.0;}
            try {
                plusDiff = DoubleArr.stream().mapToInt(Integer::intValue).filter(x -> x > 0).average().getAsDouble();
            }catch (NoSuchElementException f){
                plusDiff = 0.0;}


        return - minusDiff + plusDiff;
    }



    public static Map<HatType, List<Adventuin>> groupByHatType(List<Adventuin> list){

        return list.stream().collect(Collectors.groupingBy(Adventuin :: getHatType));
    }
    public static void printLocalizedChristmasGreetings(List<Adventuin> list){
        if(list.isEmpty()) return;
        list.stream().sorted(Comparator.comparingInt(Adventuin::getHeight)).forEach(print -> System.out.println(print.getLanguage().getLocalizedChristmasGreeting(print.getName())));

    }
    public static Map<HatType, List <Adventuin>> getAdventuinsWithLongestNamesByHatType(List<Adventuin> list){
        Map<HatType, List<Adventuin>> returnMap = groupByHatType(list);

        if (list.isEmpty()) return returnMap;
        for(HatType aaa : list.stream().map(Adventuin::getHatType).distinct().collect(Collectors.toList())) {
            int largestName =0;
            for (Adventuin tempAdventuin : returnMap.get(aaa))
                if (tempAdventuin.getName().length() >= largestName) largestName = tempAdventuin.getName().length();
            List<Adventuin> tempListOfAdventuinToFinalList = new LinkedList<>();
            for(Adventuin secondTempAdventuin : returnMap.get(aaa))
                if(secondTempAdventuin.getName().length() == largestName)
                    tempListOfAdventuinToFinalList.add(secondTempAdventuin);

            returnMap.put(aaa,tempListOfAdventuinToFinalList);
        }
        return returnMap;
    }
    public static Map<Integer, Double> getAverageColorBrightnessByHeight(List<Adventuin> list){
        Map<Integer, List<Double>> returnMap = new HashMap<>(); Map<Integer, Double> returnMapDouble = new HashMap<>();

        list.forEach(x -> returnMap.put(roundedHeight(x.getHeight()),new LinkedList<>()));

        list.forEach(x -> returnMap.get(roundedHeight(x.getHeight())).add((x.getColor().toRgbColor8Bit().
                getBlue() * 0.0722 + x.getColor().toRgbColor8Bit().getGreen() * 0.7152 + x.getColor().toRgbColor8Bit().getRed() * 0.2126) / 255));

        returnMap.entrySet().forEach(adven -> returnMapDouble.put(adven.getKey(), returnMap.get(adven.getKey()).stream().mapToDouble(Double::doubleValue).average().getAsDouble()));





        return returnMapDouble;
    }

    public static Map<HatType, Double> getDiffOfAvgHeightDiffsToPredecessorByHatType(List<Adventuin> list){

        Map<HatType, List<Adventuin>> mapByHat = groupByHatType(list);
        Map<HatType, Double> double$List$By$Hat$Height = new HashMap<>();
        mapByHat.forEach((key, value) -> double$List$By$Hat$Height.put(key,lastFunctionDiffCalculator(mapByHat.get(key))));

       return double$List$By$Hat$Height;
    }
}
