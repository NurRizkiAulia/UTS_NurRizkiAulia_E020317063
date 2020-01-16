package id.ac.poliban.mi.aulia.uts_nurrizkiaulia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String rb;
    String pAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioGroup mRadioGroup = findViewById(R.id.mRadioGroup);
        EditText etNama = findViewById(R.id.etNama);
        EditText etNP = findViewById(R.id.etNP);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        final Spinner spAgama = findViewById(R.id.spAgama);
        RadioButton rbLakiLaki = findViewById(R.id.rbLakiLaki);
        RadioButton rbPerempuan = findViewById(R.id.rbPerempuan);

        String[] agamaa = new String[] {
                "Pilih Agama", "Islam", "Kristen", "Hindu", "Budha", "Konghuchu", "Lainnya"
        };

        ArrayAdapter<String> agama = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, agamaa);
        agama.setDropDownViewResource( android.R.layout.simple_spinner_item);
        spAgama.setAdapter(agama);

        spAgama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pAgama = spAgama.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNama.getText().clear();
                etNP.getText().clear();
                etAlamat.getText().clear();
                etTelp.getText().clear();
                mRadioGroup.clearCheck();
                spAgama.setAdapter(agama);
            }
        });

        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == rbLakiLaki.getId()){
                rb = rbLakiLaki.getText().toString();
            } else {
                rb = rbPerempuan.getText().toString();
            }
        });

        btSubmit.setOnClickListener(view -> new AlertDialog.Builder(this)
                .setTitle("Info Registrasi : ")
                .setMessage(
                        "No Pendaftaran : " + etNP.getText() + "\n" +
                                "Nama : " + etNama.getText() + "\n" +
                                "Jenis Kelamin : " + rb + "\n" +
                                "Agama : " + pAgama + "\n" +
                                "Alamat : " + etAlamat.getText() + "\n" +
                                "Telepon : " + etTelp.getText())
                .setPositiveButton("OK", null)
                .show());
            }
    }