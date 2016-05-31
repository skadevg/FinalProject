package com.project.cibertec.finalproject.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.cibertec.finalproject.R;

public class ClientesNuevoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextInputLayout tilSecondName, tilSecondLast, tilSecondDoc, tilSecondAge;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientes_nuevo_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.tituloClienteNuevo);

    /*    tilSecondName = (TextInputLayout) findViewById(R.id.tilSecondNombre);
        tilSecondLast = (TextInputLayout) findViewById(R.id.tilSecondApellido);
        tilSecondDoc = (TextInputLayout) findViewById(R.id.tilSecondDni);
        tilSecondAge = (TextInputLayout) findViewById(R.id.tilSecondEdad);*/
//        tilSecondPhone = (TextInputLayout) findViewById(R.id.tilSecond);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragMap);
        mapFragment.getMapAsync(ClientesNuevoActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Capturo el click de la flecha hacia atrás
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else  //Capturo el click del guardar
            if (item.getItemId() == R.id.abSecondSave) {
                save();
                return true;
            }

        return super.onOptionsItemSelected(item);
    }

    private void save() {
   /*     if (tilSecondName.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su nombre");
        else if (tilSecondLast.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su apellido");
        else if (tilSecondDoc.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su documento");
        else if (tilSecondDoc.getEditText().getText().toString().trim().length() < 8)
            showMessage("Su documento debe ser de 8 dígitos");
        else if (tilSecondAge.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su edad");
        else {      */
//            Person person = new Person();
//            person.setName(tilSecondName.getEditText().getText().toString().trim());
//            person.setLastName(tilSecondLast.getEditText().getText().toString().trim());
//            person.setDoc(tilSecondDoc.getEditText().getText().toString().trim());
//            person.setAge(Integer.parseInt(tilSecondAge.getEditText().getText().toString().trim()));
//            person.setPhone(tilSecondPhone.getEditText().getText().toString().trim());
            Intent intent = new Intent();
//            intent.putExtra("person", person);
            setResult(RESULT_OK, intent);
            finish();
   //     }
    }

    private void showMessage(String message) {
        new AlertDialog.Builder(ClientesNuevoActivity.this).setTitle(R.string.app_name).setMessage(message).setPositiveButton("Aceptar", null).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mGoogleMap = googleMap;
        mGoogleMap.setOnMapClickListener(mGoogleMapOnMapClickListener);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.087, -77.049489), 17));
    }


    GoogleMap.OnMapClickListener mGoogleMapOnMapClickListener = new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {

            mGoogleMap.clear();
            mGoogleMap.addMarker(new MarkerOptions().position(latLng));
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));

        }
    };

}
