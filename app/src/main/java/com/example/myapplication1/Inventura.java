        package com.example.myapplication1;

        import androidx.appcompat.app.AppCompatActivity;
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
        import java.text.DecimalFormat;

        public class Inventura extends AppCompatActivity {

            // region Texty/Buttony . . .
            private EditText ranajsiTrezor, doplnenePeniaze1, doplnenePeniaze2, atm, cashomat, naklady;
            private TextView spoluTrezor, vyhry, odovzdanaHotovost;
            private Button strojeButton, trezorButton;
            private SharedPreferences sharedPreferences;
            private DecimalFormat decimalFormat; // endregion



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.inventura);

                // Inicializácia formátovania čísel a sharedPerferences
                decimalFormat = new DecimalFormat("#.##");
                sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);


                // region Inicializácia prvkov z layoutu . . .
                ranajsiTrezor = findViewById(R.id.ranajsiTrezorId);
                doplnenePeniaze1 = findViewById(R.id.doplnenePeniaze1Id);
                doplnenePeniaze2 = findViewById(R.id.doplnenePeniaze2Id);
                spoluTrezor = findViewById(R.id.spoluTrezorId);
                vyhry = findViewById(R.id.vyhryId);
                atm = findViewById(R.id.atmId);
                cashomat = findViewById(R.id.cashomatId);
                naklady = findViewById(R.id.nakladyId);
                odovzdanaHotovost = findViewById(R.id.odovzdanaHotvostId);
                strojeButton = findViewById(R.id.ButtonStrojeId);
                trezorButton = findViewById(R.id.ButtonTrezorId); // endregion

                // region Načítanie údajov zo SharedPreferences . . .
                String trezorShared = sharedPreferences.getString("ranajsiTrezor", "");
                String doplnenePeniaze1Shared = sharedPreferences.getString("doplnenePeniaze1", "");
                String doplnenePeniaze2Shared = sharedPreferences.getString("doplnenePeniaze2", "");
                String vyhryShared = sharedPreferences.getString("vyhry","");
                String atmShared = sharedPreferences.getString("atm", "");
                String cashomatShared = sharedPreferences.getString("cashomat", "");
                String nakladyShared = sharedPreferences.getString("naklady", "");       //endregion

                // region Nastavenie údajov do EditText-ov  . . .
                ranajsiTrezor.setText(trezorShared);
                doplnenePeniaze1.setText(doplnenePeniaze1Shared);
                doplnenePeniaze2.setText(doplnenePeniaze2Shared);
                vyhry.setText(vyhryShared);
                atm.setText(atmShared);
                cashomat.setText(cashomatShared);
                naklady.setText(nakladyShared);

                // Výpočet a zobrazenie textViewov
                try {
                    double trezorSpolu = Double.parseDouble(trezorShared.isEmpty() ? "0" : trezorShared) +
                            Double.parseDouble(doplnenePeniaze1Shared.isEmpty() ? "0" : doplnenePeniaze1Shared) +
                            Double.parseDouble(doplnenePeniaze2Shared.isEmpty() ? "0" : doplnenePeniaze2Shared);
                    spoluTrezor.setText(decimalFormat.format(trezorSpolu));

                    double odovzdanaHotovostSpolu = trezorSpolu - (
                            Double.parseDouble(atmShared.isEmpty() ? "0" : atmShared) +
                            Double.parseDouble(cashomatShared.isEmpty() ? "0" : cashomatShared) +
                            Double.parseDouble(nakladyShared.isEmpty() ? "0" : nakladyShared) +
                            Double.parseDouble(vyhryShared.isEmpty() ? "0" : vyhryShared));
                    odovzdanaHotovost.setText(decimalFormat.format(odovzdanaHotovostSpolu));

                } catch (NumberFormatException e) {
                    Log.e("MyApp", "Chyba pri prevode na číslo: " + e.getMessage());
                    // Nastav výchoziu hodnotu alebo zobraz chybové hlásenie
                    //spoluTrezor.setText("Error 1");
                    //odovzdanaHotovost.setText("Error 2");
                } //endregion

                // region Definujem tlacidla . . .
                strojeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Inventura.this, Stroje.class);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        startActivity(intent);
                    }
                });


                trezorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Získanie hodnoty z celkového súčtu
                        TextView odovzdanaHotvostId = findViewById(R.id.odovzdanaHotvostId);
                        String InventuraHodnota = odovzdanaHotvostId.getText().toString();
                        // Vytvoríme nový Intent pre prechod na MainActivity
                        Intent intent = new Intent(Inventura.this, Trezor.class);
                        // Pridáme hodnotu celkového súčtu ako extra údaj do Intentu
                        intent.putExtra("InventuraHodnota", InventuraHodnota);
                        // Uložíme hodnotu výhry do SharedPreferences !!!!!!
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("suma", InventuraHodnota);
                        editor.apply();
                        startActivity(intent);
                    }
                }); //endregion

                // Získanie Intentu a nastavenie hodnoty z Intentu
                Intent intent = getIntent();
                if (intent.hasExtra("sumaStrojov")) {
                    String sumaStrojov = intent.getStringExtra("sumaStrojov");
                    vyhry.setText(sumaStrojov);
                }



                // region Nastavenie listenera pre zmeny textu . . .
                TextWatcher textWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        // Vypocet editTextov a ViewTextow
                        double ranajsiTrezorHodnota = ranajsiTrezor.getText().toString().isEmpty() ? 0 : Double.parseDouble(ranajsiTrezor.getText().toString());
                        double doplnenePeniaze1Hodnota = doplnenePeniaze1.getText().toString().isEmpty() ? 0 : Double.parseDouble(doplnenePeniaze1.getText().toString());
                        double doplnenePeniaze2Hodnota = doplnenePeniaze2.getText().toString().isEmpty() ? 0 : Double.parseDouble(doplnenePeniaze2.getText().toString());
                        double atmHodnota = atm.getText().toString().isEmpty() ? 0 : Double.parseDouble(atm.getText().toString());
                        double cashomatHodnota = cashomat.getText().toString().isEmpty() ? 0 : Double.parseDouble(cashomat.getText().toString());
                        double nakladyHodnota = naklady.getText().toString().isEmpty() ? 0 : Double.parseDouble(naklady.getText().toString());

                        double trezorSpolu = ranajsiTrezorHodnota + doplnenePeniaze1Hodnota + doplnenePeniaze2Hodnota;
                        spoluTrezor.setText(decimalFormat.format(trezorSpolu));

                        // Získanie hodnoty z TextView vyhry a konverzia na číslo
                        double vyhryHodnota = vyhry.getText().toString().isEmpty() ? 0 : Double.parseDouble(vyhry.getText().toString());
                        double odratatHodnoty = atmHodnota + cashomatHodnota + nakladyHodnota + vyhryHodnota;
                        double odovzdanaHotovostSpolu = trezorSpolu - odratatHodnoty;
                        odovzdanaHotovost.setText(decimalFormat.format(odovzdanaHotovostSpolu));

                        //  region Uloženie zmien do SharedPreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("ranajsiTrezor", ranajsiTrezor.getText().toString());
                        editor.putString("doplnenePeniaze1", doplnenePeniaze1.getText().toString());
                        editor.putString("doplnenePeniaze2", doplnenePeniaze2.getText().toString());
                        editor.putString("vyhry", vyhry.getText().toString()); // Uloženie hodnoty výhry
                        editor.putString("atm", atm.getText().toString());
                        editor.putString("cashomat", cashomat.getText().toString());
                        editor.putString("naklady", naklady.getText().toString());
                        editor.apply();// endregion
                    }

                    @Override
                    public void afterTextChanged(Editable s) {}
                };

                // region Priradenie listenera k EditText-om
                ranajsiTrezor.addTextChangedListener(textWatcher);
                doplnenePeniaze1.addTextChangedListener(textWatcher);
                doplnenePeniaze2.addTextChangedListener(textWatcher);
                vyhry.addTextChangedListener(textWatcher);
                atm.addTextChangedListener(textWatcher);
                cashomat.addTextChangedListener(textWatcher);
                naklady.addTextChangedListener(textWatcher); //endregion
            }
        }