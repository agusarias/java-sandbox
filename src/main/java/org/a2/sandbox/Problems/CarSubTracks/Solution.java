package org.a2.sandbox.Problems.CarSubTracks;

public class Solution {

    private Result result;

    public Result solve(Input input) {
        result = new Result(input);

        this.carSubTracks(input);

        return result;
    }

    /**
     * Suppose you are car driver and you have to drive a car on a track divided into "N" no. of sub-tracks. You are also given the value of "K" i.e. the total kilometers a car can drive on each sub-track. If the car can't cover a sub-track, you can add any unit of Petrol in it. With each unit of petrol added, the total kilometers your car can travel will increase by one unit .
     * <p>
     * Input:
     * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two space separated integers N and K. The second line of each test case contains N space separated integers (A[])  denoting the distance of each N sub-tracks.
     * <p>
     * Output:
     * For each test case in a new line you have to print out the minimum unit of Petrol your car require to cover all the sub-tracks. If no extra unit of petrol is required, print -1.
     * <p>
     * Constraints:
     * 1<=T<=100
     * 1<=N,K<=200
     * 1<=A[]<=1000
     */
    private void carSubTracks(Input input) {

        for (int index = 0; index < input.tracks.length; index++) {
            int petrolNeeded = this.solveTrack(input.tracks[index]);

            this.result.addPetrolUnit(index, petrolNeeded);
        }
    }

    private int solveTrack(Track track) {
        int maxKilometers = this.maxKilometers(track.subTracks);

        return maxKilometers > track.petrolAvailable ?
                maxKilometers - track.petrolAvailable : -1;
    }

    private int maxKilometers(SubTrack[] subTracks) {
        int max = 0;
        for (SubTrack subTrack : subTracks){
            if(max < subTrack.kilometers){
                max = subTrack.kilometers;
            }
        }
        return max;
    }


}


