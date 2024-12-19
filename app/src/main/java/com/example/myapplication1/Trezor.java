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

    public class Trezor extends AppCompatActivity {

        // region Texty/Buttony . . .
        private EditText mince, mincovnik, poskodene, nakladyRano, naklady1, naklady2,zalohy1, zalohy2,
                kolesoRano, kolesoVecer, fiveHundredPocet, twoHundredPocet, oneHundredPocet, fiftyPocet,
                twentyPocet, tenPocet, fivePocet;
        private TextView minceSpolu, nakladySpolu, kolesoSpolu, spoluHodnota, inventuraHodnota,
                fiveHundredSpolu, twoHundredSpolu, oneHundredSpolu, fiftySpolu, twentySpolu, tenSpolu,
                fiveSpolu, hotovost, vyslednaHodnota, tringelt;

        private SharedPreferences sharedPreferences;
        private DecimalFormat decimalFormat;
        private Button inventuraButton, strojeButton; // endregion

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.trezor);

            // Inicializácia formátovania čísel a sharedPerferences
            decimalFormat = new DecimalFormat("#.##");
            sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

            // region Inicializácia prvkov z layoutu . . .
            mince = findViewById(R.id.minceId);
            mincovnik = findViewById(R.id.mincovnikId);
            minceSpolu = findViewById(R.id.minceSpoluId);

            poskodene = findViewById(R.id.poskodeneId);

            nakladyRano = findViewById(R.id.nakladyRanoId);
            naklady1 = findViewById(R.id.naklady1Id);
            naklady2 = findViewById(R.id.naklady2Id);
            nakladySpolu = findViewById(R.id.nakladySpoluId);

            zalohy1 = findViewById(R.id.zalohy1Id);
            zalohy2 = findViewById(R.id.zalohy2Id);

            kolesoRano = findViewById(R.id.kolesoRanoId);
            kolesoVecer = findViewById(R.id.kolesoVecerId);
            kolesoSpolu = findViewById(R.id.kolesoSpoluId);

            spoluHodnota = findViewById(R.id.spoluHodnotaId);

            inventuraHodnota = findViewById(R.id.inventuraHodnotaId);

            fiveHundredPocet = findViewById(R.id.fiveHundredPocetId);
            fiveHundredSpolu = findViewById(R.id.fiveHundredSpoluId);
            twoHundredPocet = findViewById(R.id.twoHundredPocetId);
            twoHundredSpolu = findViewById(R.id.twoHundredSpoluId);
            oneHundredPocet = findViewById(R.id.oneHundredPocetId);
            oneHundredSpolu = findViewById(R.id.oneHundredSpoluId);
            fiftyPocet = findViewById(R.id.fiftyPocetId);
            fiftySpolu = findViewById(R.id.fiftySpoluId);
            twentyPocet = findViewById(R.id.twentyPocetId);
            twentySpolu = findViewById(R.id.twentySpoluId);
            tenPocet = findViewById(R.id.tenPocetId);
            tenSpolu = findViewById(R.id.tenSpoluId);
            fivePocet = findViewById(R.id.fivePocetId);
            fiveSpolu = findViewById(R.id.fiveSpoluId);
            hotovost = findViewById(R.id.hotovostId);

            vyslednaHodnota = findViewById(R.id.vyslednaHodnotaId);
            tringelt = findViewById(R.id.tringeltId);
            inventuraButton = findViewById(R.id.ButtonInventuraId);
            strojeButton = findViewById(R.id.ButtonStrojeId); //endregion

            // region Načítanie údajov zo SharedPreferences . . .
            String minceShared = sharedPreferences.getString("mince", "");
            String mincovnikShared = sharedPreferences.getString("mincovnik", "");
            String poskodeneShared = sharedPreferences.getString("poskodene", "");
            String nakladyRanoShared = sharedPreferences.getString("nakladyRano", "");
            String naklady1Shared = sharedPreferences.getString("naklady1", "");
            String naklady2Shared = sharedPreferences.getString("naklady2", "");
            String zalohy1Shared = sharedPreferences.getString("zalohy1", "");
            String zalohy2Shared = sharedPreferences.getString("zalohy2", "");
            String kolesoRanoShared = sharedPreferences.getString("kolesoRano", "");
            String kolesoVecerShared = sharedPreferences.getString("kolesoVecer", "");
            String inventuraHodnotaShared = sharedPreferences.getString("inventuraHodnota","");

            String fiveHundredPocetShared = sharedPreferences.getString("fiveHundredPocet", "");
            String twoHundredPocetShared = sharedPreferences.getString("twoHundredPocet", "");
            String oneHundredPocetShared = sharedPreferences.getString("oneHundredPocet", "");
            String fiftyPocetShared = sharedPreferences.getString("fiftyPocet", "");
            String twentyPocetShared = sharedPreferences.getString("twentyPocet", "");
            String tenPocetShared = sharedPreferences.getString("tenPocet", "");
            String fivePocetShared = sharedPreferences.getString("fivePocet", ""); //endregion

            // region Nastavenie údajov do EditText-ov  . . .
            mince.setText(minceShared);
            mincovnik.setText(mincovnikShared);
            poskodene.setText(poskodeneShared);
            nakladyRano.setText(nakladyRanoShared);
            naklady1.setText(naklady1Shared);
            naklady2.setText(naklady2Shared);
            zalohy1.setText(zalohy1Shared);
            zalohy2.setText(zalohy2Shared);
            kolesoRano.setText(kolesoRanoShared);
            kolesoVecer.setText(kolesoVecerShared);
            inventuraHodnota.setText(inventuraHodnotaShared);

            fiveHundredPocet.setText(fiveHundredPocetShared);
            twoHundredPocet.setText(twoHundredPocetShared);
            oneHundredPocet.setText(oneHundredPocetShared);
            fiftyPocet.setText(fiftyPocetShared);
            twentyPocet.setText(twentyPocetShared);
            tenPocet.setText(tenPocetShared);
            fivePocet.setText(fivePocetShared);

            // Výpočet a zobrazenie textViewov
            try {
                double minceSpoluHodnota = Double.parseDouble(minceShared.isEmpty() ? "0" : minceShared) +
                        Double.parseDouble(mincovnikShared.isEmpty() ? "0" : mincovnikShared);
                minceSpolu.setText(decimalFormat.format(minceSpoluHodnota));

                double nakladySpoluHodnota = Double.parseDouble(nakladyRanoShared.isEmpty() ? "0" : nakladyRanoShared) +
                        Double.parseDouble(naklady1Shared.isEmpty() ? "0" : naklady1Shared) +
                        Double.parseDouble(naklady2Shared.isEmpty() ? "0" : naklady2Shared);
                nakladySpolu.setText(decimalFormat.format(nakladySpoluHodnota));

                double kolesoSpoluHondota = Double.parseDouble(kolesoRanoShared.isEmpty() ? "0" : kolesoRanoShared) +
                        Double.parseDouble(kolesoVecerShared.isEmpty() ? "0" : kolesoVecerShared);
                kolesoSpolu.setText(decimalFormat.format(kolesoSpoluHondota));

                double spoluHodnotaHodnota = minceSpoluHodnota + nakladySpoluHodnota + kolesoSpoluHondota +
                    Double.parseDouble(poskodeneShared) + Double.parseDouble(zalohy1Shared) + Double.parseDouble(zalohy2Shared);
                spoluHodnota.setText(decimalFormat.format(spoluHodnotaHodnota));

                double fiveHundredSpoluHodnota = Double.parseDouble(fiveHundredPocetShared.isEmpty() ? "0" : fiveHundredPocetShared) * 500;
                fiveHundredSpolu.setText(decimalFormat.format(fiveHundredSpoluHodnota));
                double twoHundredPocetHodnota = Double.parseDouble(twoHundredPocetShared.isEmpty() ? "0" : twoHundredPocetShared) * 200;
                twoHundredSpolu.setText(decimalFormat.format(twoHundredPocetHodnota));
                double oneHundredPocetHodnota = Double.parseDouble(oneHundredPocetShared.isEmpty() ? "0" : oneHundredPocetShared) * 100;
                oneHundredSpolu.setText(decimalFormat.format(oneHundredPocetHodnota));
                double fiftyPocetHodnota = Double.parseDouble(fiftyPocetShared.isEmpty() ? "0" : fiftyPocetShared) * 50;
                fiftySpolu.setText(decimalFormat.format(fiftyPocetHodnota));
                double twentyPocetHodnota = Double.parseDouble(twentyPocetShared.isEmpty() ? "0" : twentyPocetShared) * 20;
                twentySpolu.setText(decimalFormat.format(twentyPocetHodnota));
                double tenPocethodnota = Double.parseDouble(tenPocetShared.isEmpty() ? "0" : tenPocetShared) * 10;
                tenSpolu.setText(decimalFormat.format(tenPocethodnota));
                double fivePocetHodnota = Double.parseDouble(fivePocetShared.isEmpty() ? "0" : fivePocetShared) * 5;
                fiveSpolu.setText(decimalFormat.format(fivePocetHodnota));

                double hotovostHodnota = fiveHundredSpoluHodnota + twoHundredPocetHodnota +oneHundredPocetHodnota +
                    fiftyPocetHodnota + twentyPocetHodnota + tenPocethodnota + fivePocetHodnota;
                hotovost.setText(decimalFormat.format(hotovostHodnota));

                double vyslednaHodnotaHodnota = spoluHodnotaHodnota + hotovostHodnota;
                vyslednaHodnota.setText(decimalFormat.format(vyslednaHodnotaHodnota));

             // Získanie hodnoty z TextView vyhry a konverzia na číslo
            double inventuraSuma = inventuraHodnota.getText().toString().isEmpty() ? 0 : Double.parseDouble(inventuraHodnota.getText().toString());
            double tringeltHodnota = vyslednaHodnotaHodnota - inventuraSuma;
            tringelt.setText(decimalFormat.format(tringeltHodnota));

            } catch (NumberFormatException e) {
                Log.e("MyApp", "Chyba pri prevode na číslo: " + e.getMessage());
                // Nastav výchoziu hodnotu alebo zobraz chybové hlásenie

            } //endregion

            // region Definujem tlacidla . . .
            inventuraButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Trezor.this, Inventura.class);
                    startActivity(intent);
                }
            });

            strojeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Trezor.this, Stroje.class);
                    startActivity(intent);
                }
            });

            // Získanie Intentu a nastavenie hodnoty z Intentu
            Intent intent = getIntent();
            if (intent.hasExtra("InventuraHodnota")) {
                String sumaStrojov = intent.getStringExtra("InventuraHodnota");
                inventuraHodnota.setText(sumaStrojov);

            }   //endregion

            // region Nastavenie listenera pre zmeny textu . . .
            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    // Vypocet editTextov a ViewTextow
                    double minceHodnota = mince.getText().toString().isEmpty() ? 0 : Double.parseDouble(mince.getText().toString());
                    double mincovnikHodnota = mincovnik.getText().toString().isEmpty() ? 0 : Double.parseDouble(mincovnik.getText().toString());
                    double minceSpoluHodnota = minceHodnota + mincovnikHodnota;
                    minceSpolu.setText(decimalFormat.format(minceSpoluHodnota));

                    double poskodeneHodnota = poskodene.getText().toString().isEmpty() ? 0 : Double.parseDouble(poskodene.getText().toString());

                    double nakladyRanoHodnota = nakladyRano.getText().toString().isEmpty() ? 0 : Double.parseDouble(nakladyRano.getText().toString());
                    double naklady1Hodnota = naklady1.getText().toString().isEmpty() ? 0 : Double.parseDouble(naklady1.getText().toString());
                    double naklady2Hodnota = naklady2.getText().toString().isEmpty() ? 0 : Double.parseDouble(naklady2.getText().toString());
                    double nakladySpoluHodnota = nakladyRanoHodnota + naklady1Hodnota + naklady2Hodnota;
                    nakladySpolu.setText(decimalFormat.format(nakladySpoluHodnota));

                    double zalohy1Hodnota = zalohy1.getText().toString().isEmpty() ? 0 : Double.parseDouble(zalohy1.getText().toString());
                    double zalohy2Hodnota = zalohy2.getText().toString().isEmpty() ? 0 : Double.parseDouble(zalohy2.getText().toString());

                    double kolesoRanoHodnota = kolesoRano.getText().toString().isEmpty() ? 0 : Double.parseDouble(kolesoRano.getText().toString());
                    double kolesoVecerHodnota = kolesoVecer.getText().toString().isEmpty() ? 0 : Double.parseDouble(kolesoVecer.getText().toString());
                    double kolesoSpoluHodnota = kolesoRanoHodnota + kolesoVecerHodnota;
                    kolesoSpolu.setText(decimalFormat.format(kolesoSpoluHodnota));

                    double fiveHundredPocetHodnota = fiveHundredPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(fiveHundredPocet.getText().toString());
                    double fiveHundredSpoluHodnota = fiveHundredPocetHodnota * 500;
                    fiveHundredSpolu.setText(decimalFormat.format(fiveHundredSpoluHodnota));
                    double twoHundredPocetHodnota = twoHundredPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(twoHundredPocet.getText().toString());
                    double twoHundredSpoluHodnota = twoHundredPocetHodnota * 200;
                    twoHundredSpolu.setText(decimalFormat.format(twoHundredSpoluHodnota));
                    double oneHundredPocetHodnota = oneHundredPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(oneHundredPocet.getText().toString());
                    double onehundredSpoluHodnota = oneHundredPocetHodnota * 100;
                    oneHundredSpolu.setText(decimalFormat.format(onehundredSpoluHodnota));
                    double fiftyPocetHodnota = fiftyPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(fiftyPocet.getText().toString());
                    double fiftySpoluHodnota = fiftyPocetHodnota * 50;
                    fiftySpolu.setText(decimalFormat.format(fiftySpoluHodnota));
                    double twentyPocetHodnota = twentyPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(twentyPocet.getText().toString());
                    double twentySpoluHodnota = twentyPocetHodnota * 20;
                    twentySpolu.setText(decimalFormat.format(twentySpoluHodnota));
                    double tenPocetHodnota = tenPocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(tenPocet.getText().toString());
                    double tenSpoluHodnota = tenPocetHodnota * 10;
                    tenSpolu.setText(decimalFormat.format(tenSpoluHodnota));
                    double fivePocetHodnota = fivePocet.getText().toString().isEmpty() ? 0 : Double.parseDouble(fivePocet.getText().toString());
                    double fiveSpoluHodnota = fivePocetHodnota * 5;
                    fiveSpolu.setText(decimalFormat.format(fiveSpoluHodnota));

                    double spoluHodnotaSpolu = minceSpoluHodnota + poskodeneHodnota + nakladySpoluHodnota + zalohy1Hodnota + zalohy2Hodnota
                            + kolesoSpoluHodnota;
                    spoluHodnota.setText(decimalFormat.format(spoluHodnotaSpolu));

                    double hotovostSpoluHodnota = fiveHundredSpoluHodnota + twoHundredSpoluHodnota + onehundredSpoluHodnota +
                            fiftySpoluHodnota + twentySpoluHodnota + tenSpoluHodnota + fiveSpoluHodnota;
                    hotovost.setText(decimalFormat.format(hotovostSpoluHodnota));

                    double vyslednaHodnotaSpolu = spoluHodnotaSpolu + hotovostSpoluHodnota;
                    vyslednaHodnota.setText(decimalFormat.format(vyslednaHodnotaSpolu));

                    // Získanie hodnoty z TextView vyhry a konverzia na číslo
                    double inventuraShared = inventuraHodnota.getText().toString().isEmpty() ? 0 : Double.parseDouble(inventuraHodnota.getText().toString());
                    double tringeltHodnotaSpolu = vyslednaHodnotaSpolu - inventuraShared;
                    tringelt.setText(decimalFormat.format(tringeltHodnotaSpolu));



                    //  region Uloženie zmien do SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("mince", mince.getText().toString());
                    editor.putString("mincovnik", mincovnik.getText().toString());
                    editor.putString("poskodene", poskodene.getText().toString());
                    editor.putString("nakladyRano", nakladyRano.getText().toString());
                    editor.putString("naklady1", naklady1.getText().toString());
                    editor.putString("naklady2", naklady2.getText().toString());
                    editor.putString("zalohy1", zalohy1.getText().toString());
                    editor.putString("zalohy2", zalohy2.getText().toString());
                    editor.putString("kolesoRano", kolesoRano.getText().toString());
                    editor.putString("kolesoVecer", kolesoVecer.getText().toString());
                    editor.putString("inventuraHodnota", inventuraHodnota.getText().toString());
                    editor.putString("fiveHundredPocet", fiveHundredPocet.getText().toString());
                    editor.putString("twoHundredPocet", twoHundredPocet.getText().toString());
                    editor.putString("oneHundredPocet", oneHundredPocet.getText().toString());
                    editor.putString("fiftyPocet", fiftyPocet.getText().toString());
                    editor.putString("twentyPocet", twentyPocet.getText().toString());
                    editor.putString("tenPocet", tenPocet.getText().toString());
                    editor.putString("fivePocet", fivePocet.getText().toString());

                    editor.apply(); //endregion
                }

                @Override
                public void afterTextChanged(Editable s) {}
            };
            // region Priradenie listenera k EditText-om
            //mince.addTextChangedListener(textWatcher);
            mincovnik.addTextChangedListener(textWatcher);
            poskodene.addTextChangedListener(textWatcher);
            nakladyRano.addTextChangedListener(textWatcher);
            naklady1.addTextChangedListener(textWatcher);
            naklady2.addTextChangedListener(textWatcher);
            zalohy1.addTextChangedListener(textWatcher);
            zalohy2.addTextChangedListener(textWatcher);
            kolesoRano.addTextChangedListener(textWatcher);
            kolesoVecer.addTextChangedListener(textWatcher);
            inventuraHodnota.addTextChangedListener(textWatcher);
            fiveHundredPocet.addTextChangedListener(textWatcher);
            twoHundredPocet.addTextChangedListener(textWatcher);
            oneHundredPocet.addTextChangedListener(textWatcher);
            fiftyPocet.addTextChangedListener(textWatcher);
            twentyPocet.addTextChangedListener(textWatcher);
            tenPocet.addTextChangedListener(textWatcher);
            fivePocet.addTextChangedListener(textWatcher);   // endregion
        }
    }
