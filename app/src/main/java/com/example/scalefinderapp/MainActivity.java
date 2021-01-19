package com.example.scalefinderapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

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



        ArrayList<String> selectedNotes = new ArrayList<>();
        HashMap<String, String[]> scales = new HashMap<>();

        /*
        add scales to hashMap

        fksjlfkjsldkfjslkdfjlskdjfsdf
         major scales
        */
        scales.put("C maj", new String[] {"C", "D", "E", "F", "G", "A", "B"});
        scales.put("C# maj", new String[]{"C#", "D#", "E#", "F#", "G#", "A#", "B#"});
        scales.put("D maj", new String[]{"D", "E", "F#", "G", "A", "B", "C#"});
        scales.put("Eb maj", new String[]{"Eb", "F", "G", "Ab", "Bb", "C"});
        scales.put("E maj", new String[]{"E", "F#", "G#", "A", "B", "C#", "D#"});
        scales.put("F# major", new String[]{"F#", "G#", "A#", "B", "C#", "D#", "E#"});
        scales.put("G major", new String[]{"G", "A", "B", "C", "D", "E", "F#"});
        scales.put("Ab major", new String[]{"Ab", "Bb", "C", "Db", "Eb", "F", "G"});
        scales.put("A major", new String[]{"A", "B", "C#", "D", "E", "F#", "G#"});
        scales.put("Bb major", new String[]{"Bb", "C", "D", "Eb", "F", "G", "A"});
        scales.put("B major", new String[]{"B", "C#", "D#", "E", "F#", "G#", "A#"});

        /* natural minor */
        scales.put("C minor", new String[]{"C", "D", "Eb", "F", "G", "Ab", "Bb"});
        scales.put("D minor", new String[]{"D", "E", "F", "G", "A", "Bb", "C"});
        scales.put("E minor", new String[]{"E", "F#", "G", "A", "B", "C", "D"});
        scales.put("F minor", new String[]{"F", "G", "Ab", "Bb", "C", "Db", "Eb"});
        scales.put("G minor", new String[]{"G", "A", "Bb", "C", "D", "Eb", "F"});
        scales.put("A minor", new String[]{"A", "B", "C", "D", "E", "F", "G"});
        scales.put("B minor", new String[]{"B", "C#", "D", "E", "F#", "G", "A"});
        scales.put("C# minor", new String[]{"C#", "D#", "E", "F#", "G#", "A", "B"});
        scales.put("Eb minor", new String[]{"Eb", "F", "Gb", "Ab", "Bb", "Cb", "Db"});
        scales.put("F# minor", new String[]{"F#", "G#", "A", "B", "C#", "D", "E"});
        scales.put("Ab minor", new String[]{"Ab", "Bb", "Cb", "Db", "Eb", "Fb", "Gb"});
        scales.put("Bb minor", new String[]{"Bb", "C", "Db", "Eb", "F", "Gb", "Ab"});


        /* setting on click listeners for toggle buttons */

        cToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedNotes.add("C");
                selectedNotes.add("Bb");
                Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
            } else {
                if (selectedNotes.contains("C")){
                    selectedNotes.remove("C");
                    selectedNotes.remove("Bb");
                    Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
                }
            }
        });

        cSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("C#");
                selectedNotes.add("Db");
                Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
            }
            else{
                if (selectedNotes.contains("C#")){
                    selectedNotes.remove("C#");
                    selectedNotes.remove("Db");
                    Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
                }
            }
        });

        dToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("D");
                Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
            }
            else{
                if (selectedNotes.contains("D")){
                    selectedNotes.remove("D");
                    Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
                }
            }
        });

        dSharpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("D#");
                selectedNotes.add("Eb");
                Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
            }
            else{
                if (selectedNotes.contains("D#")){
                    selectedNotes.remove("D#");
                    selectedNotes.remove("Eb");
                    Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
                }
            }
        });

        eToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                selectedNotes.add("E");
                selectedNotes.add("Fb");
                Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
            }
            else{
                if (selectedNotes.contains("E")){
                    selectedNotes.remove("E");
                    selectedNotes.remove("Fb");
                    Log.d("check selected notes", "onCreate: " + selectedNotes.toString());
                }
            }
        });

    }

}