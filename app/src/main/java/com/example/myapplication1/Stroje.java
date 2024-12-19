package com.example.myapplication1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class Stroje extends AppCompatActivity {

    // region Texty/Buttony . . .
    private EditText synotyRano, synotyVecer,egaming1Rano, egaming1Vecer, egaming2Rano, egaming2Vecer,
            egaming3Rano, egaming3Vecer, egaming4Rano, egaming4Vecer, apollo1Rano, apollo1Vecer, apollo2Rano,
            apollo2Vecer, kajot1Rano, kajot1Vecer, kajot2Rano, kajot2Vecer, cashomatR, cashomatV, kasaSuma;
    private TextView synotyRozdiel, egaming1Rozdiel, egaming2Rozdiel,egaming3Rozdiel, egaming4Rozdiel,
            apollo1Rozdiel, apollo2Rozdiel, kajot1Rozdiel, kajot2Rozdiel, sumaStrojov, cashomatRozdiel,
            celkovaSuma;
    private SharedPreferences sharedPreferences;
    private DecimalFormat decimalFormat;
    private Button inventuraButton, trezorButton; // endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stroje);

        // Inicializácia formátovania čísel a sharedPerferences
        decimalFormat = new DecimalFormat("#.##");
        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

        // region Inicializácia prvkov z layoutu . . .
        synotyRano = findViewById(R.id.synotR);
        synotyVecer = findViewById(R.id.synotV);
        synotyRozdiel = findViewById(R.id.synotyRozdiel);

        egaming1Rano = findViewById(R.id.egaming1R);
        egaming1Vecer = findViewById(R.id.egaming1V);
        egaming1Rozdiel = findViewById(R.id.egaming1Rozdiely);
        egaming2Rano = findViewById(R.id.egaming2R);
        egaming2Vecer = findViewById(R.id.egaming2V);
        egaming2Rozdiel = findViewById(R.id.egaming2Rozdiely);
        egaming3Rano = findViewById(R.id.egaming3R);
        egaming3Vecer = findViewById(R.id.egaming3V);
        egaming3Rozdiel = findViewById(R.id.egaming3Rozdiely);
        egaming4Rano = findViewById(R.id.egaming4R);
        egaming4Vecer = findViewById(R.id.egaming4V);
        egaming4Rozdiel = findViewById(R.id.egaming4Rozdiely);

        apollo1Rano = findViewById(R.id.apollo1R);
        apollo1Vecer = findViewById(R.id.apollo1V);
        apollo1Rozdiel = findViewById(R.id.apollo1Rozdiely);
        apollo2Rano = findViewById(R.id.apollo2R);
        apollo2Vecer = findViewById(R.id.apollo2V);
        apollo2Rozdiel = findViewById(R.id.apollo2Rozdiely);

        kajot1Rano = findViewById(R.id.kajot1R);
        kajot1Vecer = findViewById(R.id.kajot1V);
        kajot1Rozdiel = findViewById(R.id.kajot1Rozdiely);
        kajot2Rano = findViewById(R.id.kajot2R);
        kajot2Vecer = findViewById(R.id.kajot2V);
        kajot2Rozdiel = findViewById(R.id.kajot2Rozdiely);

        sumaStrojov = findViewById(R.id.sumaStrojovId);

        cashomatR = findViewById(R.id.cashomatSpolu);
        cashomatV = findViewById(R.id.cashomatZmenaren);
        cashomatRozdiel = findViewById(R.id.cashomatRozdiely);

        kasaSuma = findViewById(R.id.kasaSuma);

        celkovaSuma = findViewById(R.id.celkovaSumaId);
        inventuraButton = findViewById(R.id.ButtonInventuraId);
        trezorButton = findViewById(R.id.ButtonTrezorId);  // endregion . . .

        // region Načítanie údajov zo SharedPreferences . . .
        String synotyRanoShared = sharedPreferences.getString("synotyRano", "");
        String synotyVecerShared = sharedPreferences.getString("synotyVecer", "");

        String egaming1RanoShared = sharedPreferences.getString("egaming1Rano", "");
        String egaming1VecerShared = sharedPreferences.getString("egaming1Vecer", "");
        String egaming2RanoShared = sharedPreferences.getString("egaming2Rano", "");
        String egaming2VecerShared = sharedPreferences.getString("egaming2Vecer", "");
        String egaming3RanoShared = sharedPreferences.getString("egaming3Rano", "");
        String egaming3VecerShared = sharedPreferences.getString("egaming3Vecer", "");
        String egaming4RanoShared = sharedPreferences.getString("egaming4Rano", "");
        String egaming4VecerShared = sharedPreferences.getString("egaming4Vecer", "");

        String apollo1RanoShared = sharedPreferences.getString("apollo1Rano", "");
        String apollo1VecerShared = sharedPreferences.getString("apollo1Vecer", "");
        String apollo2RanoShared = sharedPreferences.getString("apollo2Rano", "");
        String apollo2VecerShared = sharedPreferences.getString("apollo2Vecer", "");

        String kajot1RanoShared = sharedPreferences.getString("kajot1Rano", "");
        String kajot1VecerShared = sharedPreferences.getString("kajot1Vecer", "");
        String kajot2RanoShared = sharedPreferences.getString("kajot2Rano", "");
        String kajot2VecerShared = sharedPreferences.getString("kajot2Vecer", "");

        String cashomatRShared = sharedPreferences.getString("cashomatR", "");
        String cashomatVShared = sharedPreferences.getString("cashomatV", "");

        String kasaSumaShared = sharedPreferences.getString("kasaSuma", ""); //endregion

        // region Nastavenie údajov do EditText-ov . . .
        synotyRano.setText(synotyRanoShared);
        synotyVecer.setText(synotyVecerShared);

        egaming1Rano.setText(egaming1RanoShared);
        egaming1Vecer.setText(egaming1VecerShared);
        egaming2Rano.setText(egaming2RanoShared);
        egaming2Vecer.setText(egaming2VecerShared);
        egaming3Rano.setText(egaming3RanoShared);
        egaming3Vecer.setText(egaming3VecerShared);
        egaming4Rano.setText(egaming4RanoShared);
        egaming4Vecer.setText(egaming4VecerShared);

        apollo1Rano.setText(apollo1RanoShared);
        apollo1Vecer.setText(apollo1VecerShared);
        apollo2Rano.setText(apollo2RanoShared);
        apollo2Vecer.setText(apollo2VecerShared);

        kajot1Rano.setText(kajot1RanoShared);
        kajot1Vecer.setText(kajot1VecerShared);
        kajot2Rano.setText(kajot2RanoShared);
        kajot2Vecer.setText(kajot2VecerShared);

        cashomatR.setText(cashomatRShared);
        cashomatV.setText(cashomatVShared);

        kasaSuma.setText(kasaSumaShared);

        // Výpočet a zobrazenie viewTextov
        try {
            double synotySpolu = Double.parseDouble(synotyVecerShared.isEmpty() ? "0" : synotyVecerShared) -
                    Double.parseDouble(synotyRanoShared.isEmpty() ? "0" : synotyRanoShared);
            synotyRozdiel.setText(decimalFormat.format(synotySpolu));
            double egaming1Spolu = Double.parseDouble(egaming1VecerShared.isEmpty() ? "0" : egaming1VecerShared) -
                    Double.parseDouble(egaming1RanoShared.isEmpty() ? "0" : egaming1RanoShared);
            egaming1Rozdiel.setText(decimalFormat.format(egaming1Spolu));
            double egaming2Spolu = Double.parseDouble(egaming2VecerShared.isEmpty() ? "0" : egaming2VecerShared) -
                    Double.parseDouble(egaming2RanoShared.isEmpty() ? "0" : egaming2VecerShared);
            egaming2Rozdiel.setText(decimalFormat.format(egaming2Spolu));
            double egaming3Spolu = Double.parseDouble(egaming3VecerShared.isEmpty() ? "0" : egaming3VecerShared) -
                    Double.parseDouble(egaming3RanoShared.isEmpty() ? "0" : egaming3RanoShared);
            egaming3Rozdiel.setText(decimalFormat.format(egaming3Spolu));
            double egaming4Spolu = Double.parseDouble(egaming4VecerShared.isEmpty() ? "0" : egaming4VecerShared) -
                    Double.parseDouble(egaming4RanoShared.isEmpty() ? "0" : egaming4RanoShared);
            egaming4Rozdiel.setText(decimalFormat.format(egaming4Spolu));
            double apollo1Spolu = Double.parseDouble(apollo1VecerShared.isEmpty() ? "0" : apollo1VecerShared) -
                    Double.parseDouble(apollo1RanoShared.isEmpty() ? "0" : apollo1RanoShared);
            apollo1Rozdiel.setText(decimalFormat.format(apollo1Spolu));
            double apollo2Spolu = Double.parseDouble(apollo2VecerShared.isEmpty() ? "0" : apollo2VecerShared) -
                    Double.parseDouble(apollo2RanoShared.isEmpty() ? "0" : apollo2RanoShared);
            apollo2Rozdiel.setText(decimalFormat.format(apollo2Spolu));
            double kajot1Spolu = Double.parseDouble(kajot1VecerShared.isEmpty() ? "0" : kajot1VecerShared) -
                    Double.parseDouble(kajot1RanoShared.isEmpty() ? "0" : kajot1RanoShared);
            kajot1Rozdiel.setText(decimalFormat.format(kajot1Spolu));
            double kajot2Spolu = Double.parseDouble(kajot2VecerShared.isEmpty() ? "0" : kajot2VecerShared) -
                    Double.parseDouble(kajot2RanoShared.isEmpty() ? "0" : kajot2RanoShared);
            kajot2Rozdiel.setText(decimalFormat.format(kajot2Spolu));

            double sumaStrojovSpolu = synotySpolu + egaming1Spolu + egaming2Spolu + egaming3Spolu + egaming4Spolu +
                    apollo1Spolu + apollo2Spolu + kajot1Spolu + kajot2Spolu;
            sumaStrojov.setText(decimalFormat.format(sumaStrojovSpolu));

            double cashomatSpolu = Double.parseDouble(cashomatRShared) - Double.parseDouble(cashomatVShared);
            cashomatRozdiel.setText(decimalFormat.format(cashomatSpolu));

            double celkovaSumaSpolu = sumaStrojovSpolu  + Double.parseDouble(kasaSumaShared);
            celkovaSuma.setText(decimalFormat.format(celkovaSumaSpolu));

        } catch (NumberFormatException e) {
            Log.e("MyApp", "Chyba pri prevode na číslo: " + e.getMessage());
            // Nastav výchoziu hodnotu alebo zobraz chybové hlásenie
            //spoluTrezor.setText("Error 1");
            //odovzdanaHotovost.setText("Error 2");
        } //endregion


        // region Definujem tlacidla . . .
        inventuraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Získanie hodnoty z celkového súčtu
                TextView sumaStrojovId = findViewById(R.id.celkovaSumaId);
                String sumaStrojov = sumaStrojovId.getText().toString();
                // Vytvoríme nový Intent pre prechod na MainActivity
                Intent intent = new Intent(Stroje.this, Inventura.class);
                // Pridáme hodnotu celkového súčtu ako extra údaj do Intentu
                intent.putExtra("sumaStrojov", sumaStrojov);
                // Uložíme hodnotu výhry do SharedPreferences !!!!!!
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("vyhry", sumaStrojov);
                editor.apply();
                startActivity(intent);
            }
        });


        trezorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stroje.this, Trezor.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                startActivity(intent);
            }
        }); // endregion

        // region Nastavenie listenera pre zmeny textu . . .
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Vypocet editTextov a ViewTextow
                double kasaHodnota = kasaSuma.getText().toString().isEmpty() ? 0 : Double.parseDouble(kasaSuma.getText().toString());

                double synotyRanoHodnota = synotyRano.getText().toString().isEmpty() ? 0 : Double.parseDouble(synotyRano.getText().toString());
                double synotyVecerHodnota = synotyVecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(synotyVecer.getText().toString());
                double synotyRozdielHodnota = synotyVecerHodnota - synotyRanoHodnota;
                synotyRozdiel.setText(decimalFormat.format(synotyRozdielHodnota));

                double egaming1RanoHodnota = egaming1Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming1Rano.getText().toString());
                double egaming1VecerHodnota = egaming1Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming1Vecer.getText().toString());
                double egaming1RozdielHodnota = egaming1VecerHodnota - egaming1RanoHodnota;
                egaming1Rozdiel.setText(decimalFormat.format(egaming1RozdielHodnota));

                double egaming2RanoHodnota = egaming2Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming2Rano.getText().toString());
                double egaming2VecerHodnota = egaming2Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming2Vecer.getText().toString());
                double egaming2RozdielHodnota = egaming2VecerHodnota - egaming2RanoHodnota;
                egaming2Rozdiel.setText(decimalFormat.format(egaming2RozdielHodnota));

                double egaming3RanoHodnota = egaming3Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming3Rano.getText().toString());
                double egaming3VecerHodnota = egaming3Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming3Vecer.getText().toString());
                double egaming3RozdielHodnota = egaming3VecerHodnota - egaming3RanoHodnota;
                egaming3Rozdiel.setText(decimalFormat.format(egaming3RozdielHodnota));

                double egaming4RanoHodnota = egaming4Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming4Rano.getText().toString());
                double egaming4VecerHodnota = egaming4Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(egaming4Vecer.getText().toString());
                double egaming4RozdielHodnota = egaming4VecerHodnota - egaming4RanoHodnota;
                egaming4Rozdiel.setText(decimalFormat.format(egaming4RozdielHodnota));

                double apollo1RanoHodnota = apollo1Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(apollo1Rano.getText().toString());
                double apollo1VecerHodnota = apollo1Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(apollo1Vecer.getText().toString());
                double apollo1RozdielHodnota = apollo1VecerHodnota - apollo1RanoHodnota;
                apollo1Rozdiel.setText(decimalFormat.format(apollo1RozdielHodnota));

                double apollo2RanoHodnota = apollo2Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(apollo2Rano.getText().toString());
                double apollo2VecerHodnota = apollo2Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(apollo2Vecer.getText().toString());
                double apollo2RozdielHodnota = apollo2VecerHodnota - apollo2RanoHodnota;
                apollo2Rozdiel.setText(decimalFormat.format(apollo2RozdielHodnota));

                double kajot1RanoHodnota = kajot1Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(kajot1Rano.getText().toString());
                double kajot1VecerHodnota = kajot1Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(kajot1Vecer.getText().toString());
                double kajot1RozdielHodnota  = kajot1VecerHodnota - kajot1RanoHodnota;
                kajot1Rozdiel.setText(decimalFormat.format(kajot1RozdielHodnota));

                double kajot2RanoHodnota = kajot2Rano.getText().toString().isEmpty() ? 0 : Double.parseDouble(kajot2Rano.getText().toString());
                double kajot2VecerHodnota = kajot2Vecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(kajot2Vecer.getText().toString());
                double kajot2RozdielHodnota = kajot2VecerHodnota - kajot2RanoHodnota;
                kajot2Rozdiel.setText(decimalFormat.format(kajot2RozdielHodnota));

                double cashomatRHodnota = cashomatR.getText().toString().isEmpty() ? 0 : Double.parseDouble(cashomatR.getText().toString());
                double cashomatVHodnota = cashomatV.getText().toString().isEmpty() ? 0 : Double.parseDouble(cashomatV.getText().toString());
                double cashomatRozdielHodnota = cashomatRHodnota - cashomatVHodnota;
                cashomatRozdiel.setText(decimalFormat.format(cashomatRozdielHodnota));

                double sumaStrojovHodnota = synotyRozdielHodnota + egaming1RozdielHodnota + egaming2RozdielHodnota + egaming3RozdielHodnota +
                        egaming4RozdielHodnota + apollo1RozdielHodnota + apollo2RozdielHodnota + kajot1RozdielHodnota + kajot2RozdielHodnota;
                sumaStrojov.setText(decimalFormat.format(sumaStrojovHodnota));

                double celkovaSumaHodnota = sumaStrojovHodnota  +  kasaHodnota;
                celkovaSuma.setText(decimalFormat.format(celkovaSumaHodnota)); //endregion

                //  region Uloženie zmien do SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("synotyRano", synotyRano.getText().toString());
                editor.putString("synotyVecer", synotyVecer.getText().toString());
                editor.putString("egaming1Rano", egaming1Rano.getText().toString());
                editor.putString("egaming1Vecer", egaming1Vecer.getText().toString());
                editor.putString("egaming2Rano", egaming2Rano.getText().toString());
                editor.putString("egaming2Vecer", egaming2Vecer.getText().toString());
                editor.putString("egaming3Rano", egaming3Rano.getText().toString());
                editor.putString("egaming3Vecer", egaming3Vecer.getText().toString());
                editor.putString("egaming4Rano", egaming4Rano.getText().toString());
                editor.putString("egaming4Vecer", egaming4Vecer.getText().toString());
                editor.putString("apollo1Rano", apollo1Rano.getText().toString());
                editor.putString("apollo1Vecer", apollo1Vecer.getText().toString());
                editor.putString("apollo2Rano", apollo2Rano.getText().toString());
                editor.putString("apollo2Vecer", apollo2Vecer.getText().toString());
                editor.putString("kajot1Rano", kajot1Rano.getText().toString());
                editor.putString("kajot1Vecer", kajot1Vecer.getText().toString());
                editor.putString("kajot2Rano", kajot2Rano.getText().toString());
                editor.putString("kajot2Vecer", kajot2Vecer.getText().toString());

                editor.putString("cashomatR", cashomatR.getText().toString());
                editor.putString("cashomatV", cashomatV.getText().toString());

                editor.putString("kasaSuma", kasaSuma.getText().toString());
                editor.apply(); //endregion
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };


        // region Priradenie listenera k EditText-om
        synotyRano.addTextChangedListener(textWatcher);
        synotyVecer.addTextChangedListener(textWatcher);

        egaming1Rano.addTextChangedListener(textWatcher);
        egaming1Vecer.addTextChangedListener(textWatcher);
        egaming2Rano.addTextChangedListener(textWatcher);
        egaming2Vecer.addTextChangedListener(textWatcher);
        egaming3Rano.addTextChangedListener(textWatcher);
        egaming3Vecer.addTextChangedListener(textWatcher);
        egaming4Rano.addTextChangedListener(textWatcher);
        egaming4Vecer.addTextChangedListener(textWatcher);

        apollo1Rano.addTextChangedListener(textWatcher);
        apollo1Vecer.addTextChangedListener(textWatcher);
        apollo2Rano.addTextChangedListener(textWatcher);
        apollo2Vecer.addTextChangedListener(textWatcher);

        kajot1Rano.addTextChangedListener(textWatcher);
        kajot1Vecer.addTextChangedListener(textWatcher);
        kajot2Rano.addTextChangedListener(textWatcher);
        kajot2Vecer.addTextChangedListener(textWatcher);

        cashomatR.addTextChangedListener(textWatcher);
        cashomatV.addTextChangedListener(textWatcher);

        kasaSuma.addTextChangedListener(textWatcher); //endregion
    }
}

