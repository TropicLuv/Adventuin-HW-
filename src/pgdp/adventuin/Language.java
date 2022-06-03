package pgdp.adventuin;

public enum Language {
    GERMAN {
        @Override
        public String getLocalizedChristmasGreeting(String greeterName){
            return "Fröhliche Weihnachten wünscht dir " + greeterName + "!";
        }
    },
    ENGLISH{
        @Override
        public String getLocalizedChristmasGreeting(String greeterName){
            return greeterName + " wishes you a Merry Christmas!";
        }
    };
    public String getLocalizedChristmasGreeting(String greeterName){
        return "";
    }

}
