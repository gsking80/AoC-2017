package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day21 {

    Map<String, String> twoMap;
    Map<String, String> threeMap;
    List<String> image;

    public Day21(FileReader fileReader) {
        try {
            final BufferedReader buf = new BufferedReader(fileReader);
            twoMap = new HashMap<>();
            threeMap = new HashMap<>();
            image = new ArrayList<>();
            image.add(".#.");
            image.add("..#");
            image.add("###");
            printImage();

            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    final String[] pieces = lineJustFetched.split(" => ");
                    if(pieces[0].chars().filter(x -> x == '/').count() == 1) {
                        twoMap.putAll(extendTwo(pieces[0],pieces[1]));
                    } else {
                        threeMap.putAll(extendThree(pieces[0], pieces[1]));
                    }
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException();
        }
    }

    public void iterate(final int iterations) {
        for (int i = 0; i < iterations; i++) {
            if ((image.size() % 2) == 0) { // divisible by 2
                enhanceTwo();
            } else {
                enhanceThree();
            }
            printImage();
        }
    }

    public int pixelsOn() {
        int pixels = 0;
        for(final String line : image) {
            pixels += line.chars().filter(x -> x == '#').count();
        }
        return pixels;
    }

    private Map<String,String> extendTwo(final String key, final String value) {
        Map<String,String> entries = new HashMap<>();

        String[] keyPieces = key.split("/");

        entries.put(key, value);
        entries.put(keyPieces[1] + "/" + keyPieces[0], value);
        entries.put(new StringBuilder(keyPieces[0]).reverse().toString() + "/" + new StringBuilder(keyPieces[1]).reverse().toString(), value);
        entries.put(new StringBuilder(keyPieces[1]).reverse().toString() + "/" + new StringBuilder(keyPieces[0]).reverse().toString(), value);

        final StringBuilder top = new StringBuilder().append(keyPieces[0].charAt(0)).append(keyPieces[1].charAt(0));
        final StringBuilder bottom = new StringBuilder().append(keyPieces[0].charAt(1)).append(keyPieces[1].charAt(1));

        entries.put(top.toString() + "/" + bottom.toString(), value);
        entries.put(bottom.toString() + "/" + top.toString(), value);
        entries.put(top.reverse().toString() + "/" + bottom.reverse().toString(), value);
        entries.put(bottom.toString() + "/" + top.toString(), value);

        return entries;
    }

    private Map<String,String> extendThree(final String key, final String value) {
        Map<String,String> entries = new HashMap<>();

        String[] keyPieces = key.split("/");

        entries.put(key, value);
        entries.put(keyPieces[2] + "/" + keyPieces[1] + "/" + keyPieces[0], value);
        entries.put(new StringBuilder(keyPieces[0]).reverse().toString() + "/" + new StringBuilder(keyPieces[1]).reverse().toString() + "/" + new StringBuilder(keyPieces[2]).reverse().toString(), value);
        entries.put(new StringBuilder(keyPieces[2]).reverse().toString() + "/" + new StringBuilder(keyPieces[1]).reverse().toString() + "/" + new StringBuilder(keyPieces[0]).reverse().toString(), value);

        final StringBuilder top = new StringBuilder().append(keyPieces[0].charAt(0)).append(keyPieces[1].charAt(0)).append(keyPieces[2].charAt(0));
        final StringBuilder middle = new StringBuilder().append(keyPieces[0].charAt(1)).append(keyPieces[1].charAt(1)).append(keyPieces[2].charAt(1));
        final StringBuilder bottom = new StringBuilder().append(keyPieces[0].charAt(2)).append(keyPieces[1].charAt(2)).append(keyPieces[2].charAt(2));

        entries.put(top.toString() + "/" + middle.toString() + "/" + bottom.toString(), value);
        entries.put(bottom.toString() + "/" + middle.toString() + "/" + top.toString(), value);
        entries.put(top.reverse().toString() + "/" + middle.reverse().toString() + "/" + bottom.reverse().toString(), value);
        entries.put(bottom.toString() + "/" + middle.toString() + "/" + top.toString(), value);

        return entries;
    }

    private void enhanceTwo() {
        List<String> enhancedImage = new ArrayList<>();
        for (int i = 0; i < image.size(); i += 2) {
            final StringBuilder sb0 = new StringBuilder();
            final StringBuilder sb1 = new StringBuilder();
            final StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < image.size(); j += 2) {
                String enhanced = twoMap.get(image.get(i).substring(j,j+2) + "/" + image.get(i+1).substring(j,j+2));
                if (enhanced == null) {
                    System.out.println(i + " " + j + " " + image.get(i).substring(j,j+2) + "/" + image.get(i+1).substring(j,j+2));
                }
                String[] pieces = enhanced.split("/");
                sb0.append(pieces[0]);
                sb1.append(pieces[1]);
                sb2.append(pieces[2]);
            }
            enhancedImage.add(sb0.toString());
            enhancedImage.add(sb1.toString());
            enhancedImage.add(sb2.toString());
        }
        image = enhancedImage;
    }

    private void enhanceThree() {
        List<String> enhancedImage = new ArrayList<>();
        for (int i = 0; i < image.size(); i += 3) {
            final StringBuilder sb0 = new StringBuilder();
            final StringBuilder sb1 = new StringBuilder();
            final StringBuilder sb2 = new StringBuilder();
            final StringBuilder sb3 = new StringBuilder();
            for (int j = 0; j < image.size(); j += 3) {
                String enhanced = threeMap.get(image.get(i).substring(j,j+3) + "/" + image.get(i+1).substring(j,j+3) + "/" + image.get(i+2).substring(j,j+3));
                String[] pieces = enhanced.split("/");
                sb0.append(pieces[0]);
                sb1.append(pieces[1]);
                sb2.append(pieces[2]);
                sb3.append(pieces[3]);
            }
            enhancedImage.add(sb0.toString());
            enhancedImage.add(sb1.toString());
            enhancedImage.add(sb2.toString());
            enhancedImage.add(sb3.toString());
        }
        image = enhancedImage;
    }

    private void printImage() {
        for (final String line: image) {
            System.out.println(line);
        }
        System.out.println();
    }
}
