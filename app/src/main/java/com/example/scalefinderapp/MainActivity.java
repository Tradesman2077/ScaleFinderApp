package com.example.scalefinderapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ToggleButton cToggle;
    private ToggleButton cSharpToggle;
    private ToggleButton dToggle;
    private ToggleButton dSharpToggle;
    private ToggleButton eToggle;
    private ToggleButton fToggle;
    private ToggleButton fSharpToggle;
    private ToggleButton gToggle;
    private ToggleButton gSharpToggle;
    private ToggleButton aToggle;
    private ToggleButton aSharpToggle;
    private ToggleButton bToggle;
    private HashMap<String, String[]> scales;
    private ArrayList<String> selectedNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cToggle = findViewById(R.id.C_Bsharp_toggle);
        cSharpToggle = findViewById(R.id.Csharp_Dflat_toggle);
        dToggle = findViewById(R.id.D_toggle);
        dSharpToggle = findViewById(R.id.Dsharp_Eflat_toggle);
        eToggle =findViewById(R.id.E_Fflat_toggle);
        fToggle = findViewById(R.id.F_Esharp_toggle);
        fSharpToggle =findViewById(R.id.Fsharp_Gflat_toggle);
        gToggle = findViewById(R.id.G_toggle);
        gSharpToggle = findViewById(R.id.Gsharp_Aflat_toggle);
        aToggle = findViewById(R.id.A_toggle);
        aSharpToggle = findViewById(R.id.Asharp_Bflat_toggle);
        bToggle = findViewById(R.id.B_toggle);

        selectedNotes = new ArrayList<>();
        scales = new HashMap<>();

        /*
        add scales to hashMap
         major scales
        */

        scales.put("C maj", new String[] {"C", "D", "E", "F", "G", "A", "B", "B#", "Fb", "E#", "Cb"});
        scales.put("C# maj", new String[]{"C#", "D#", "E#", "F#", "G#", "A#", "B#", "C", "F"});
        scales.put("D maj", new String[]{"D", "E", "F#", "G", "A", "B", "C#", "Fb", "Cb"});
        scales.put("Eb maj", new String[]{"Eb", "F", "G", "Ab", "Bb", "C", "B#"});
        scales.put("E maj", new String[]{"E", "F#", "G#", "A", "B", "C#", "D#", "Fb", "Cb"});
        scales.put("F# major", new String[]{"F#", "G#", "A#", "B", "C#", "D#", "E#", "F", "Cb"});
        scales.put("G major", new String[]{"G", "A", "B", "C", "D", "E", "F#", "B#", "Fb", "Cb"});
        scales.put("Ab major", new String[]{"Ab", "Bb", "C", "Db", "Eb", "F", "G", "B#", "E#"});
        scales.put("A major", new String[]{"A", "B", "C#", "D", "E", "F#", "G#", "Fb", "Cb"});
        scales.put("Bb major", new String[]{"Bb", "C", "D", "Eb", "F", "G", "A", "B#", "E#"});
        scales.put("B major", new String[]{"B", "C#", "D#", "E", "F#", "G#", "A#", "Fb"});

        /* natural minor */

        scales.put("C minor", new String[]{"C", "D", "Eb", "F", "G", "Ab", "Bb", "B#", "E#"});
        scales.put("D minor", new String[]{"D", "E", "F", "G", "A", "Bb", "C", "B#", "Fb", "E#"});
        scales.put("E minor", new String[]{"E", "F#", "G", "A", "B", "C", "D", "B#", "Fb", "Cb"});
        scales.put("F minor", new String[]{"F", "G", "Ab", "Bb", "C", "Db", "Eb", "B#", "E#"});
        scales.put("G minor", new String[]{"G", "A", "Bb", "C", "D", "Eb", "F", "B#", "E#"});
        scales.put("A minor", new String[]{"A", "B", "C", "D", "E", "F", "G", "B#", "Fb", "E#", "Cb"});
        scales.put("B minor", new String[]{"B", "C#", "D", "E", "F#", "G", "A", "Fb", "Cb"});
        scales.put("C# minor", new String[]{"C#", "D#", "E", "F#", "G#", "A", "B", "Cb"});
        scales.put("Eb minor", new String[]{"Eb", "F", "Gb", "Ab", "Bb", "Cb", "Db", "E#", "B"});
        scales.put("F# minor", new String[]{"F#", "G#", "A", "B", "C#", "D", "E", "Fb", "Cb"});
        scales.put("Ab minor", new String[]{"Ab", "Bb", "Cb", "Db", "Eb", "Fb", "Gb", "E", "B"});
        scales.put("Bb minor", new String[]{"Bb", "C", "Db", "Eb", "F", "Gb", "Ab", "E#", "B#"});

        /* setting on click listeners
         for toggle buttons */

        cToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedNotes.add("C");
                selectedNotes.add("B#");
                checkScales();
            } else {
                if (selectedNotes.contains("C")){
                    selectedNotes.remove("C");
                    selectedNotes.remove("B#");
                    checkScales();
                }
            }
        });

        cSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("C#");
                selectedNotes.add("Db");
                checkScales();
            }
            else{
                if (selectedNotes.contains("C#")){
                    selectedNotes.remove("C#");
                    selectedNotes.remove("Db");
                    checkScales();
                }
            }
        });

        dToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("D");
                checkScales();
            }
            else{
                if (selectedNotes.contains("D")){
                    selectedNotes.remove("D");
                    checkScales();
                }
            }
        });

        dSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("D#");
                selectedNotes.add("Eb");
                checkScales();
            }
            else{
                if (selectedNotes.contains("D#")){
                    selectedNotes.remove("D#");
                    selectedNotes.remove("Eb");
                    checkScales();
                }
            }
        });

        eToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("E");
                selectedNotes.add("Fb");
                checkScales();
            }
            else{
                if (selectedNotes.contains("E")){
                    selectedNotes.remove("E");
                    selectedNotes.remove("Fb");
                    checkScales();
                }
            }
        });

        fToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("F");
                selectedNotes.add("E#");
                checkScales();
            }
            else{
                if (selectedNotes.contains("F")){
                    selectedNotes.remove("F");
                    selectedNotes.remove("E#");
                    checkScales();
                }
            }
        });

        fSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("F#");
                selectedNotes.add("Gb");
                checkScales();
            }
            else{
                if (selectedNotes.contains("F#")){
                    selectedNotes.remove("F#");
                    selectedNotes.remove("Gb");
                    checkScales();
                }
            }
        });

        gToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("G");
                checkScales();
            }
            else{
                if (selectedNotes.contains("G")){
                    selectedNotes.remove("G");
                    checkScales();
                }
            }
        });

        gSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("G#");
                selectedNotes.add("Ab");
                checkScales();
            }
            else{
                if (selectedNotes.contains("G#")){
                    selectedNotes.remove("G#");
                    selectedNotes.remove("Ab");
                    checkScales();
                }
            }
        });

        aToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("A");
                checkScales();
            }
            else{
                if (selectedNotes.contains("A")){
                    selectedNotes.remove("A");
                    checkScales();
                }
            }
        });

        aSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("A#");
                selectedNotes.add("Bb");
                checkScales();
            }
            else{
                if (selectedNotes.contains("A#")){
                    selectedNotes.remove("A#");
                    selectedNotes.remove("Bb");
                    checkScales();
                }
            }
        });

        bToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("B");
                selectedNotes.add("Cb");
                checkScales();
            }
            else{
                if (selectedNotes.contains("B")){
                    selectedNotes.remove("B");
                    selectedNotes.remove("Cb");
                    checkScales();
                }
            }
        });


    }

    /* method to check if selected notes are ina scale and log scales */

    private void checkScales(){
        Log.d("id", String.valueOf(selectedNotes));
        ArrayList<String> returnedScales = new ArrayList<>();
        boolean containedInScale = false;
        for (Map.Entry<String, String[]> entry : scales.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            List<String> valuesArrayList = Arrays.asList(values);
            //Log.d("id", "vales: " + valuesArrayList.toString());
            if (valuesArrayList.containsAll(selectedNotes)){
                Log.d("id", "checkScales: " + key);
            }
        }
        Log.d("id", "------------------------------");

    }
}