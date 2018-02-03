package org.a2.sandbox.Problems.CarSubTracks;

public class Result {

    private Integer[] result;

    public Result(Input input) {
        this.result = new Integer[input.count];
    }

    public void addPetrolUnit(Integer index, Integer petrolUnits){
        this.result[index] = petrolUnits;
    }

    public int getPetrolUnits(Integer index) {
        if(this.result.length < index){
            return 0;
        }

        return this.result[index];
    }
}