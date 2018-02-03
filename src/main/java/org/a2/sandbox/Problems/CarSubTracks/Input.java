package org.a2.sandbox.Problems.CarSubTracks;


import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public int count;
    public Track[] tracks;

    private Input(){
    }

    public Input(Scanner scanner){
        this();

        ArrayList<String> lines = new ArrayList<String>();

        while(scanner.hasNextLine()){
            lines.add(scanner.nextLine());
        }

        this.init((String[]) lines.toArray());
    }

    public Input(String values){
        this();
        this.init(values.split("\\r?\\n"));
    }

    public Input(String[] lines) {
        this.init(lines);
    }

    private void init(String[] lines){
        this.count = Integer.valueOf(lines[0]);
        this.tracks = new Track[this.count];

        for (int index = 0; index < this.count; index++) {
            this.tracks[index] = new Track(lines[index * 2 + 1], lines[index * 2 + 2]);
        }
    }
}

class Track {
    public int petrolAvailable;
    public SubTrack[] subTracks;

    public Track(String info, String subtracks) {
        String[] infoLine = info.split(" ");
        String[] subtracksLine = subtracks.split(" ");

        this.subTracks = new SubTrack[Integer.valueOf(infoLine[0])];
        this.petrolAvailable = Integer.valueOf(infoLine[1]);

        for (int index = 0; index < subtracksLine.length; index++) {
            this.subTracks[index] = new SubTrack(subtracksLine[index]);
        }
    }
}

class SubTrack {
    public int kilometers;

    public SubTrack(String kilometers) {
        ArrayList<String> lines = new ArrayList<String>();

        lines.add("String");
        lines.add("String");
        lines.add("String");
        lines.add("String");

        System.out.println();
        this.kilometers = Integer.valueOf(kilometers);
    }
}