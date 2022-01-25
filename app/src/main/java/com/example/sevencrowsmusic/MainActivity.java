package com.example.sevencrowsmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //region Atributos
    private TextInputEditText edtNombreCancion;
    private TextInputEditText edtArtista;
    private TextInputEditText edtAlbum;
    private RadioGroup rgTipoMusica;
    private MaterialRadioButton rbGenero;
    private MaterialButton btnGuardar;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.BindingFormulario();
        DatabaseReference referencia = this.CrearReferenciaOrigenDatos();
        referencia.setValue("ENTRO ESTO");
    }

    private void BindingFormulario(){
        this.edtNombreCancion = this.findViewById(R.id.edt_cancion);
        this.edtArtista = this.findViewById(R.id.edt_artista);
        this.edtAlbum = this.findViewById(R.id.edt_album);
        this.rgTipoMusica = this.findViewById(R.id.rg_tipo_musica);
        this.btnGuardar = this.findViewById(R.id.btn_guardar);
    }

    private DatabaseReference CrearReferenciaOrigenDatos(){
        FirebaseDatabase instancia = FirebaseDatabase.getInstance();
        return instancia.getReference("Musica");
    }
}