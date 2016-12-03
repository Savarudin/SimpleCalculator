package calculator.dycode.co.id.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Farid on 03/12/2016.
 */

public class MainActivity extends AppCompatActivity {


    //https://github.com/JakeWharton/butterknife
    @BindView(R.id.input1)
    EditText inputOne;

    @BindView(R.id.input2)
    EditText inputTwo;
    @BindView(R.id.button_tambah)
    Button buttonTambah;

    @BindView(R.id.button_kurang)
    Button buttonKurang;

    @BindView(R.id.button_bagi)
    Button buttonBagi;
    @BindView(R.id.text_hasil)
    TextView textHasil;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_tambah, R.id.button_kurang, R.id.button_bagi})
    public void onClick(View view) {
        //getInput
        String getInputOne = inputOne.getText().toString();
        String getInputTwo = inputTwo.getText().toString();

        //cek ketika inputan kosong
        if (TextUtils.isEmpty(getInputOne)) {
            inputOne.setError("Belum Diisi");
            inputOne.requestFocus();
        } else if (TextUtils.isEmpty(getInputTwo)) {
            inputTwo.setError("Belum Diisi");
            inputTwo.requestFocus();
        } else {
            Integer convertInputOne = Integer.parseInt(inputOne.getText().toString());
            Integer convertInputTwo = Integer.parseInt(inputTwo.getText().toString());
            int hasil = 0;

            switch (view.getId()) {
                case R.id.button_tambah:
                    hasil = convertInputOne + convertInputTwo;
                    break;
                case R.id.button_kurang:
                    hasil = convertInputOne - convertInputTwo;
                    break;
                case R.id.button_bagi:
                    hasil = convertInputOne / convertInputTwo;
                    break;
            }
            textHasil.setText(String.valueOf(hasil));
        }
    }
}
