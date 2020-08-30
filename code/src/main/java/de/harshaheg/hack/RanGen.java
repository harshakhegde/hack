package de.harshaheg.hack;

public class RanGen {

    public Long getRandom(Integer numOfDigits){
        if(numOfDigits>19){
            throw new IllegalArgumentException("Cannot generate random number of > 19 digits");
        }
        String randomNumber = new String("");
        for (int i = 0; i < numOfDigits; i++) {
            Integer digit = getDigit();
            String s = String.valueOf(digit);
            randomNumber = randomNumber.concat(s);
        }
        return Long.parseLong(randomNumber);
    }

    private Integer getDigit() {
        final Long digit = System.nanoTime() % 10;
        return digit.intValue();
    }
}
